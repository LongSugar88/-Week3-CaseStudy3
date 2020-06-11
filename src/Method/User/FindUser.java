package Method.User;
import Method.GetConnection;
import Model.Card;
import Model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FindUser {
    private static final String GET_USER_BY_NAME = "SELECT * FROM user WHERE username LIKE ?;";
    private static final String GET_USER_BY_ID = "SELECT * FROM user WHERE id = ?;";
    private static final String GET_ALL_USER = "SELECT * FROM user";
    public static List<User> showAllUser() {
        List<User> mylist = new ArrayList<>();
        try {
            Connection connection = GetConnection.getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("username");
                String role = resultSet.getString("role");
                String password = resultSet.getString("password");
                mylist.add(new User(id, name, role, password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mylist;
    }
    public static User getUserByName(String name){
        User user = null;
        try{
            ResultSet resultSet;
            Connection connection = GetConnection.getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_NAME);
            String username = "%" + name + "%";
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String user_id = resultSet.getString("id");
                String user_name = resultSet.getString("username");
                String user_role = resultSet.getString("role");
                String user_password = resultSet.getString("password");
                user = new User(user_id, user_name, user_role, user_password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public static List<User> getAllUserByName(String name){
        User user = null;
        List<User> mylist = new ArrayList<>();
        try{
            ResultSet resultSet;
            Connection connection = GetConnection.getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_NAME);
            String username = "%" + name + "%";
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String user_id = resultSet.getString("id");
                String user_name = resultSet.getString("username");
                String user_role = resultSet.getString("role");
                String user_password = resultSet.getString("password");
                mylist.add(new User(user_id, user_name, user_role, user_password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mylist;
    }
    public static User getUserByID(String id){
        User user = null;
        try{
            ResultSet resultSet;
            Connection connection = GetConnection.getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String user_id = resultSet.getString("id");
                String user_name = resultSet.getString("username");
                String user_role = resultSet.getString("role");
                String user_password = resultSet.getString("password");
                user = new User(user_id, user_name, user_role, user_password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public static void find(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("username");
        String address = request.getParameter("address");
        List<User> userList = getAllUserByName(name);
        request.setAttribute("userList", userList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(address);
        try{
            requestDispatcher.forward(request, response);
        }
        catch(ServletException | IOException e){
            e.printStackTrace();
        }
    }
}
