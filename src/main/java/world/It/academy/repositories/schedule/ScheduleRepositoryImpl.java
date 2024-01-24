package world.It.academy.repositories.schedule;

import world.It.academy.entities.WorkSchedule;
import world.It.academy.utils.JPAUtil;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class ScheduleRepositoryImpl implements ScheduleRepository {
    private static ScheduleRepository scheduleRepository;
    private static final EntityManager entityManager = JPAUtil.getEntityManager();

    public static ScheduleRepository getInstance() {
        if (scheduleRepository == null) {
            scheduleRepository = new ScheduleRepositoryImpl();
        }
        return scheduleRepository;
    }

    private ScheduleRepositoryImpl() {
    }

    @Override
    public List<WorkSchedule> readScheduleByIdWorker(Long idWorker, LocalDate dateStartWeek, LocalDate dateEndWeek) {

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<WorkSchedule> criteriaQuery = criteriaBuilder.createQuery(WorkSchedule.class);

        Root<WorkSchedule> workScheduleRoot = criteriaQuery.from(WorkSchedule.class);

        criteriaQuery.select(workScheduleRoot)
                .where(criteriaBuilder.and
                        (criteriaBuilder.equal(workScheduleRoot.get("worker").get("id"), idWorker),
                                criteriaBuilder.between
                                        (workScheduleRoot.get("dateWork"), dateStartWeek, dateEndWeek)))
                .orderBy(criteriaBuilder.asc(workScheduleRoot.get("dateWork")));

        List<WorkSchedule> workSchedules;
        try {
            workSchedules = entityManager.createQuery(criteriaQuery).getResultList();
        } catch (NullPointerException ex) {
            workSchedules = null;
            System.out.println("No results found.");
        }
        transaction.commit();
        return workSchedules;
    }

    @Override
    public Optional<WorkSchedule> findById(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        WorkSchedule workSchedule = entityManager.find(WorkSchedule.class, id);

        transaction.commit();

        return Optional.ofNullable(workSchedule);
    }
}
