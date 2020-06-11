package Method;
import Method.User.FindUser;
import Model.User;
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
        User user = FindUser.getUserByName(user_name);
        if(user != null){
            if (user.getPassword().equalsIgnoreCase(user_password)) {
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("role", user.getRole());
                httpSession.setAttribute("is_login", true);
                httpSession.setAttribute("name", user.getName());
                if (user.getRole().equalsIgnoreCase("admin")) {
                    request.setAttribute("nameUser",user.getName());
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/Admin.jsp");
                    requestDispatcher.forward(request, response);
                }
                else if(user.getRole().equalsIgnoreCase("customer")){
                    request.setAttribute("nameUser",user.getName());
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/Customer.jsp");
                    requestDispatcher.forward(request, response);
                }
                else {
                    request.setAttribute("nameUser",user.getName());
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/Staff.jsp");
                    requestDispatcher.forward(request, response);
                }
            } else {
                request.setAttribute("message", "Đăng nhập không thành công");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/Login.jsp");
                requestDispatcher.forward(request, response);
            }
        }
        else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/Login.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
