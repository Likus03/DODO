package by.It.academy.repositories.order;

import by.It.academy.entities.Order;
import by.It.academy.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class OrderRepositoryImpl implements OrderRepository {
    private static OrderRepository orderRepository;

    public static OrderRepository getInstance() {
        if (orderRepository == null) {
            orderRepository = new OrderRepositoryImpl();
        }
        return orderRepository;
    }

    private OrderRepositoryImpl() {
    }

    @Override
    public void create(Order order) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(order);
        transaction.commit();
    }

    @Override
    public List<Order> readNotCompleted() {
        return null;
//        return orders.stream()
//                .filter(order -> !order.getCompleted())
//                .collect(Collectors.toList());
    }

    @Override
    public List<Order> readAll() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Order> criteriaQuery = builder.createQuery(Order.class);

        criteriaQuery.select(criteriaQuery.from(Order.class));

        TypedQuery<Order> query = entityManager.createQuery(criteriaQuery);
        List<Order> orders = query.getResultList();

        transaction.commit();
        return orders;
    }

    @Override
    public List<Order> update(Order order) {
//        return orders.stream()
//                .map(e -> Objects.equals(e.getId(), order.getId()) ? order : e)
//                .collect(Collectors.toList());
        return null;
    }

    @Override
    public void delete(long id) {
//        orders.removeIf(order -> order.getId() == id);
    }

    @Override
    public Order getById(long id) {
        return null;
//        return orders.stream()
//                .filter(order -> order.getId() == id)
//                .findFirst()
//                .orElse(null);
    }

    @Override
    public void completeOrder(Order order) {
        order.setCompleted(true);
    }
}
