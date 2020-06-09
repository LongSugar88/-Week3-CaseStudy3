package Method;

import Model.Card;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FindCard {
    private static final String GET_CARD_BY_NAME = "SELECT * FROM card WHERE name LIKE ?;";
    private static final String GET_CARD_BY_ID = "SELECT * FROM card WHERE id = ?;";
    public static List<Card> getCardByName(String name){
        Card card = null;
        List<Card> myList = new ArrayList<>();
        try{
            ResultSet resultSet;
            Connection connection = GetConnection.getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_CARD_BY_NAME);
            String nameCard = "%" + name + "%";
            preparedStatement.setString(1, nameCard);
            resultSet = preparedStatement.executeQuery();
            if(resultSet == null){
                PreparedStatement statement = connection.prepareStatement(GET_CARD_BY_ID);
                statement.setString(1, name);
                resultSet = statement.executeQuery();
            }
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
    public static Card getCardByID(String id){
        Card card = null;
        try{
            ResultSet resultSet;
            Connection connection = GetConnection.getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_CARD_BY_ID);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String card_id = resultSet.getString("id");
                String card_name = resultSet.getString("name");
                Double card_price = Double.parseDouble(resultSet.getString("price"));
                Integer card_quantity = Integer.parseInt(resultSet.getString("quantity"));
                card = new Card(card_id, card_name, card_price, card_quantity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return card;
    }

}
