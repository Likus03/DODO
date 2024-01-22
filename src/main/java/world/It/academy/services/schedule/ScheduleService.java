package world.It.academy.services.schedule;

import world.It.academy.entities.WorkSchedule;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ScheduleService {
    List<WorkSchedule> readScheduleByIdWorker(Long idWorker, LocalDate date);
    WorkSchedule findById(Long id);
}
