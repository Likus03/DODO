package by.It.academy.repositories.order;

import by.It.academy.entities.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> readNotCompleted();
    List<Order> readAll();

    void create(Order order);

    void update(Order order);

    void delete(long id);
    Order getById(long id);

    void completeOrder(Order order);
}
