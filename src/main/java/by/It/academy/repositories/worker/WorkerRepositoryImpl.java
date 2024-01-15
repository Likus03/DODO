package by.It.academy.repositories.worker;

import by.It.academy.entities.User;
import by.It.academy.entities.Worker;
import by.It.academy.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class WorkerRepositoryImpl implements WorkerRepository {
    private static WorkerRepository workerRepository;
//    private static List<Worker> workers = new ArrayList<>();
    private WorkerRepositoryImpl() {
       // workers.addAll(read());
    }

    public static WorkerRepository getInstance() {
        if (workerRepository == null) {
            workerRepository = new WorkerRepositoryImpl();
        }
        return workerRepository;
    }

//    @Override
//    public void create(User user) {
//        EntityManager entityManager = JPAUtil.getEntityManager();
//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();
//
//        entityManager.persist(user);
//        transaction.commit();
//    }

    @Override
    public List<Worker> read() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
//        TypedQuery<Worker> query =
//                entityManager.createQuery("SELECT c FROM Worker c", Worker.class);
//        List<Worker> workers = query.getResultList();
//
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

        entityManager.merge(worker);
        transaction.commit();
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



//    @Override
//    public Worker getById(long id) {
//        return workers.stream()
//                .filter(workerTemp -> workerTemp.getIdWorker() == id)
//                .findFirst()
//                .orElse(null);
//    }
}
