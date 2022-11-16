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
import model.entities.Purchase;
import authn.Secured;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import model.entities.Crypto;

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
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.TEXT_PLAIN})
    public Response makeOrder(@QueryParam("cryptocurrency") String cryptocurrency,String quantity) {
        Purchase p= new Purchase();
        Crypto c=(Crypto) em.createQuery("SELECT c FROM Crypto c WHERE c.id = " + cryptocurrency ).getSingleResult();
        p.setCrypto(c);
        p.setQuantity(Float.parseFloat(quantity));
        float v= (float) em.createQuery("Select c.value from Crypto c where c.id = " + cryptocurrency ).getSingleResult();
        p.setValue((v*Float.parseFloat(quantity)));
        super.create(p);
        
        return Response.ok().entity(p).build(); 
        
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
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response find(@PathParam("id") Long id) {
        return Response.ok().entity(super.find(id)).build();
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
