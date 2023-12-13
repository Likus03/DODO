package by.It.academy.services.order;

import by.It.academy.entities.Order;
import by.It.academy.entities.Worker;
import by.It.academy.repositories.order.OrderRepository;
import by.It.academy.repositories.order.OrderRepositoryImpl;
import by.It.academy.services.worker.WorkerService;
import by.It.academy.services.worker.WorkerServiceImpl;

import java.util.List;

public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository = OrderRepositoryImpl.getInstance();

    private static OrderService orderService;

    private OrderServiceImpl() {
    }

    @Override
    public List<Order> read() {
        return orderRepository.read();
    }

    @Override
    public void create(Order order) {
        orderRepository.create(order);
    }

    @Override
    public void update(Order order) {
        orderRepository.update(order);
    }

    @Override
    public void delete(long id) {
        orderRepository.delete(id);
    }

    @Override
    public Order getById(long id) {
        return orderRepository.getById(id);
    }

    public static OrderService getInstance(){

        if(orderService == null){
            orderService = new OrderServiceImpl();
        }
        return orderService;
    }
}
