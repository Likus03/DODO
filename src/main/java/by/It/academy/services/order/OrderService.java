package by.It.academy.services.order;

import by.It.academy.entities.Order;

import java.util.List;


public interface OrderService {
    List<Order> readNotCompleted();
    List<Order> readAll();
    void create(Order order);
    List<Order> update(Order order);
    void delete(long id);
    Order getById(long id);
    void completeOrder(Order order);
}
