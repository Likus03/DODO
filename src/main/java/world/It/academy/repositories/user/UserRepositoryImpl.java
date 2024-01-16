package world.It.academy.repositories.user;

import world.It.academy.entities.User;
import world.It.academy.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private static UserRepository userRepository;

    //    private static List<Worker> workers = new ArrayList<>();
    private UserRepositoryImpl() {
        // workers.addAll(read());
    }

    public static UserRepository getInstance() {
        if (userRepository == null) {
            userRepository = new UserRepositoryImpl();
        }
        return userRepository;
    }

    @Override
    public List<User> read() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
//        TypedQuery<Worker> query =
//                entityManager.createQuery("SELECT c FROM Worker c", Worker.class);
//        List<Worker> workers = query.getResultList();
//
        List<User> users =
                entityManager.createNamedQuery("User.allUsers", User.class).getResultList();

        transaction.commit();

        return users;
    }
    @Override
    public void create(User user) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(user);
        transaction.commit();
    }
    @Override
    public void update(User user) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.merge(user);
        transaction.commit();
    }

    @Override
    public void delete(long id) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        User user = entityManager.find(User.class, id);
        entityManager.remove(user);

        transaction.commit();
    }

    @Override
    public User getLoggedUser(String login, String password) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<User> query = entityManager.createQuery(
                "SELECT e FROM User e WHERE e.login = :login AND e.password = :password", User.class);
        query.setParameter("login", login);
        query.setParameter("password", password);

        User user = null;
        try {
            user = query.getSingleResult();
        }
        catch (NoResultException ex){
            ex.printStackTrace();
        }
        transaction.commit();

        return user;
    }
}
