package Controller;
import Method.BuyCard;
import Method.Card.*;
import Method.User.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserServlet", urlPatterns = "/myUser")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        String action;
        action = request.getParameter("action");
        if(action == null){
            action= "";
        }
        switch (action){
            case "register":
                AddNewUser.add(request, response);
                break;
            case "updateUser":
                UpdateUserByID.update(request, response);
                break;
            case "findUser":
                FindUser.find(request, response);
                break;
            case "showAllUser":
                ShowAllUser.show(request, response);
                break;

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");
        if(action == null){
            action= "";
        }
        switch (action){
            case "register":
                ShowFormRegister.show(request, response);
                break;
            case "updateUser":
                ShowFormUpdateUser.show(request, response);
                break;
            case "deleteUser":
                try {
                    DeleteUser.delete(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "buy":
                BuyCard.buy(request, response);
                break;
            case "viewBill":
                BuyCard.pay(request, response);
                break;
            default:
                ShowAllUser.show(request, response);
                break;
        }
    }
}
