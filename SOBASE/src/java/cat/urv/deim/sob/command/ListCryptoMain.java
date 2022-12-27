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
import java.util.List;

public class ListCryptoMain implements Command {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Get input
     
       
        
        String view = "views/signup-form.jsp";
                
        CryptoService service= new CryptoService();
        List <Crypto> crypto= service.findCryptos();
        
        request.setAttribute("cryptoList", crypto);
        
        // 3. produce the view with the web result
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }
}
