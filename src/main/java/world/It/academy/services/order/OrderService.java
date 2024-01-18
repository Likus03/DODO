package world.It.academy.services.order;

import world.It.academy.entities.Order;

import java.util.List;


public interface OrderService {
    List<Order> readNotCompleted();
    List<Order> readCompleted(Long id);
    void takeOrder(Long idOrder, Long idWorker);
    List<Order> readAll();
    void create(Order order);
}
