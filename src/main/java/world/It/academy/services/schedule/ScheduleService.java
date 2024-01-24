package world.It.academy.services.schedule;

import world.It.academy.entities.WorkSchedule;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleService {
    List<WorkSchedule> readScheduleByIdWorker(Long idWorker, LocalDate date);
    WorkSchedule findById(Long id);
//    LocalDate[] getWeek(LocalDate date);

//    List<LocalDate> generateWeek(LocalDate startDate, LocalDate endDate);
}
