package world.It.academy.repositories.order;

import world.It.academy.entities.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> readNotCompleted();

    List<Order> readCompleted(Long id);

    List<Order> readAll();

    void create(Order order);

    List<Order> update(Order order);

    void delete(long id);
    Order getById(long id);

    void takeOrder(Long id, Long idWorker);

    void completeOrder(Order order);
}
