//package by.It.academy.filters;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.awt.*;
//import java.io.IOException;
//
//@WebFilter(urlPatterns = "/read")
//public class AdminFilter extends HttpFilter {
//    @Override
//    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
//        if(req.getSession().getAttribute("userType") == "ADMIN"){
//            Button attribute = (Button) req.getAttribute("editCourier");
//            attribute.setVisible(false);
//
//            req.getRequestDispatcher("/read").forward(req, res);
//
//        }
//        else {chain.doFilter(req, res);}
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
