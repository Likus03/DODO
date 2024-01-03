package by.It.academy.services.completedOrder;

import by.It.academy.entities.CompletedOrder;
import by.It.academy.repositories.completedOrder.CompletedOrderRepository;
import by.It.academy.repositories.completedOrder.CompletedOrderRepositoryImpl;

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
    public List<CompletedOrder> update(CompletedOrder completedOrder) {
        return completedOrderRepository.update(completedOrder);
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
