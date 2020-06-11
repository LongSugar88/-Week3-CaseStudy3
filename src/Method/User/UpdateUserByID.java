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
import java.sql.SQLException;

public class UpdateUserByID {
    private static final String UPDATE_USER_BY_ID = "UPDATE user SET name = ?, role = ?, password = ? WHERE id = ?";
    public static void update(User user){
        Connection connection = GetConnection.getConnect();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_BY_ID);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getRole());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getId());
            preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void update(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("newID");
        String name = request.getParameter("newName");
        String role = request.getParameter("newRole");
        String password = request.getParameter("newPassword");
        User user = new User(id, name, role, password);
        update(user);
        try{
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("....");
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
