package world.It.academy.services.tentativeSchedule;

import world.It.academy.entities.TentativeSchedule;
import world.It.academy.entities.Worker;
import world.It.academy.repositories.tentativeSchedule.TentativeScheduleRepository;
import world.It.academy.repositories.tentativeSchedule.TentativeScheduleRepositoryImpl;
import world.It.academy.repositories.worker.WorkerRepository;
import world.It.academy.repositories.worker.WorkerRepositoryImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static world.It.academy.utils.Utility.getWeek;

public class TentativeScheduleServiceImpl implements TentativeScheduleService{
    private static final TentativeScheduleRepository tentativeScheduleRepository = TentativeScheduleRepositoryImpl.getInstance();
    private static final WorkerRepository workerRepository = WorkerRepositoryImpl.getInstance();
    private static TentativeScheduleService tentativeScheduleService;

    public static TentativeScheduleService getInstance() {

        if (tentativeScheduleService == null) {
            tentativeScheduleService = new TentativeScheduleServiceImpl();
        }
        return tentativeScheduleService;
    }

    private TentativeScheduleServiceImpl() {
    }

    @Override
    public void addTentativeSchedule(Long idWorker, LocalDate dateWork, LocalTime startTime, LocalTime endTime) {
        Long idSchedule = tentativeScheduleRepository.findIdByIdWorkerAndDateWork(idWorker, dateWork);
        TentativeSchedule tentativeSchedule = tentativeScheduleRepository.findById(idSchedule);
        setSchedule(startTime, endTime, tentativeSchedule);
        tentativeScheduleRepository.addTentativeSchedule(tentativeSchedule);
    }

    private static void setSchedule(LocalTime startTime, LocalTime endTime, TentativeSchedule tentativeSchedule) {
        tentativeSchedule.setStartTime(startTime);
        tentativeSchedule.setEndTime(endTime);
    }

    @Override
    public List<TentativeSchedule> readTentativeScheduleById(Long idWorker, LocalDate date) {
        LocalDate[] week = getWeek(date);
        return tentativeScheduleRepository.readTentativeScheduleById(idWorker, week[0], week[1]);
    }

    @Override
    public LocalDate getMaxDate(Long idWorker) {
        return tentativeScheduleRepository.getMaxDate(idWorker);
    }

    @Override
    public void AddEmptySchedule(Long idWorker, LocalDate now){
        Worker worker = workerRepository.findById(idWorker);
        LocalDate[] week = getWeek(now);
        tentativeScheduleRepository.AddEmptySchedule(worker, week[0], week[1]);
    }
}
