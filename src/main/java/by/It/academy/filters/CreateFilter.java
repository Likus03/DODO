package by.It.academy.filters;

import by.It.academy.entities.Worker;
import by.It.academy.repositories.Repository;
import by.It.academy.repositories.RepositoryImpl;
import by.It.academy.services.Service;
import by.It.academy.services.ServiceImpl;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebFilter(urlPatterns = "/create")
public class CreateFilter extends HttpFilter {
    private final Service service = ServiceImpl.getInstance();
    List<Worker> workers;

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (checkLogin(req.getParameter("login")).isPresent()) {
            req.getRequestDispatcher("/pages/errors/errorSingUp.jsp").forward(req, res);
        }
        else chain.doFilter(req,res);
    }

    private Optional<Worker> checkLogin(String login) {
        workers = service.read();
        return workers.stream()
                .filter(courier -> courier.getLogin().equals(login))
                .findFirst();
    }

    @Override
    public void destroy() {

    }
}
