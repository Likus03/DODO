package by.It.academy.services.order;

import by.It.academy.entities.Order;

import java.util.List;


public interface OrderService {
    List<Order> read();
    void create(Order order);
    void update(Order order);
    void delete(long id);
    Order getById(long id);
}
