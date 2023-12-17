package by.It.academy.controllers.couriers;

import by.It.academy.entities.CompletedOrder;
import by.It.academy.entities.Order;
import by.It.academy.services.completedOrder.CompletedOrderService;
import by.It.academy.services.completedOrder.CompletedOrderServiceImpl;
import by.It.academy.services.order.OrderService;
import by.It.academy.services.order.OrderServiceImpl;
import by.It.academy.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/readCompletedOrders")
public class ReadCompletedOrdersController extends HttpServlet {
    private final CompletedOrderService completedOrderService = CompletedOrderServiceImpl.getInstance();
    private final OrderService orderService = OrderServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = orderService.readAll();
        List<CompletedOrder> completedOrders = completedOrderService.read((Long) req.getSession().getAttribute("idWorker"));

        List<Order> completedCourierOrders = findCompletedCourierOrders(orders, completedOrders);

        req.setAttribute("completedCourierOrders", completedCourierOrders);
        req.getRequestDispatcher(Constants.READ_COMPLETED_COURIERS_ORDERS_PAGE).forward(req, resp);
    }

    private static List<Order> findCompletedCourierOrders(List<Order> orders, List<CompletedOrder> completedOrders) {
        return completedOrders.stream()
                .map(completedOrder -> orders.stream()
                        .filter(order -> order.getIdOrder() == completedOrder.getIdOrder())
                        .findFirst().get())
                .collect(Collectors.toList());
    }
}
