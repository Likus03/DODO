package world.It.academy.controllers.orders;

import world.It.academy.entities.Order;
import world.It.academy.mapper.OrderMapper;
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

@WebServlet(urlPatterns = "/takeOrder")
public class TakeOrderController extends HttpServlet {
    private final OrderService orderService = OrderServiceImpl.getInstance();
    private final OrderMapper orderMapper = OrderMapper.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = orderService.readNotCompleted();
        req.setAttribute("orders", orders);
        req.getRequestDispatcher(Constants.TAKE_ORDER_PAGE).forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long idOrder = Long.valueOf(req.getParameter("id"));
        Long idWorker = (Long) req.getSession().getAttribute("worker_id");
        orderService.takeOrder(idOrder, idWorker);

        doGet(req, resp);
    }
}