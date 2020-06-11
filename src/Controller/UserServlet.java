package Controller;
import Method.BuyCard;
import Method.User.*;
import Model.Card;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/myUser")
public class UserServlet extends HttpServlet {
    private static List<Card> mylist;
    public static List<Card> getList(){
        if(mylist == null){
            mylist = new ArrayList<>();
            return mylist;
        }
        else {
            return mylist;
        }
    }
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
                AddNewUserManager.add(request, response);
                break;
            case "registerCustomer":
                AddNewCustomer.add(request, response);
                break;
            case "updateUser":
                UpdateUserByID.update(request, response);
                break;
            case "findUser":
                FindUser.find(request, response);
                break;
            case "viewBill":
                BuyCard.amount(request, response);
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
            case "registerCustomer":
                ShowFormRegisterCustomer.show(request, response);
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
                BuyCard.viewOrder(request, response);
                break;
            default:
                ShowAllUser.show(request, response);
                break;
        }
    }
}
