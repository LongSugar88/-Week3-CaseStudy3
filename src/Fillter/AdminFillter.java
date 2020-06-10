package Fillter;
import Method.AllCard;
import Model.Card;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@WebFilter(filterName = "PermissionFilter", urlPatterns = "Administrator.jsp")
public class AdminFillter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        Object o = session.getAttribute("role");
        if(o != null){
            String role_user = o.toString();
            if(role_user.equalsIgnoreCase("admin")){
                filterChain.doFilter(servletRequest, servletResponse);
            }
            else {
                PrintWriter printWriter = response.getWriter();
                printWriter.println("ĐCM");

//                List<Card> myList = AllCard.showAllCard();
//                request.setAttribute("myCardList", myList);
//                RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/staff.jsp");
//                requestDispatcher.forward(request, response);
            }
        }
        else{
            PrintWriter printWriter = response.getWriter();
            printWriter.println("ĐCM");
//                List<Card> myList = AllCard.showAllCard();
//                request.setAttribute("myCardList", myList);
//                RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/staff.jsp");
//                requestDispatcher.forward(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
