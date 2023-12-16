package by.It.academy.repositories.completedOrder;

import by.It.academy.entities.CompletedOrder;
import by.It.academy.entities.Order;

import java.util.List;

public interface CompletedOrderRepository {
    List<CompletedOrder> read(long idCourier);

    void create(CompletedOrder completedOrder);

    void update(CompletedOrder completedOrder);

    void delete(long id);
    CompletedOrder getById(long id);
}
