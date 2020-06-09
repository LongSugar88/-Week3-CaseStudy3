package Controller;

import Model.Card;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CardServlet", urlPatterns = "/myCard")
public class CardServlet extends HttpServlet {
    private CardController cardController;
    public void init(){
        cardController = new CardController();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action;
        action = request.getParameter("action");
        if(action == null){
            action= "";
        }
        switch (action){
            case "...":
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
                break;
            default:
                showListCard(request, response);
                break;
        }
    }
    public void showListCard(HttpServletRequest request, HttpServletResponse response){
        List<Card> myList = cardController.showAllCard();
        request.setAttribute("myCardList", myList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listCard.jsp");
        try{
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
