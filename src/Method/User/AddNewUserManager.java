package Method.User;

import Method.GetConnection;
import Model.Card;
import Model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddNewUserManager {
    private static final String ADD_NEW_USER = "INSERT INTO user(id, username, role, password) VALUES (? , ?, ?, ?);";
    public static void addNewUser(User user){
        String id = user.getId();
        String name = user.getName();
        String role = user.getRole();
        String password = user.getPassword();
        try{
            Connection connection = GetConnection.getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_USER);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, role);
            preparedStatement.setString(4, password);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void add(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("newID");
        String name = request.getParameter("newName");
        String role = request.getParameter("newRole");
        String password = request.getParameter("newPassword");
        User user = new User(id, name, role, password);
        addNewUser(user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/FormRegister.jsp");
        try{
            requestDispatcher.forward(request, response);
        }
        catch(IOException | ServletException e){
            e.printStackTrace();
        }
    }
}
