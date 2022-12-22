package cat.urv.deim.sob.command;

import cat.urv.deim.sob.model.User;
import cat.urv.deim.sob.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;

public class signUpFormCommand implements Command {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Get input
        User user = new User();
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setEmail(request.getParameter("email"));
        
        String view = "views/signup-success.jsp";
                
        UserService service = new UserService();
        if (service.findUserByEmail(user) == null) {
            service.addUser(user);
        } else {
            // Try again
            view = "views/signup-form.jsp";
            request.setAttribute("message", "A user with this e-mail address already exists!");
        }
        
        request.setAttribute("user", user);
        
        // 3. produce the view with the web result
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }
}
