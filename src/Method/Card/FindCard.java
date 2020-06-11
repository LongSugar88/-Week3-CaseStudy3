package Method.Card;

import Method.GetConnection;
import Model.Card;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FindCard {
    private static final String GET_CARD_BY_NAME = "SELECT * FROM card WHERE name LIKE ?;";
    private static final String GET_CARD_BY_ID = "SELECT * FROM card WHERE id = ?;";
    private static final String GET_ALL_CARD = "SELECT * FROM card";
    public static List<Card> showAllCard() {
        List<Card> mylist = new ArrayList<>();
        try {
            Connection connection = GetConnection.getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CARD);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                double price = Double.parseDouble(resultSet.getString("price"));
                int quantity = Integer.parseInt(resultSet.getString("quantity"));
                String image = resultSet.getString("image");
                mylist.add(new Card(id, name, price, quantity, image));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mylist;
    }
    public static List<Card> getCardByName(String name){
        Card card = null;
        List<Card> myList = new ArrayList<>();
        try{
            ResultSet resultSet;
            Connection connection = GetConnection.getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_CARD_BY_NAME);
            String nameCard = "%" + name + "%";
            preparedStatement.setString(1, nameCard);
            resultSet = preparedStatement.executeQuery();
            if(resultSet == null){
                PreparedStatement statement = connection.prepareStatement(GET_CARD_BY_ID);
                statement.setString(1, name);
                resultSet = statement.executeQuery();
            }
            while (resultSet.next()){
                String card_id = resultSet.getString("id");
                String card_name = resultSet.getString("name");
                Double card_price = Double.parseDouble(resultSet.getString("price"));
                Integer card_quantity = Integer.parseInt(resultSet.getString("quantity"));
                String card_image = resultSet.getString("image");
                card = new Card(card_id, card_name, card_price, card_quantity, card_image);
                myList.add(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myList;
    }
    public static Card getCardByID(String id){
        Card card = null;
        try{
            ResultSet resultSet;
            Connection connection = GetConnection.getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_CARD_BY_ID);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String card_id = resultSet.getString("id");
                String card_name = resultSet.getString("name");
                Double card_price = Double.parseDouble(resultSet.getString("price"));
                Integer card_quantity = Integer.parseInt(resultSet.getString("quantity"));
                String card_image = resultSet.getString("image");
                card = new Card(card_id, card_name, card_price, card_quantity, card_image);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return card;
    }
    public static void find(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("cardName");
        String address = request.getParameter("address");
        List<Card> listCard = getCardByName(name);
        request.setAttribute("myCardList", listCard);
        RequestDispatcher  requestDispatcher = request.getRequestDispatcher(address);
        try{
            requestDispatcher.forward(request, response);
        }
        catch(ServletException | IOException e){
            e.printStackTrace();
        }
    }
}
