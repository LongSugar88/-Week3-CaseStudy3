package Method.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowFormRegister {
    public static void show(HttpServletRequest request, HttpServletResponse response){
        RequestDispatcher requestDepart = request.getRequestDispatcher("View/FormRegister.jsp");
        try{
            requestDepart.forward(request, response);
        }
        catch(ServletException | IOException e){
            e.printStackTrace();
        }
    }
}
