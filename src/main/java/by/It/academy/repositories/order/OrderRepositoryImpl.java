package by.It.academy.repositories.order;

import by.It.academy.entities.Order;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class OrderRepositoryImpl implements OrderRepository {
    private static OrderRepository orderRepository;
    private static final List<Order> orders = new ArrayList<>();
    private static long id = 7;
    private static int idOrder = 7;

    private OrderRepositoryImpl() {
        orders.add(new Order(1L, 1, "Pepperoni", 32.4F, "Miroshnichenko 32, 34", LocalTime.of(12, 30), true));
        orders.add(new Order(2L, 2, "Margherita, Chessy", 76.4F, "Kireeva 43, 62", LocalTime.of(15, 50), false));
        orders.add(new Order(3L, 3, "Hawai", 23.8F, "Mihalova 42, 63", LocalTime.of(19, 10), true));
        orders.add(new Order(4L, 4, "Double Pepperoni", 41.0F, "Pushkinskaya 21, 90", LocalTime.of(17, 40), true));
        orders.add(new Order(5L, 5, "Chicken BBQ", 31.5F, "Volgagradskaya 97, 87", LocalTime.of(13, 55), false));
        orders.add(new Order(6L, 6, "Carbonara", 27.3F, "Uruchskaya 77, 32", LocalTime.of(13, 50), false));

    }

    @Override
    public void create(Order order) {
        order.setId(id++);
        order.setIdOrder(idOrder++);
        orders.add(order);
    }

    public static OrderRepository getInstance() {
        if (orderRepository == null) {
            orderRepository = new OrderRepositoryImpl();
        }
        return orderRepository;
    }

    @Override
    public List<Order> readNotCompleted() {
        List<Order> tempOrders = orders.stream()
                .filter(order -> !order.isCompleted())
                .collect(Collectors.toList());
        return tempOrders;
    }

    @Override
    public List<Order> readAll() {
        return orders;
    }

    @Override
    public void update(Order order) {
        Order findOrder = orders.stream().filter(o -> Objects.equals(o.getId(), order.getId())).findFirst().get();
        orders.set(orders.indexOf(findOrder), order);
    }

    @Override
    public void delete(long id) {
        orders.removeIf(order -> order.getId() == id);
    }

    @Override
    public Order getById(long id) {
        return orders.stream().filter(order -> order.getId() == id).findFirst().get();
    }

    @Override
    public void completeOrder(Order order) {
        order.setCompleted(true);
    }


}
