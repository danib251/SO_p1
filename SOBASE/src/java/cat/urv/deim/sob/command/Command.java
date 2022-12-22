package cat.urv.deim.sob.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;

public interface Command {

    public void execute(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException;
}
