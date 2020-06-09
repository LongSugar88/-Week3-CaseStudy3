package Controller;
import Method.AddCard;
import Model.Card;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddNewCard {
    public static void add(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("newID");
        String name = request.getParameter("newName");
        Double price = Double.parseDouble(request.getParameter("newPrice"));
        Integer quantity = Integer.parseInt(request.getParameter("newQuantity"));
        Card card = new Card(id, name, price, quantity);
        AddCard.addNewCard(card);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/FormAddNewCard.jsp");
        try{
            requestDispatcher.forward(request, response);
        }
        catch(IOException | ServletException e){
            e.printStackTrace();
        }
    }
}
