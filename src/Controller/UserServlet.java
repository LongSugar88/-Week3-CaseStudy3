package Controller;

import User.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UserServlet", urlPatterns = "/myUser")
public class UserServlet extends HttpServlet {
    private CardController cardController;
    public void init(){
        cardController = new CardController();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_name = request.getParameter("username");
        String user_password = request.getParameter("password");
         User user = cardController.getUserByName(user_name);
        if(user_password.equalsIgnoreCase(user.getPassword())){
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("role", user.getRole());
            httpSession.setAttribute("is_login", true);
            response.sendRedirect("/myUser?action=list");
        }
        else{
            request.setAttribute("message", "Đăng nhập không thành công");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
