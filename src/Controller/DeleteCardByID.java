package Controller;

import Method.DeleteCard;
import Method.GetConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteCardByID {
    public static void delete(HttpServletRequest request, HttpServletResponse response ) throws SQLException {
        String id = request.getParameter("id");
        DeleteCard.delete(id);
        ShowListCard.show(request, response);
    }
}
