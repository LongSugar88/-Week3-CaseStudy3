package Method;
import Method.AllCard;
import Model.Card;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowListCard {
    public static void show(HttpServletRequest request, HttpServletResponse response) {
        List<Card> myList = AllCard.showAllCard();
        request.setAttribute("myCardList", myList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/Admin.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
