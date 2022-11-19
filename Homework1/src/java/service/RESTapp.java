package service;

import jakarta.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@jakarta.ws.rs.ApplicationPath("/rest/api/v1")
public class RESTapp extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(CryptoFacadeREST.class);
        classes.add(CommentFacadeREST.class);
        classes.add(CustomerFacadeREST.class);
        classes.add(UserFacadeREST.class);
        classes.add(AbstractFacade.class);
        classes.add(PurchaseFacadeREST.class);
        return classes;
    }
}
