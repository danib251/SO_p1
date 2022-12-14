package cat.urv.deim.sob.command;

import cat.urv.deim.sob.model.Crypto;
import cat.urv.deim.sob.model.User;
import cat.urv.deim.sob.service.CryptoService;
import cat.urv.deim.sob.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public class RegisterCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        // 1. Get input
        
 
    	//get parameters from request object.
        
        
    	String email = request.getParameter("email").trim();
    	String password = request.getParameter("password").trim();
        String error;
        boolean identified=false;
        
        UserService service= new UserService();
        List <User> userList= service.findUsers();
        String view = null, h1;
        HttpSession session=request.getSession();
        for (User user : userList) {
        if ((user.getCredentials().getUsername().equals(email))&&(user.getCredentials().getPassword().equals(password))) {
              
            session.setAttribute("user",user);
            request.setAttribute("email", user.getCredentials().getUsername());
            identified = true;
            break;
            
        }
        }
        if(identified==false){
           error="Incorrect user/password";
           view = "views/login.jsp"; 
           request.setAttribute("error", error);
            
        }else{
            view = "views/listCrypto.jsp";
        }   
            CryptoService s= new CryptoService();
            List <Crypto> crypto= s.findCryptos("desc");
        
            request.setAttribute("cryptoList", crypto);
            
            
           
           
        // 3. produce the view with the web result
            RequestDispatcher dispatcher = request.getRequestDispatcher(view);
            dispatcher.forward(request, response);    
    }
}
