package Method;
import Model.Card;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddCard {
    private static final String ADD_NEW_CARD = "INSERT INTO card(id, name, price, quantity) VALUES (? , ?, ?, ?);";
    public static void addNewCard(Card card){
        String id = card.getId();
        String name = card.getName();
        String price = String.valueOf(card.getPrice());
        String quantity = String.valueOf(card.getQuantity());
        try{
            Connection connection = GetConnection.getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_CARD);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, price);
            preparedStatement.setString(4, quantity);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
