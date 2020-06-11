package Method;
import Method.Card.FindCard;
import Method.User.FindUser;
import Model.Card;
import Model.User;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BuyCard {
    private static String orderID;
    private static String username;
     public static void execute(User user, Card card){
         String query = "CALL newOrder(?, ?, ?)";
        int quantity = 1;
        String cardID = card.getId();
        String user_ID = user.getId();
        try{
            Connection connection = GetConnection.getConnect();
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setString(1, String.valueOf(quantity));
            callableStatement.setString(2, cardID);
            callableStatement.setString(3, user_ID);
            callableStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
     }
     public static List<Card> getBill(){
         List<Card> myCardList = new ArrayList<>();
         Card card;
         String query = "CALL buildBill()";
         try{
             Connection connection = GetConnection.getConnect();
             CallableStatement callableStatement = connection.prepareCall(query);
             ResultSet resultSet = callableStatement.executeQuery();
             while (resultSet.next()){
                 orderID = resultSet.getString("orderID");
                 username = resultSet.getString("userName");
                 String cardID = resultSet.getString("idCard");
                 String cardname = resultSet.getString("nameCard");
                 Integer quantity = resultSet.getInt("quantity");
                 Double priceCard = resultSet.getDouble("pricecard");
                 card = FindCard.getCardByID(cardID);
                 myCardList.add(new Card(cardID, cardname, priceCard, quantity, card.getImage()));
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return myCardList;
     }
     public static void buy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         HttpSession httpSession = request.getSession();
         Object o = httpSession.getAttribute("is_login");
         Object userName = httpSession.getAttribute("name");
         User user = FindUser.getUserByName(userName.toString());
         if(o!= null){
             Boolean is_login = Boolean.parseBoolean(o.toString());
             if(is_login){
                 String id = request.getParameter("id");

                 Card card = FindCard.getCardByID(id);
                 execute(user, card);
             }
         }
         else {
             request.setAttribute("message", "Bạn cần đăng nhập để order! ");
             RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/Login.jsp");
             requestDispatcher.forward(request, response);
         }
     }
     public static void pay(HttpServletRequest request, HttpServletResponse response){
         List<Card> myList = getBill();
         request.setAttribute("myCardList", myList);
         request.setAttribute("userName", username);
         request.setAttribute("billID", orderID);
         RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/Pay.jsp");
         try {
             requestDispatcher.forward(request, response);
         } catch (ServletException | IOException e) {
             e.printStackTrace();
         }
     }
}
