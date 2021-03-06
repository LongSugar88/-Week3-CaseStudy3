package Method.User;

import Method.Card.ShowAllCard;
import Method.GetConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteUser {
    private static final String DELETE_USER_BY_ID = "DELETE FROM user WHERE id = ?";
    public static void delete(String id) throws SQLException {
        Connection connection = GetConnection.getConnect();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID );
        preparedStatement.setString(1, id);
        preparedStatement.executeUpdate();
    }
    public static void delete(HttpServletRequest request, HttpServletResponse response ) throws SQLException {
        String id = request.getParameter("id");
        delete(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/ShowAllUser.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
