package world.It.academy.services.order;

import world.It.academy.entities.Order;

import java.util.List;


public interface OrderService {
    List<Order> readAvailableOrder();
    List<Order> readCompletedOrNot(Long id, boolean completed);
    void takeOrder(Long idOrder, Long idWorker);
//    List<Order> readAll();
    void create(Order order);

    void completeOrder(Long id);
}
