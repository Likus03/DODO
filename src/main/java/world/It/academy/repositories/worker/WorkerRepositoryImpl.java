package world.It.academy.repositories.worker;

import world.It.academy.entities.Worker;
import world.It.academy.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.*;

import java.util.List;

public class WorkerRepositoryImpl implements WorkerRepository {
    private static WorkerRepository workerRepository;
    EntityManager entityManager = JPAUtil.getEntityManager();

    private WorkerRepositoryImpl() {
    }

    public static WorkerRepository getInstance() {
        if (workerRepository == null) {
            workerRepository = new WorkerRepositoryImpl();
        }
        return workerRepository;
    }

    @Override
    public List<Worker> readAll() {

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Worker> criteriaQuery = criteriaBuilder.createQuery(Worker.class);

        Root<Worker> workerRoot = criteriaQuery.from(Worker.class);

        criteriaQuery.select(workerRoot);

        List<Worker> workers = entityManager.createQuery(criteriaQuery).getResultList();
        transaction.commit();

        return workers;
    }

    @Override
    public List<Worker> readBySearch(String parameter) throws NullPointerException {
        if (parameter == null) {
            return null;
        }

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Worker> criteriaQuery = criteriaBuilder.createQuery(Worker.class);

        Root<Worker> workerRoot = criteriaQuery.from(Worker.class);

        Expression<String> expression1 = criteriaBuilder.concat(workerRoot.get("firstname"), workerRoot.get("surname"));
        Expression<String> expression2 = criteriaBuilder.concat(workerRoot.get("phoneNumber"), workerRoot.get("workerType"));
        Expression<String> expressionAll = criteriaBuilder.concat(expression1, expression2);

        Predicate predicate = criteriaBuilder.like(criteriaBuilder.upper(expressionAll), "%" + parameter.toUpperCase() + "%");

        criteriaQuery.select(workerRoot)
                .where(predicate);

        List<Worker> workers = entityManager.createQuery(criteriaQuery).getResultList();

        transaction.commit();

        return workers;
    }

    @Override
    public void update(Worker newWorker, Worker oldWorker) {
        EntityTransaction transaction = entityManager.getTransaction();

        setUpdatingWorker(newWorker, oldWorker);

        transaction.begin();
        entityManager.persist(oldWorker);
        transaction.commit();
    }

    @Override
    public void setUpdatingWorker(Worker newWorker, Worker oldWorker) {
        oldWorker.setFirstname(newWorker.getFirstname());
        oldWorker.setSurname(newWorker.getSurname());
        oldWorker.setPhoneNumber(newWorker.getPhoneNumber());
        oldWorker.setWorkerType(newWorker.getWorkerType());
    }
    @Override
    public Worker findById(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Worker worker = entityManager.find(Worker.class, id);

        transaction.commit();

        return worker;
    }


    @Override
    public void delete(long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Worker worker = entityManager.find(Worker.class, id);
        entityManager.remove(worker);

        transaction.commit();
    }

    @Override
    public Worker getById(long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Worker worker = entityManager.find(Worker.class, id);

        transaction.commit();
        return worker;
    }
}