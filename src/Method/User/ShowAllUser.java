package Method.User;

import Method.Card.FindCard;
import Model.Card;
import Model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowAllUser {
    public static void show(HttpServletRequest request, HttpServletResponse response) {
        List<User> myList = FindUser.showAllUser();
        request.setAttribute("myUserList", myList);
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
