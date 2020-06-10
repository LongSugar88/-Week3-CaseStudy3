package Method;

import Method.FindCard;
import Model.Card;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FindCardByName {
    public static void find(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("cardName");
        String address = request.getParameter("address");
        List<Card> listCard = FindCard.getCardByName(name);
        request.setAttribute("myCardList", listCard);
        RequestDispatcher  requestDispatcher = request.getRequestDispatcher(address);
        try{
            requestDispatcher.forward(request, response);
        }
        catch(ServletException | IOException e){
            e.printStackTrace();
        }
    }
}
