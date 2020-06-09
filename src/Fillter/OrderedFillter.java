package Fillter;

import Controller.CardController;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//@WebFilter(filterName = "PermissionFilter", urlPatterns = "/myCard")
public class OrderedFillter implements Filter {

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
                response.sendRedirect("/myUser?action=fdgdfhth");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
