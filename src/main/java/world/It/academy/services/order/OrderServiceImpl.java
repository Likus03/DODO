package world.It.academy.services.order;

import world.It.academy.entities.Order;
import world.It.academy.repositories.order.OrderRepository;
import world.It.academy.repositories.order.OrderRepositoryImpl;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private static final OrderRepository orderRepository = OrderRepositoryImpl.getInstance();
    private static OrderService orderService;

    private OrderServiceImpl() {
    }

    public static OrderService getInstance() {

        if (orderService == null) {
            orderService = new OrderServiceImpl();
        }
        return orderService;
    }
    @Override
    public List<Order> readAvailableOrder() {
        return orderRepository.readAvailableOrder();
    }

    @Override
    public List<Order> readCompletedOrNot(Long id, boolean completed) {
        return orderRepository.readCompletedOrNot(id, completed);
    }

    @Override
    public void takeOrder(Long idOrder, Long idWorker) {
        orderRepository.takeOrder(idOrder, idWorker);
    }

    @Override
    public void create(Order order) {
        orderRepository.create(order);
    }

    @Override
    public void completeOrder(Long id) {
        orderRepository.findById(id)
                .ifPresentOrElse(orderRepository::completeOrder,
                        () -> System.out.println("Order not found."));
    }
}
