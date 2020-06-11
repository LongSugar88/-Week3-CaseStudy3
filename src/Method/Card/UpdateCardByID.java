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


public class UpdateCardByID {
    private static final String UPDATE_CARD_BY_ID = "UPDATE card SET name = ?, price = ?, quantity = ?, image = ? WHERE id = ?";
    public static void update(Card card){
        Connection connection = GetConnection.getConnect();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CARD_BY_ID);
            preparedStatement.setString(1, card.getName());
            preparedStatement.setString(2, String.valueOf(card.getPrice()));
            preparedStatement.setString(3, String.valueOf(card.getQuantity()));
            preparedStatement.setString(4, card.getImage());
            preparedStatement.setString(5, card.getId());
            preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void update(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        String newName = request.getParameter("newName");
        Double newPrice = Double.parseDouble(request.getParameter("newPrice"));
        Integer newQuantity = Integer.parseInt(request.getParameter("newQuantity"));
        String image = request.getParameter("newImage");
        Card card = new Card(id, newName, newPrice, newQuantity, image);
        update(card);
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
