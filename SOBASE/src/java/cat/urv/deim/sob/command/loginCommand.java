package cat.urv.deim.sob.command;

import cat.urv.deim.sob.model.Crypto;
import cat.urv.deim.sob.service.CryptoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;
import java.util.List;

public class loginCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        // 1. Get input
       
        String view = "views/login.jsp"; 
        String referer = request.getHeader("referer");
        HttpSession session=request.getSession(false);  
        session.setAttribute("referer", referer);
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }
}
