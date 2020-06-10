package Method;

import Model.Card;

import javax.servlet.ServletException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateCard {
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
}
