package by.It.academy.controllers.orders;

import by.It.academy.entities.CompletedOrder;
import by.It.academy.entities.Order;
import by.It.academy.services.completedOrder.CompletedOrderService;
import by.It.academy.services.completedOrder.CompletedOrderServiceImpl;
import by.It.academy.services.order.OrderService;
import by.It.academy.services.order.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static by.It.academy.utils.Constants.READ_COMPLETED_COURIERS_ORDERS_PAGE;

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
        req.getRequestDispatcher(READ_COMPLETED_COURIERS_ORDERS_PAGE).forward(req, resp);
    }

    private List<Order> findCompletedCourierOrders(List<Order> orders, List<CompletedOrder> completedOrders) {
        return completedOrders.stream()
                .map(completedOrder -> orders.stream()
                        .filter(order -> Objects.equals(order.getIdOrder(), completedOrder.getIdOrder()))
                        .findFirst()
                        .orElse(null))
                        .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
