package Fillter;

import Method.Card.FindCard;
import Method.Card.ShowAllCard;
import Model.Card;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebFilter(filterName = "PermissionFilter", urlPatterns = "/administrator")
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
                List<Card> myList = FindCard.showAllCard();
                request.setAttribute("myCardList", myList);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/Staff.jsp");
                requestDispatcher.forward(request, response);
            }
        }
        else{
                List<Card> myList = FindCard.showAllCard();
                request.setAttribute("myCardList", myList);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/BasicLogin.jsp");
                requestDispatcher.forward(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
