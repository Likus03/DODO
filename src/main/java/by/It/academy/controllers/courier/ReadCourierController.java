package by.It.academy.controllers.courier;

import by.It.academy.entities.Courier;
import by.It.academy.services.courier.CourierService;
import by.It.academy.services.courier.CourierServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/couriers/read")
public class ReadCourierController extends HttpServlet {
    private static final String COURIERS_PAGE = "/pages/couriers/readCouriers.jsp";
    private final CourierService courierService = CourierServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Courier> couriers = courierService.readCourier();

        req.setAttribute("couriers", couriers);
        req.getRequestDispatcher(COURIERS_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
