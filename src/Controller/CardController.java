package Controller;

import Model.Card;
import User.User;

import java.sql.*;
import java.util.List;

public class CardController {
    private String url = "jdbc:mysql://localhost:3306/my_card_shop";
    private String  userName = "root";
    private String password = "131071";
    private final String GET_USER_BY_NAME = "select * from userInformation where name = ?";
    private final String ADD_NEW_CARD = "INSERT INTO card(id, name, price, quantity) VALUES (? , ?', ?, ?);";

    public Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public void showAllCard(){
        List<Card>
    }
    public User getUserByName(String name){
        User user = null;
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String user_name = resultSet.getString("name");
                String user_role = resultSet.getString("role");
                String user_password = resultSet.getString("password");
                user = new User(user_name, user_role, user_password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public void addNewCard(Card card){
        String id = card.getId();
        String name = card.getName();
        String price = String.valueOf(card.getPrice());
        String quantity = String.valueOf(card.getQuantity());
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_CARD);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, price);
            preparedStatement.setString(4, quantity);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
