package cat.urv.deim.sob.command;



import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;
import cat.urv.deim.sob.model.User;

public class customerInfoCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        // 1. Get input
        User user = new User();
        HttpSession session=request.getSession(false);  
        user = (User) session.getAttribute("user");
        
        String view = "views/customerInfo.jsp"; 
        request.setAttribute("user", user);
        
        // 3. produce the view with the web result
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
        
    }
}
