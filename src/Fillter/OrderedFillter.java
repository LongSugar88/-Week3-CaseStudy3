package Fillter;

import Controller.CardController;
import com.sun.net.httpserver.Filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebFilter(filterName = "PermissionFilter", urlPatterns = "/myCard")
public class OrderedFillter {
    public void doFillter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException, SQLException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        Object o = session.getAttribute("role");
        if(o != null){
            String role_user = o.toString();
            if(role_user.equalsIgnoreCase("admin")){
                chain.doFilter(servletRequest, servletResponse);
            }
            else {
                response.sendRedirect("/myUser?action=list");
            }
        }

    }
}
