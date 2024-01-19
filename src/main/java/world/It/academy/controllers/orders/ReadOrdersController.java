//package world.It.academy.controllers.orders;
//
//import world.It.academy.entities.Order;
//import world.It.academy.services.order.OrderService;
//import world.It.academy.services.order.OrderServiceImpl;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//import static world.It.academy.utils.Constants.READ_ORDERS_PAGE;
//
//@WebServlet(urlPatterns = "/readOrders")
//public class ReadOrdersController extends HttpServlet {
//    private final OrderService orderService = OrderServiceImpl.getInstance();
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<Order> orders = orderService.readNotCompleted();
//        req.setAttribute("orders", orders);
//
//        req.getRequestDispatcher(READ_ORDERS_PAGE).forward(req, resp);
//    }
//}
