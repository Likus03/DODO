package by.It.academy.services.order;

import by.It.academy.entities.Order;
import by.It.academy.repositories.order.OrderRepository;
import by.It.academy.repositories.order.OrderRepositoryImpl;

import java.util.List;

public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository = OrderRepositoryImpl.getInstance();

    private static OrderService orderService;

    private OrderServiceImpl() {
    }

    @Override
    public List<Order> readNotCompleted() {
        return orderRepository.readNotCompleted();
    }
    @Override
    public List<Order> readAll(){return orderRepository.readAll();}

    @Override
    public void create(Order order) {
        orderRepository.create(order);
    }

    @Override
    public List<Order> update(Order order) {
        return orderRepository.update(order);
    }

    @Override
    public void delete(long id) {
        orderRepository.delete(id);
    }

    @Override
    public Order getById(long id) {
        return orderRepository.getById(id);
    }
    @Override
    public void completeOrder(Order order){
        orderRepository.completeOrder(order);
    }

    public static OrderService getInstance(){

        if(orderService == null){
            orderService = new OrderServiceImpl();
        }
        return orderService;
    }
}
