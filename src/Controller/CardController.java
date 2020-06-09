package Controller;

import Model.Card;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CardController {
    private final String GET_ALL_CARD = "SELECT * FROM card";
    public List<Card> showAllCard(){
        List<Card> mylist = new ArrayList<>();
        try{
            Connection connection = GetConnection.getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CARD);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                double price = Double.parseDouble(resultSet.getString("price"));
                int quantity = Integer.parseInt(resultSet.getString("quantity"));
                mylist.add(new Card(id, name, price, quantity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mylist;
    }
}
