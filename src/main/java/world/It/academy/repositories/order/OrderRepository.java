package world.It.academy.repositories.order;

import world.It.academy.entities.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    List<Order> readAvailableOrder();

    List<Order> readCompletedOrNot(Long id, boolean completed);

    void create(Order order);

    void takeOrder(Long idOrder, Long idWorker);

    void completeOrder(Order order);

    Optional<Order> findById(Long id);
}
