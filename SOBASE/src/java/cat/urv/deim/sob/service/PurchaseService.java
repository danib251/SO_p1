package cat.urv.deim.sob.service;

import cat.urv.deim.sob.model.Crypto;
import cat.urv.deim.sob.model.Purchase;
import jakarta.ws.rs.client.Entity;
import static jakarta.ws.rs.client.Entity.entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.HttpHeaders;
import java.util.List;
        
public class PurchaseService {
    private WebTarget webTarget;
    private jakarta.ws.rs.client.Client client;
    private static final String BASE_URI = "http://localhost:8080/Homework1/rest/api/v1";
    
    public PurchaseService() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("order");
    }
    
    public Purchase buy(String id, Purchase entity,String credentials){
        WebTarget resource = (WebTarget) webTarget.queryParam("cryptocurrency", id);//.request(MediaType.APPLICATION_JSON).post(Entity.json(entity));
        
        Response response = resource.request(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION, "Basic " + credentials).post(Entity.entity(entity, MediaType.APPLICATION_JSON));
        
        return (response.getStatus() == 200) ? response.readEntity(Purchase.class) : null;
    }
    
 
	
   
               

}
