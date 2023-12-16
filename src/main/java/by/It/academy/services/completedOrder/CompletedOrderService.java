package by.It.academy.services.completedOrder;

import by.It.academy.entities.CompletedOrder;

import java.util.List;

public interface CompletedOrderService {
    List<CompletedOrder> read(long idCourier);
    void create(CompletedOrder completedOrder);
    void update(CompletedOrder completedOrder);
    void delete(long id);
    CompletedOrder getById(long id);
}
