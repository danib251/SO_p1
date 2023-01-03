package cat.urv.deim.sob.service;

import cat.urv.deim.sob.model.Crypto;
import cat.urv.deim.sob.model.User;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import java.util.List;
        
public class CryptoService {
    private WebTarget webTarget;
    private jakarta.ws.rs.client.Client client;
    private static final String BASE_URI = "http://localhost:8080/Homework1/rest/api/v1";
    
    public CryptoService() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("cryptocurrency");
    }
    
    public List<Crypto> findCryptos(String order){
        
        Response response = webTarget.queryParam("order", order).request(MediaType.APPLICATION_JSON).get();
        return response.readEntity(new GenericType<List<Crypto>>() {});
    }
    
    public Crypto findCrypto(String id){
        
        Response response = webTarget.path(id) .request(MediaType.APPLICATION_JSON).get();
        return response.readEntity(Crypto.class);
    }
	
   
               

}
