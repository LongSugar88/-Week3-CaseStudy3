package Method;

import Controller.CardController;
import Model.Card;
import User.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetCardByName {
    private static final String GET_CARD_BY_NAME = "SELECT * FROM card WHERE name LIKE ?;";
    public static Card getCard(String name){
        Card card = null;
        CardController cardController = new CardController();
        Connection connection = cardController.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(GET_CARD_BY_NAME);
            String query = "%" + name + "%";
            preparedStatement.setString(1, query);
            ResultSet resulset =  preparedStatement.executeQuery();
            while (resulset.next()){
                String card_Id = resulset.getString("id");
                String card_Name = resulset.getString("name");
                Double card_Price = Double.parseDouble(resulset.getString("price"));
                Integer card_Quantity = Integer.parseInt(resulset.getString("quantity"));
                card = new Card(card_Id, card_Name, card_Price, card_Quantity);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return card;
    }
}
