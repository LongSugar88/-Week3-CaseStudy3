package Controller;
import Method.UpdateCard;
import Model.Card;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class UpdateCardByID {
    public static void update(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        String newName = request.getParameter("newName");
        Double newPrice = Double.parseDouble(request.getParameter("newPrice"));
        Integer newQuantity = Integer.parseInt(request.getParameter("newQuantity"));
        Card card = new Card(id, newName, newPrice, newQuantity);
        UpdateCard.update(card);
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
