package Method;

import Controller.CardController;
import Controller.GetConnection;
import Model.Card;
import User.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetCardByName {
    private static final String GET_CARD_BY_NAME = "SELECT * FROM card WHERE name LIKE ?;";
    public List<Card> getCardByName(String name){
        Card card = null;
        List<Card> myList = new ArrayList<>();
        try{
            Connection connection = GetConnection.getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_CARD_BY_NAME);
            String nameCard = "%" + name + "%";
            preparedStatement.setString(1, nameCard);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String card_id = resultSet.getString("id");
                String card_name = resultSet.getString("name");
                Double card_price = Double.parseDouble(resultSet.getString("price"));
                Integer card_quantity = Integer.parseInt(resultSet.getString("quantity"));
                card = new Card(card_id, card_name, card_price, card_quantity);
                myList.add(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myList;
    }
}
