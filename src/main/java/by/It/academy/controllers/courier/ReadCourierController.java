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
import java.util.List;

@WebServlet(urlPatterns = "/couriers/read")
public class ReadCourierController extends HttpServlet {
    private static final String COURIERS_PAGE = "/pages/couriers/readCouriers.jsp";

    private final CourierMapper courierMapper = new CourierMapper();

    private final CourierService courierService = CourierServiceImpl.getInstance();

    List<Courier> couriers;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        couriers = courierService.readCourier();

        req.setAttribute("couriers", couriers);
        req.getRequestDispatcher(COURIERS_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        Courier courier = courierMapper.buildUser(req);
        //Courier courier = new Courier(Long.valueOf(req.getParameter("id")), req.getParameter("firstname"), req.getParameter("surname"), req.getParameter("phoneNumber"), req.getParameter("deliveryType"));
        //Courier courier = courierMapper.buildUser(req);
        courierService.updateCourier(courier, id);

        doGet(req,resp);
    }
}
