package world.It.academy.repositories.tentativeSchedule;

import world.It.academy.entities.TentativeSchedule;
import world.It.academy.entities.Worker;
import world.It.academy.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.List;

public class TentativeScheduleRepositoryImpl implements TentativeScheduleRepository {
    private static TentativeScheduleRepository tentativeScheduleRepository;
    private static final EntityManager entityManager = JPAUtil.getEntityManager();

    public static TentativeScheduleRepository getInstance() {
        if (tentativeScheduleRepository == null) {
            tentativeScheduleRepository = new TentativeScheduleRepositoryImpl();
        }
        return tentativeScheduleRepository;
    }

    private TentativeScheduleRepositoryImpl() {
    }

    @Override
    public void addTentativeSchedule(TentativeSchedule tentativeSchedule) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(tentativeSchedule);
        transaction.commit();
    }

    @Override
    public List<TentativeSchedule> readTentativeScheduleById(Long idWorker, LocalDate dateStartWeek, LocalDate dateEndWeek) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TentativeSchedule> criteriaQuery = criteriaBuilder.createQuery(TentativeSchedule.class);

        Root<TentativeSchedule> tentativeScheduleRoot = criteriaQuery.from(TentativeSchedule.class);

        criteriaQuery.select(tentativeScheduleRoot)
                .where(criteriaBuilder.and
                        (criteriaBuilder.equal(tentativeScheduleRoot.get("worker").get("id"), idWorker),
                                criteriaBuilder.between
                                        (tentativeScheduleRoot.get("dateWork"), dateStartWeek, dateEndWeek)))
                .orderBy(criteriaBuilder.asc(tentativeScheduleRoot.get("dateWork")));

        List<TentativeSchedule> tentativeSchedules = entityManager.createQuery(criteriaQuery).getResultList();
        transaction.commit();

        return tentativeSchedules;
    }

    @Override
    public LocalDate getMaxDate(Long idWorker) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<LocalDate> criteriaQuery = criteriaBuilder.createQuery(LocalDate.class);

        Root<TentativeSchedule> tentativeScheduleRoot = criteriaQuery.from(TentativeSchedule.class);

        criteriaQuery.select(criteriaBuilder.function("max", LocalDate.class, tentativeScheduleRoot.get("dateWork")))
                .where(criteriaBuilder.equal(tentativeScheduleRoot.get("worker").get("id"), idWorker));

        LocalDate maxDate = entityManager.createQuery(criteriaQuery).getSingleResult();
        transaction.commit();
        return maxDate;
    }

    @Override
    public void AddEmptySchedule(Worker worker, LocalDate dateStartWeek, LocalDate dateEndWeek) {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        while (!dateStartWeek.isAfter(dateEndWeek)) {

            TentativeSchedule tentativeSchedule = new TentativeSchedule(dateStartWeek, worker);
            entityManager.merge(tentativeSchedule);

            dateStartWeek = dateStartWeek.plusDays(1);
        }

        transaction.commit();

    }

    @Override
    public Long findIdByIdWorkerAndDateWork(Long idWorker, LocalDate dateWork) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);

        Root<TentativeSchedule> tentativeScheduleRoot = criteriaQuery.from(TentativeSchedule.class);

        criteriaQuery.select(tentativeScheduleRoot.get("id"))
                .where(criteriaBuilder
                        .and(criteriaBuilder.equal(tentativeScheduleRoot.get("worker").get("id"), idWorker),
                                criteriaBuilder.equal(tentativeScheduleRoot.get("dateWork"), dateWork)));

        Long idSchedule = entityManager.createQuery(criteriaQuery).getSingleResult();
        transaction.commit();
        return idSchedule;
    }

    @Override
    public TentativeSchedule findById(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TentativeSchedule tentativeSchedule = entityManager.find(TentativeSchedule.class, id);

        transaction.commit();

        return tentativeSchedule;
    }
}
