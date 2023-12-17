package by.It.academy.repositories.completedOrder;

import by.It.academy.entities.CompletedOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CompletedOrderRepositoryImpl implements CompletedOrderRepository {
    private static CompletedOrderRepository completedOrderRepository;
    private static final List<CompletedOrder> completedOrders = new ArrayList<>();
    private static Long id = 4L;

    private CompletedOrderRepositoryImpl() {
        completedOrders.add(new CompletedOrder(1L, 1L, 3L));
        completedOrders.add(new CompletedOrder(2L, 2L, 4L));
        completedOrders.add(new CompletedOrder(3L, 2L, 1L));
    }

    @Override
    public void create(CompletedOrder completedOrder) {
        completedOrder.setId(id++);
        completedOrders.add(completedOrder);
    }

    public static CompletedOrderRepository getInstance() {
        if (completedOrderRepository == null) {
            completedOrderRepository = new CompletedOrderRepositoryImpl();
        }
        return completedOrderRepository;
    }

    @Override
    public List<CompletedOrder> read(long idCourier) {
        return completedOrders.stream()
                .filter(completedOrder -> completedOrder.getIdCourier() == idCourier)
                .collect(Collectors.toList());
    }

    @Override
    public void update(CompletedOrder completedOrder) {
        CompletedOrder findOrder = completedOrders.stream().filter(o -> Objects.equals(o.getId(), completedOrder.getId())).findFirst().get();
        completedOrders.set(completedOrders.indexOf(findOrder), completedOrder);
    }

    @Override
    public void delete(long id) {
        completedOrders.removeIf(order -> order.getId() == id);
    }

    @Override
    public CompletedOrder getById(long id) {
        return completedOrders.stream().filter(order -> order.getId() == id).findFirst().get();
    }
}
