package Controller;
import Method.Card.*;
import Method.User.ShowAllUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CardServlet", urlPatterns = "/myCard")
public class CardServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action;
        action = request.getParameter("action");
        if(action == null){
            action= "";
        }
        switch (action){
            case "add":
                AddNewCard.add(request, response);
                break;
            case "update":
                UpdateCardByID.update(request, response);
                break;
            case "find":
                FindCard.find(request, response);
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
            case "add":
                ShowFormAddNewCard.show(request, response);
                break;
            case "update":
                ShowFormUpdateCard.show(request, response);
                break;
            case "delete":
                try {
                    DeleteCardByID.delete(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "home":
                ShowAllCard.show(request, response);
                break;
            case "showAllUser":
                ShowAllUser.show(request, response);
                break;
        }
    }
}
