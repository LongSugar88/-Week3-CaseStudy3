package Controller;

import Method.GetConnection;
import User.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserController {
    private static final String GET_USER_BY_NAME = "select * from userInformation where name = ?";
    public static User getUserByName(String name){
        User user = null;
        try{
            Connection connection = GetConnection.getConnect();
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
