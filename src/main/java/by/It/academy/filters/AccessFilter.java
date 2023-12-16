package by.It.academy.filters;

import by.It.academy.entities.WorkerType;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/create", "/delete", "/read", "/update", "/updateAction"})
public class AccessFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        Object typeWorker = req.getSession().getAttribute("typeWorker");
        if(WorkerType.ADMIN != typeWorker) req.getRequestDispatcher("/pages/errors/errorAccess.jsp").forward(req, res);
        else chain.doFilter(req, res);
    }
    @Override
    public void destroy() {
    }
}
