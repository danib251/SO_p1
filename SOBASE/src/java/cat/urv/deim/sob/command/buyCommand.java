package cat.urv.deim.sob.command;

import cat.urv.deim.sob.model.Crypto;
import cat.urv.deim.sob.model.User;
import cat.urv.deim.sob.service.CryptoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;


public class buyCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        // 1. Get input
        String view = "views/buy.jsp";
        User user = new User();
        HttpSession session=request.getSession(false);  
        user = (User) session.getAttribute("user");
        if (user==null)
            view = "views/login.jsp";
        
        CryptoService service= new CryptoService();
        Crypto crypto= service.findCrypto(request.getParameter("id"));
        session.setAttribute("crypto", crypto);
        request.setAttribute("crypto", crypto);
        
        
        // 3. produce the view with the web result
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }
}
