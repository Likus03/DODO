package world.It.academy.repositories.user;

import world.It.academy.entities.User;
import world.It.academy.utils.JPAUtil;
import world.It.academy.utils.PasswordHashing;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private static UserRepository userRepository;
    private static final EntityManager entityManager = JPAUtil.getEntityManager();
    private UserRepositoryImpl() {
    }

    public static UserRepository getInstance() {
        if (userRepository == null) {
            userRepository = new UserRepositoryImpl();
        }
        return userRepository;
    }

    @Override
    public List<User> read() {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);

        Root<User> orderRoot = criteriaQuery.from(User.class);

        criteriaQuery.select(orderRoot);

        List<User> users = entityManager.createQuery(criteriaQuery).getResultList();
        transaction.commit();

        return users;
    }
    @Override
    public void create(User user) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(user);
        transaction.commit();
    }
    @Override
    public void update(User user) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.merge(user);
        transaction.commit();
    }

    @Override
    public void delete(long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        User user = entityManager.find(User.class, id);
        entityManager.remove(user);

        transaction.commit();
    }

    @Override
    public User getLoggedUser(String login, String password) throws NoResultException{
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);

        Root<User> orderRoot = criteriaQuery.from(User.class);

        Predicate condition = criteriaBuilder.equal(orderRoot.get("login"), login);

        criteriaQuery.select(orderRoot)
                .where(condition);

        transaction.commit();
        User user;

        try {
            user = entityManager.createQuery(criteriaQuery).getSingleResult();
        }
        catch (NoResultException ex){
            user = null;
            System.out.println("No results found.");
        }

        if (user != null && PasswordHashing.checkPassword(password, user.getPassword())) {
            return user;
        } else {
            return null;
        }
    }
}
