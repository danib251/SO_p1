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
import model.entities.Crypto;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import java.util.Objects;

@Stateless
@Path("cryptocurrency")
public class CryptoFacadeREST extends AbstractFacade<Crypto> {

    @PersistenceContext(unitName = "Homework1PU")
    private EntityManager em;

    public CryptoFacadeREST() {
        super(Crypto.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Crypto entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Crypto entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response find(@PathParam("id") Long id) {
        
        if (Objects.nonNull(super.find(id)))
            return Response.ok().entity(super.find(id)).build();
        else{
            return Response.status(Response.Status.BAD_REQUEST).entity(new Message("crypto doesen't exist")).build();
        }
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response getCrypto(@QueryParam("order") String order) {
        
        if(order==null){
              order="desc";
        }
        if(order.equals("desc")||order.equals("asc")){
            List<Crypto> resultList=em.createQuery("Select c from Crypto as c order by c.value "+order).getResultList();
             return Response.ok().entity(resultList).build(); 
        }else{
            return Response.status(Response.Status.BAD_REQUEST).entity(new Message("incorrect parameter")).build();
        }
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Crypto> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
