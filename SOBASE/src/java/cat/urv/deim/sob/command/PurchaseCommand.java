package cat.urv.deim.sob.command;



import cat.urv.deim.sob.model.Crypto;
import cat.urv.deim.sob.model.Purchase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;
import cat.urv.deim.sob.model.User;
import cat.urv.deim.sob.service.PurchaseService;
import java.util.Base64;
import java.util.Base64.Encoder;



public class PurchaseCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        // 1. Get inputquantity
       
        String quantity = request.getParameter("Quantity").trim();
        PurchaseService service= new PurchaseService();
        String path = request.getHeader("referer");
        String id = String.valueOf(path.charAt(path.length()-1));
        
      
        HttpSession session=request.getSession(false);  
        User user = (User) session.getAttribute("user");
        
        String credentials = user.getCredentials().getUsername() +":"+ user.getCredentials().getPassword();
        Encoder encoder = Base64.getEncoder();
        String code = encoder.encodeToString(credentials.getBytes());
        Purchase purchase = new Purchase();
        purchase.setQuantity(Long.parseLong(quantity));
        purchase = service.buy(id, purchase, code);
        
        String view = "views/purchaseInfo.jsp"; 
        request.setAttribute("purchase", purchase);
        
        // 3. produce the view with the web result
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
        
    }
}
