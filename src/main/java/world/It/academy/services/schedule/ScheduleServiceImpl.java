package world.It.academy.services.schedule;

import world.It.academy.entities.WorkSchedule;
import world.It.academy.repositories.schedule.ScheduleRepository;
import world.It.academy.repositories.schedule.ScheduleRepositoryImpl;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.WeekFields;
import java.util.Date;
import java.util.Calendar;
import java.util.List;

public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository = ScheduleRepositoryImpl.getInstance();
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
        if (date == null) {
            return null;
        }
        LocalDate[] week = getWeek(date);
        return scheduleRepository.readScheduleByIdWorker(idWorker, week[0], week[1]);
    }

    @Override
    public WorkSchedule findById(Long id) {
        return scheduleRepository.findById(id).orElse(null);
    }

    private static LocalDate[] getWeek(LocalDate date) {
        LocalDate[] week = new LocalDate[2];
        // Получаем дату начала недели (понедельник)
        week[0] = date.with(DayOfWeek.MONDAY);

        // Получаем дату конца недели (воскресенье)
        week[1] = date.with(DayOfWeek.SUNDAY);
        return week;
    }
}
