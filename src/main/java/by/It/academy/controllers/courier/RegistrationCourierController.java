package by.It.academy.controllers.courier;

import by.It.academy.entities.Courier;
import by.It.academy.mapper.courier.CourierMapper;
import by.It.academy.services.courier.CourierService;
import by.It.academy.services.courier.CourierServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/couriers/create")
public class RegistrationCourierController extends HttpServlet {
    private static final String COURIERS_PAGE = "/pages/couriers/createCouriers.jsp";
    private final CourierService courierService = CourierServiceImpl.getInstance();
    private final CourierMapper courierMapper = new CourierMapper();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Courier courier = courierMapper.buildUser(req);
        courierService.createCourier(courier);

        req.getRequestDispatcher(COURIERS_PAGE).forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(COURIERS_PAGE).forward(req, resp);

    }
}
