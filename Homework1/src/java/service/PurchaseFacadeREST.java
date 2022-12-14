package service;

import Support.Message;
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
import model.entities.Purchase;
import authn.Secured;
import com.sun.xml.messaging.saaj.util.Base64;
import jakarta.json.stream.JsonParsingException;
import jakarta.persistence.NoResultException;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import java.util.Date;
import java.util.Objects;
import java.util.StringTokenizer;
import model.entities.Crypto;
import model.entities.Customer;

@Stateless
@Path("order")
public class PurchaseFacadeREST extends AbstractFacade<Purchase> {

    @PersistenceContext(unitName = "Homework1PU")
    private EntityManager em;

    public PurchaseFacadeREST() {
        super(Purchase.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Purchase entity) {
        super.create(entity);
    }
    
    @POST
    @Secured
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response makeOrder(@HeaderParam("Authorization") String auth,@QueryParam("cryptocurrency") String cryptocurrency,Purchase entity) {
        
        float value;
        Purchase purchase= new Purchase();
        Customer cust;
        Crypto crypto;
        
        String decode = Base64.base64Decode(auth.replace("Basic ", ""));
        StringTokenizer tokenizer = new StringTokenizer(decode, ":");
        String user = tokenizer.nextToken();
        try{          
            float quantity = entity.getQuantity();
            if (quantity <= 0){
                 return Response.status(Response.Status.BAD_REQUEST).entity("invalid input").build();
            }
            cust=(Customer) em.createQuery("SELECT c FROM Customer c WHERE c.credentials.username = :user").setParameter("user", user).getSingleResult();   
            crypto=(Crypto) em.createQuery("SELECT c FROM Crypto c WHERE c.id = " +cryptocurrency).getSingleResult();
            value= (float) em.createQuery("Select c.value from Crypto c where c.id = " + cryptocurrency ).getSingleResult();
            
            purchase.setCrypto(crypto.getName());
            purchase.setQuantity(quantity);
            purchase.setValue((value*quantity));
            purchase.setTime(new Date());
            super.create(purchase);
            crypto.setPurcharses(purchase);
            cust.addPurchase(purchase);
            return Response.ok().entity(purchase).build(); 
        }catch(NoResultException e){
          return Response.status(Response.Status.BAD_REQUEST).entity(new Message("crypto doesen't exist")).build();
        
        }catch(JsonParsingException e){
          return Response.status(Response.Status.BAD_REQUEST).entity(new Message("Incorrect parameter format")).build();
        }
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Purchase entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Secured
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response find(@PathParam("id") Long id) {
         if (Objects.nonNull(super.find(id)))
            return Response.ok().entity(super.find(id)).build();
         return Response.status(Response.Status.BAD_REQUEST).entity(new Message("Purchase doesen't exist")).build();
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Purchase> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Purchase> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
