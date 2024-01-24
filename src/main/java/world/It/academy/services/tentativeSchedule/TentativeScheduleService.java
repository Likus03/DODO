package world.It.academy.services.tentativeSchedule;

import world.It.academy.entities.TentativeSchedule;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface TentativeScheduleService {

    void addTentativeSchedule(Long idWorker, LocalDate dateWork, LocalTime startTime, LocalTime endTime);
    List<TentativeSchedule> readTentativeScheduleById(Long idWorker, LocalDate date);
    LocalDate getMaxDate(Long idWorker);

    void AddEmptySchedule(Long idWorker, LocalDate now);
}
