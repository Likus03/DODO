package by.It.academy.controllers;

import by.It.academy.entities.Courier;
import by.It.academy.services.CourierService;
import by.It.academy.services.CourierServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/couriers/read")
public class ReadCourierController extends HttpServlet {
    private CourierService courierService = new CourierServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Courier> couriers = courierService.readCourier();

        req.setAttribute("couriers", couriers);
        req.getRequestDispatcher("/pages/couriers/couriers.jsp").forward(req, resp);//todo не забыть про webapp
    }
}
