package Method;

import Controller.UserController;
import User.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login {
    public static void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_name = request.getParameter("username");
        String user_password = request.getParameter("password");
        User user = UserController.getUserByName(user_name);
        if (user.getPassword().equalsIgnoreCase(user_password)) {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("role", user.getRole());
            httpSession.setAttribute("is_login", true);
            httpSession.setAttribute("name", user.getName());
            if (user.getRole().equalsIgnoreCase("admin")) {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/Admin.jsp");
                requestDispatcher.forward(request, response);
            } else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/staff.jsp");
                requestDispatcher.forward(request, response);
            }
        } else {
            request.setAttribute("message", "Đăng nhập không thành công");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/login.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
