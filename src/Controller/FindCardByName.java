package Controller;

import Model.Card;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class FindCardByName {
    public static void find(HttpServletRequest request, HttpServletResponse response){
        CardController cardController = new CardController();
        String name = request.getParameter("name");
        List<Card> listCard = cardController.getCardByName(name);
        Connection connection = GetConnection.getConnect();
        request.setAttribute("listCard", listCard);
        RequestDispatcher  requestDispatcher = request.getRequestDispatcher("View/FormFindCard.jsp");
        try{
            requestDispatcher.forward(request, response);
        }
        catch(ServletException | IOException e){
            e.printStackTrace();
        }
    }
}
