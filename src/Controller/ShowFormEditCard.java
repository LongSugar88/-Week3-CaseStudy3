package Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowFormEditCard {
    public static void show(HttpServletRequest request, HttpServletResponse response){
        try{
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/FormEditCard.jsp");
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
