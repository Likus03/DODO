package by.It.academy.filters;

import by.It.academy.utils.Constants;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;

@WebFilter(urlPatterns = "/logOut")
public class LogOutFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        req.getSession().invalidate();
        req.getRequestDispatcher(Constants.MAIN_PAGE).forward(req, res);

        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }
}
