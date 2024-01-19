package world.It.academy.repositories.order;

import world.It.academy.entities.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> readAvailableOrder();

    List<Order> readCompletedOrNot(Long id, boolean completed);

//    List<Order> readAll();

    void create(Order order);

    void takeOrder(Long idOrder, Long idWorker);

    void completeOrder(Order order);

    Order findById(Long id);
}
