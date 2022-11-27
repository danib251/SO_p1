package service;

import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.entities.Customer;
import authn.Secured;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.ws.rs.core.Response;
import java.util.Objects;
import static org.json.JSONObject.NULL;




@Stateless
@Path("customer")
public class CustomerFacadeREST extends AbstractFacade<Customer> {

    @PersistenceContext(unitName = "Homework1PU")
    private EntityManager em;

    public CustomerFacadeREST() {
        super(Customer.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Customer entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Secured
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @SuppressWarnings("null")
    public Response edit(@PathParam("id") Long id, Customer entity)  {
        Customer cust=(Customer) em.createQuery("SELECT c FROM Customer c WHERE c.id= :id").setParameter("id", id).getSingleResult();
        
        if (entity.getName()!=NULL)
            cust.setName(entity.getName());
        if (entity.getPhone()!=NULL)
            cust.setPhone(entity.getPhone());
        if(entity.getCredentials().getPassword()!=NULL)
            cust.getCredentials().setPassword(entity.getCredentials().getPassword());
        if(entity.getCredentials().getUsername()!=NULL)
            cust.getCredentials().setUsername(entity.getCredentials().getUsername());
        
        return Response.ok().entity("User has been updated").build();
        
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

   
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response find(@PathParam("id") Long id) {
        //Gson g = new Gson();
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        Customer cutomer=super.find(id);
        String result = gson.toJson(cutomer);
        if (Objects.isNull(result)) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Customer doesen't exist").build();
        }
        return Response.ok(result).build();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response findCustomers()  {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        List <Customer> customerList=super.findAll();
        
        String resultlist = gson.toJson(customerList);
        return Response.ok(resultlist).build(); 
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Customer> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
