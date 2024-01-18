package world.It.academy.services.order;

import world.It.academy.entities.Order;
import world.It.academy.repositories.order.OrderRepository;
import world.It.academy.repositories.order.OrderRepositoryImpl;

import java.util.List;

public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository = OrderRepositoryImpl.getInstance();

    private static OrderService orderService;

    private OrderServiceImpl() {
    }

    @Override
    public List<Order> readNotCompleted() {
        return orderRepository.readNotCompleted();
    }
    @Override
    public List<Order> readCompleted(Long id){return orderRepository.readCompleted(id);}

    @Override
    public void takeOrder(Long idOrder, Long idWorker) {
        orderRepository.takeOrder(idOrder, idWorker);
    }

    @Override
    public List<Order> readAll(){return orderRepository.readAll();}

    @Override
    public void create(Order order) {
        orderRepository.create(order);
    }


    public static OrderService getInstance(){

        if(orderService == null){
            orderService = new OrderServiceImpl();
        }
        return orderService;
    }
}
