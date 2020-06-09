package Controller;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowFormAddNewCard {
    public static void show(HttpServletRequest request, HttpServletResponse response){
        RequestDispatcher requestDepart = request.getRequestDispatcher("View/FormAddNewCard.jsp");
        try{
            requestDepart.forward(request, response);
        }
        catch(ServletException | IOException e){
            e.printStackTrace();
        }
    }
}
