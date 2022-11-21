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
    @Produces({MediaType.TEXT_PLAIN})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("id") Long id, Customer entity) {
        
        super.edit(entity);
        return Response.ok().entity("User has been updated").build();
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

   
    
    @GET
    @Secured
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response find(@PathParam("id") Long id) {
        //Gson g = new Gson();
        Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        Customer c=super.find(id);
        String s = g.toJson(c);
        if (Objects.isNull(s)) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Customer doesen't exist").build();
        } 
        return Response.ok(s).build();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response findCustomers()  {
        Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        List <Customer> c=super.findAll();
        String s = g.toJson(c);
        return Response.ok(s).build(); 
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
