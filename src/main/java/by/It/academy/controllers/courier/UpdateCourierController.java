package by.It.academy.controllers.courier;

import by.It.academy.entities.Courier;
import by.It.academy.repositories.courier.CourierRepositoryImpl;
import by.It.academy.services.courier.CourierService;
import by.It.academy.services.courier.CourierServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/couriers/update")
public class UpdateCourierController extends HttpServlet {
    private static final String COURIERS_PAGE = "/pages/couriers/updateCouriers.jsp";
    List<Courier> couriers;
    private final CourierService courierService = CourierServiceImpl.getInstance();
    private String id;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        couriers = courierService.readCourier();
        id = req.getParameter("radioGroup");

        req.setAttribute("courier", couriers.get(Integer.parseInt(id) - 1));
        req.getRequestDispatcher(COURIERS_PAGE).forward(req, resp);
    }
}
