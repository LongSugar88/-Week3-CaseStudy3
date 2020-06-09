package Controller;

import Model.Card;
import User.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CardController {
    private String url = "jdbc:mysql://localhost:3306/my_card_shop";
    private String  userName = "root";
    private String password = "131071";
    private final String GET_USER_BY_NAME = "select * from userInformation where name = ?";
    private final String GET_ALL_CARD = "select * from card";

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
    public List<Card> showAllCard(){
        List<Card> mylist = new ArrayList<>();
        try{
            Connection connection = getConnection();
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

}
