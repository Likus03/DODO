package by.It.academy.controllers.orders;

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

import static by.It.academy.utils.Constants.TAKE_ORDER_PAGE;

@WebServlet(urlPatterns = "/takeOrder")
public class TakeOrderController extends HttpServlet {
    private final OrderService orderService = OrderServiceImpl.getInstance();
//    private final CompletedOrderService completedOrderService = CompletedOrderServiceImpl.getInstance();
//    private final CompletedOrderMapper completedOrderMapper = CompletedOrderMapper.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = orderService.readNotCompleted();
        req.setAttribute("orders", orders);
        req.getRequestDispatcher(TAKE_ORDER_PAGE).forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        CompletedOrder completedOrder = completedOrderMapper.buildCompletedOrder(req);
//        completedOrderService.create(completedOrder);
//
//        orderService.completeOrder(orderService.getById(Long.parseLong(req.getParameter("idOrder"))));

        doGet(req, resp);
    }
}