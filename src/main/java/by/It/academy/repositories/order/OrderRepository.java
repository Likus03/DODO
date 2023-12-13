package by.It.academy.repositories.order;

import by.It.academy.entities.Order;
import by.It.academy.entities.Worker;

import java.util.List;

public interface OrderRepository {
    List<Order> read();

    void create(Order order);

    void update(Order order);

    void delete(long id);
    Order getById(long id);
}
