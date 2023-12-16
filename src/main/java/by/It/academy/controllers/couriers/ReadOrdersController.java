package by.It.academy.controllers.couriers;

import by.It.academy.entities.Order;
import by.It.academy.services.order.OrderService;
import by.It.academy.services.order.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/readOrders")
public class ReadOrdersController extends HttpServlet {

    OrderService orderService = OrderServiceImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = orderService.readNotCompleted();
        req.setAttribute("orders", orders);
        req.getRequestDispatcher("/pages/orders/readOrders.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
