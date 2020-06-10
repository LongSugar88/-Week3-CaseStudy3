package Method.Delete;
import Method.GetConnection;
import Model.Card;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteCard {
    private static final String DELETE_CARD_BY_ID = "DELETE FROM card WHERE id = ?";
    public static void delete(String id) throws SQLException {
        Connection connection = GetConnection.getConnect();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CARD_BY_ID);
        preparedStatement.setString(1, id);
        preparedStatement.executeUpdate();
    }
}
