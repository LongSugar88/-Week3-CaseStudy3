package Method.User;

import Method.Card.FindCard;
import Model.Card;
import Model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowFormUpdateUser {
    public static void show(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        User user = FindUser.getUserByID(id);
        request.setAttribute("user", user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/FormUpdateUser.jsp");
        try{
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
