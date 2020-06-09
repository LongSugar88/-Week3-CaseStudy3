package Controller;

import Method.FindCardName;
import Method.GetConnection;
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
        String name = request.getParameter("name");
        List<Card> listCard = FindCardName.getCardByName(name);
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
