package world.It.academy.repositories.schedule;

import world.It.academy.entities.WorkSchedule;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ScheduleRepository {
    List<WorkSchedule> readScheduleByIdWorker(Long idWorker, LocalDate dateStartWeek, LocalDate dateEndWeek);
    Optional<WorkSchedule> findById(Long id);
}
