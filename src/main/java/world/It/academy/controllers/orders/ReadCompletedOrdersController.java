package world.It.academy.controllers.orders;

import world.It.academy.entities.Order;
import world.It.academy.services.order.OrderService;
import world.It.academy.services.order.OrderServiceImpl;
import world.It.academy.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/readCompletedOrders")
public class ReadCompletedOrdersController extends HttpServlet {
    private final OrderService orderService = OrderServiceImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Order> orders = orderService.readCompletedOrNot((Long) req.getSession().getAttribute("worker_id"), true);

        req.setAttribute("orders", orders);
        req.getRequestDispatcher(Constants.READ_COMPLETED_COURIERS_ORDERS_PAGE).forward(req, resp);
    }
}
