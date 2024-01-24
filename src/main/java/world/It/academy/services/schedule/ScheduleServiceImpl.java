package world.It.academy.services.schedule;

import world.It.academy.entities.WorkSchedule;
import world.It.academy.repositories.schedule.ScheduleRepository;
import world.It.academy.repositories.schedule.ScheduleRepositoryImpl;

import java.time.LocalDate;
import java.util.List;

import static world.It.academy.utils.Utility.getWeek;

public class ScheduleServiceImpl implements ScheduleService {
    private static final ScheduleRepository scheduleRepository = ScheduleRepositoryImpl.getInstance();
    private static ScheduleService scheduleService;

    public static ScheduleService getInstance() {

        if (scheduleService == null) {
            scheduleService = new ScheduleServiceImpl();
        }
        return scheduleService;
    }

    private ScheduleServiceImpl() {
    }

    @Override
    public List<WorkSchedule> readScheduleByIdWorker(Long idWorker, LocalDate date) {
        LocalDate[] week = getWeek(date);
        return scheduleRepository.readScheduleByIdWorker(idWorker, week[0], week[1]);
    }

    @Override
    public WorkSchedule findById(Long id) {
        return scheduleRepository.findById(id).orElse(null);
    }
}
