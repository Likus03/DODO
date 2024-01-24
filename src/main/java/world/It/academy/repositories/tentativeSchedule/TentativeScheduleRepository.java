package world.It.academy.repositories.tentativeSchedule;

import world.It.academy.entities.TentativeSchedule;
import world.It.academy.entities.Worker;

import java.time.LocalDate;
import java.util.List;

public interface TentativeScheduleRepository {
    void addTentativeSchedule(TentativeSchedule tentativeSchedule);
    List<TentativeSchedule> readTentativeScheduleById(Long idWorker, LocalDate dateStartWeek, LocalDate dateEndWeek);
    LocalDate getMaxDate(Long idWorker);

    void AddEmptySchedule(Worker worker, LocalDate dateStartWeek, LocalDate dateEndWeek);

    Long findIdByIdWorkerAndDateWork(Long idWorker, LocalDate dateWork);

    TentativeSchedule findById(Long id);
}
