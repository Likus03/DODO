package world.It.academy.repositories.order;

import world.It.academy.entities.Order;
import world.It.academy.entities.Worker;
import world.It.academy.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.*;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
    private static OrderRepository orderRepository;
    private static final EntityManager entityManager = JPAUtil.getEntityManager();
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
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(order);
        transaction.commit();
    }
    @Override
    public List<Order> readAvailableOrder() {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Order> criteriaQuery = builder.createQuery(Order.class);

        Root<Order> root = criteriaQuery.from(Order.class);
        criteriaQuery.select(root)
                .where(builder.and
                (builder.equal(root.get("completed"), false),
                        builder.isNull(root.get("worker").get("idWorker"))));

        List<Order> orders;
        try {
            orders = entityManager.createQuery(criteriaQuery).getResultList();
        }
        catch (NullPointerException ex){
            orders = null;
            System.out.println("No results found.");
        }
        transaction.commit();
        return orders;
    }

    @Override
    public List<Order> readCompletedOrNot(Long id, boolean completed){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Order> criteriaQuery = criteriaBuilder.createQuery(Order.class);

        Root<Order> orderRoot = criteriaQuery.from(Order.class);

        Predicate condition = criteriaBuilder.and
                (criteriaBuilder.equal(orderRoot.get("worker").get("idWorker"), id),
                criteriaBuilder.equal(orderRoot.get("completed"), completed));

        criteriaQuery.select(orderRoot)
                .where(condition);

        List<Order> orders = entityManager.createQuery(criteriaQuery).getResultList();

        transaction.commit();
        return orders;
    }

//    @Override
//    public List<Order> readNotCompletedOrder(Long id){
//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();
//
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Order> criteriaQuery = criteriaBuilder.createQuery(Order.class);
//
//        Root<Order> orderRoot = criteriaQuery.from(Order.class);
//
//        Predicate condition = criteriaBuilder.and
//                (criteriaBuilder.equal(orderRoot.get("worker").get("idWorker"), id),
//                        criteriaBuilder.equal(orderRoot.get("completed"), false));
//
//        criteriaQuery.select(orderRoot)
//                .where(condition);
//
//        List<Order> orders = entityManager.createQuery(criteriaQuery).getResultList();
//
//        transaction.commit();
//        return orders;
//    }

//    @Override
//    public List<Order> readAll() {
//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();
//
//        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Order> criteriaQuery = builder.createQuery(Order.class);
//
//        criteriaQuery.select(criteriaQuery.from(Order.class));
//
//        TypedQuery<Order> query = entityManager.createQuery(criteriaQuery);
//        List<Order> orders = query.getResultList();
//
//        transaction.commit();
//        return orders;
//    }

    @Override
    public void takeOrder(Long idOrder, Long idWorker){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Order order = entityManager.find(Order.class, idOrder);
        Worker worker = entityManager.find(Worker.class, idWorker);
        order.setWorker(worker);

        entityManager.persist(order);
        transaction.commit();
    }
    @Override
    public void completeOrder(Order order) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        order.setCompleted(true);

        entityManager.persist(order);
        transaction.commit();
    }

    @Override
    public Order findById(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Order order = entityManager.find(Order.class, id);

        transaction.commit();

        return order;
    }
}
