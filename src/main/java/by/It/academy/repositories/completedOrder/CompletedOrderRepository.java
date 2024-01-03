package by.It.academy.repositories.completedOrder;

import by.It.academy.entities.CompletedOrder;

import java.util.List;

public interface CompletedOrderRepository {
    List<CompletedOrder> read(long idCourier);

    void create(CompletedOrder completedOrder);

    List<CompletedOrder> update(CompletedOrder completedOrder);

    void delete(long id);
    CompletedOrder getById(long id);
}
