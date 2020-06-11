package Method.Card;

import Method.Card.FindCard;
import Model.Card;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowFormUpdateCard {
    public static void show(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        Card card = FindCard.getCardByID(id);
        request.setAttribute("card", card);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/FormEditCard.jsp");
        try{
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
