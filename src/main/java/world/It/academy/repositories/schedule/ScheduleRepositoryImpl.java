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

//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createTupleQuery();
//
//        Root<WorkSchedule> workScheduleRoot = criteriaQuery.from(WorkSchedule.class);
//
//        Expression<Date> startOfWeekExpression = criteriaBuilder.function("date_trunc", Date.class, criteriaBuilder.literal("week"), workScheduleRoot.get("dateWork"));
//        Expression<Date> endOfWeekExpression = criteriaBuilder.function("date_trunc", Date.class, criteriaBuilder.literal("week"), workScheduleRoot.get("dateWork"));
//        endOfWeekExpression = criteriaBuilder.sum(endOfWeekExpression, 6);
//        criteriaQuery.multiselect(startOfWeekExpression.alias("start_of_week"), endOfWeekExpression.alias("end_of_week"));
//
//        TypedQuery<Tuple> query = entityManager.createQuery(criteriaQuery);
//        List<Tuple> result = query.getResultList();
//
//        for (Tuple tuple : result) {
//            Date startOfWeekValue = tuple.get("start_of_week", Date.class);
//            Date endOfWeekValue = tuple.get("end_of_week", Date.class);
//            // обработка результатов
//        }


//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();
//
//        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<WorkSchedule> criteriaQuery = builder.createQuery(WorkSchedule.class);
//
//        Root<WorkSchedule> root = criteriaQuery.from(WorkSchedule.class);
//        criteriaQuery.select(root)
//                .where(builder.equal(root.get("worker").get("id"), idWorker));
//
//        List<WorkSchedule> workSchedules;
//        try {
//            workSchedules = entityManager.createQuery(criteriaQuery).getResultList();
//        } catch (NullPointerException ex) {
//            workSchedules = null;
//            System.out.println("No results found.");
//        }
//        transaction.commit();
//        return workSchedules;
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
