package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CardServlet", urlPatterns = "/myCard")
public class CardServlet extends HttpServlet {
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
        String action;
        action = request.getParameter("action");
        if(action == null){
            action= "";
        }
        switch (action){
            case "add":
                break;
            default:

                break;
        }
    }
}
