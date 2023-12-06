package by.It.academy.controllers.courier;

import by.It.academy.entities.Courier;
import by.It.academy.services.courier.CourierService;
import by.It.academy.services.courier.CourierServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@WebServlet(urlPatterns = "/couriers/authorization")
public class AuthorizationCourierController extends HttpServlet {

    CourierService courierService = CourierServiceImpl.getInstance();
    List<Courier> couriers;
    HttpSession session = null;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        couriers = courierService.readCourier();
        req.setAttribute("couriers", couriers);

        Optional<Courier> user = getLogInId(req.getParameter("login"), req.getParameter("password"));

        if (user.isEmpty()) {
            req.getRequestDispatcher("/pages/errors/errorLogIn.jsp").forward(req, resp);
        } else {
            session = req.getSession(true);
            session.setAttribute("userType", user.get().getUserType());
            req.getRequestDispatcher("/pages/couriers/readCouriers.jsp").forward(req,resp);
        }
    }

    private Optional<Courier> getLogInId(String login, String password) {
        return couriers.stream()
                .filter(courier -> (Objects.equals(courier.getLogin(), login) && Objects.equals(courier.getPassword(), password)))
                .findFirst();
    }

}
