package Method;
import Controller.UserServlet;
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
    private static List<Card> myList;
    private static UserServlet userServlet = new UserServlet();
    public static boolean addCardToStorage(Card card) {
        if(UserServlet.getList().size() > 0){
            for (Card element : UserServlet.getList()) {
                String id = card.getId();
                if (element.getId().equalsIgnoreCase(id)) {
                    int quantity = element.getQuantity() + 1;
                    element.setQuantity(quantity);
                    return false;
                }
            }
            UserServlet.getList().add(card);
            return true;
        }
        else {
            UserServlet.getList().add(card);
            return true;
        }

    }
    public static void creatBill(){
        List<Card> myListCard = UserServlet.getList();
        User user = FindUser.getUserByName(username);
        for (Card element: myListCard) {
            execute(user, element);
        }
    }
     public static void execute(User user, Card card){
         String query = "CALL newOrder(?, ?, ?)";
        int quantity = card.getQuantity();
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
         Object n = httpSession.getAttribute("name");
         username = n.toString();
         if(o!= null){
             Boolean is_login = Boolean.parseBoolean(o.toString());
             if(is_login){
                 String id = request.getParameter("id");
                 Card card = FindCard.getCardByID(id);
                 String name = card.getName();
                 double price = card.getPrice();
                 int quantity = card.getQuantity();
                 String image = card.getImage();
                 addCardToStorage(new Card(id, name, price, quantity, image));
             }
             RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/Customer.jsp");
             requestDispatcher.forward(request, response);
         }
         else {
             request.setAttribute("message", "Bạn cần đăng nhập để order! ");
             RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/Login.jsp");
             requestDispatcher.forward(request, response);
         }
     }
     public static void viewOrder(HttpServletRequest request, HttpServletResponse response){
         List<Card> myList = UserServlet.getList();
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
    public static void amount(HttpServletRequest request, HttpServletResponse response){
        creatBill();
        List<Card> myList = getBill();
        Double amount = 0.0;
        for (Card element: myList) {
            amount += element.getPrice() * element.getQuantity();
        }
        request.setAttribute("myCardList", myList);
        request.setAttribute("userName", username);
        request.setAttribute("billID", orderID);
        request.setAttribute("amount", amount);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/Amount.jsp");
        myList = null;
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
