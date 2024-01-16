package world.It.academy.repositories.worker;

import world.It.academy.entities.Worker;
import world.It.academy.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import java.util.List;

public class WorkerRepositoryImpl implements WorkerRepository {
    private static WorkerRepository workerRepository;

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
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        List<Worker> workers =
                entityManager.createNamedQuery("Worker.allWorkers", Worker.class).getResultList();

        transaction.commit();

        return workers;
    }

    @Override
    public List<Worker> readBySearch(String parameter) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Worker> query =
                entityManager.createQuery("select w from Worker w where " +
                        "concat(w.firstname, w.surname, w.phoneNumber, w.workerType) like :parameter", Worker.class);
        query.setParameter("parameter", "%" + parameter + "%");

        List<Worker> workers = query.getResultList();
        transaction.commit();

        return workers;
    }

    @Override
    public void update(Worker worker) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Worker updateWorker = entityManager.find(Worker.class, worker.getIdWorker());

        setUpdatingWorker(worker, updateWorker);

        entityManager.persist(updateWorker);
        transaction.commit();
    }

    private void setUpdatingWorker(Worker worker, Worker updateWorker) {
        updateWorker.setFirstname(worker.getFirstname());
        updateWorker.setSurname(worker.getSurname());
        updateWorker.setPhoneNumber(worker.getPhoneNumber());
        updateWorker.setWorkerType(worker.getWorkerType());
    }

    @Override
    public void delete(long id) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Worker worker = entityManager.find(Worker.class, id);
        entityManager.remove(worker);

        transaction.commit();
    }

    @Override
    public Worker getById(long id) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Worker worker = entityManager.find(Worker.class, id);

        transaction.commit();
        return worker;
    }
}