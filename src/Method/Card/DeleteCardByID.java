package Method.Card;

import Method.GetConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteCardByID {
    private static final String DELETE_CARD_BY_ID = "DELETE FROM card WHERE id = ?";
    public static void delete(String id) throws SQLException {
        Connection connection = GetConnection.getConnect();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CARD_BY_ID);
        preparedStatement.setString(1, id);
        preparedStatement.executeUpdate();
    }
    public static void delete(HttpServletRequest request, HttpServletResponse response ) throws SQLException {
        String id = request.getParameter("id");
        delete(id);
        ShowAllCard.show(request, response);
    }
}
