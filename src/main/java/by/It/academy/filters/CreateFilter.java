package by.It.academy.filters;

import by.It.academy.entities.Courier;
import by.It.academy.services.courier.CourierService;
import by.It.academy.services.courier.CourierServiceImpl;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebFilter(urlPatterns = "/couriers/create")
public class CreateFilter extends HttpFilter {
    private final CourierService courierService = CourierServiceImpl.getInstance();
    List<Courier> couriers;

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (checkLogin(req.getParameter("login")).isPresent()) {
            req.getRequestDispatcher("/pages/errors/errorSingUp.jsp").forward(req, res);
        }
        else chain.doFilter(req,res);
    }

    private Optional<Courier> checkLogin(String login) {
        couriers = courierService.readCourier();
        return couriers.stream()
                .filter(courier -> courier.getLogin().equals(login))
                .findFirst();
    }

    @Override
    public void destroy() {

    }
}
