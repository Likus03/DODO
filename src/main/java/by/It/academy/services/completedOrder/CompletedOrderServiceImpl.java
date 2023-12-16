package by.It.academy.services.completedOrder;

import by.It.academy.entities.CompletedOrder;
import by.It.academy.entities.Order;
import by.It.academy.repositories.completedOrder.CompletedOrderRepository;
import by.It.academy.repositories.completedOrder.CompletedOrderRepositoryImpl;
import by.It.academy.repositories.order.OrderRepository;
import by.It.academy.repositories.order.OrderRepositoryImpl;
import by.It.academy.services.order.OrderService;
import by.It.academy.services.order.OrderServiceImpl;

import java.util.List;

public class CompletedOrderServiceImpl implements CompletedOrderService{
    private final CompletedOrderRepository completedOrderRepository = CompletedOrderRepositoryImpl.getInstance();

    private static CompletedOrderService completedOrderService;

    private CompletedOrderServiceImpl() {
    }

    @Override
    public List<CompletedOrder> read(long idCourier) {
        return completedOrderRepository.read(idCourier);
    }

    @Override
    public void create(CompletedOrder completedOrder) {
        completedOrderRepository.create(completedOrder);
    }

    @Override
    public void update(CompletedOrder completedOrder) {
        completedOrderRepository.update(completedOrder);
    }

    @Override
    public void delete(long id) {
        completedOrderRepository.delete(id);
    }

    @Override
    public CompletedOrder getById(long id) {
        return completedOrderRepository.getById(id);
    }

    public static CompletedOrderService getInstance(){

        if(completedOrderService == null){
            completedOrderService = new CompletedOrderServiceImpl();
        }
        return completedOrderService;
    }
}
