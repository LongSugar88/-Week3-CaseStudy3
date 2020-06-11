package Method.Card;
import Method.GetConnection;
import Model.Card;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddNewCard {
    private static final String ADD_NEW_CARD = "INSERT INTO card(id, name, price, quantity, image) VALUES (? , ?, ?, ?, ?);";
    public static void addNewCard(Card card){
        String id = card.getId();
        String name = card.getName();
        String price = String.valueOf(card.getPrice());
        String quantity = String.valueOf(card.getQuantity());
        String image = card.getImage();
        try{
            Connection connection = GetConnection.getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_CARD);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, price);
            preparedStatement.setString(4, quantity);
            preparedStatement.setString(5, image);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void add(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("newID");
        String name = request.getParameter("newName");
        Double price = Double.parseDouble(request.getParameter("newPrice"));
        Integer quantity = Integer.parseInt(request.getParameter("newQuantity"));
        String image = request.getParameter("newImage");
        Card card = new Card(id, name, price, quantity, image);
        addNewCard(card);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/FormAddNewCard.jsp");
        try{
            requestDispatcher.forward(request, response);
        }
        catch(IOException | ServletException e){
            e.printStackTrace();
        }
    }
}
