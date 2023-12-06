package by.It.academy.filters;

import by.It.academy.entities.UserType;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/couriers/update", "/kitchenWorkers/update", "/managers/update"})
public class AccessFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        Object userType = req.getSession().getAttribute("userType");
        if(!UserType.ADMIN.equals(userType)) req.getRequestDispatcher("/pages/errors/errorAccess.jsp").forward(req, res);
        else chain.doFilter(req, res);
    }
    @Override
    public void destroy() {
    }
}
