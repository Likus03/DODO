package world.It.academy.services.worker;

import world.It.academy.entities.Worker;
import world.It.academy.repositories.worker.WorkerRepository;
import world.It.academy.repositories.worker.WorkerRepositoryImpl;

import java.util.List;

public class WorkerServiceImpl implements WorkerService {
    private final WorkerRepository workerRepository = WorkerRepositoryImpl.getInstance();
    private static WorkerService workerService;

    private WorkerServiceImpl() {
    }

    public static WorkerService getInstance() {
        if (workerService == null) {
            workerService = new WorkerServiceImpl();
        }
        return workerService;
    }

    @Override
    public List<Worker> readAll() {
        return workerRepository.readAll();
    }

    @Override
    public List<Worker> readBySearch(String parameter) {
        return workerRepository.readBySearch(parameter);
    }

    @Override
    public void update(Worker newWorker) {
        Worker oldWorker = workerRepository.findById(newWorker.getIdWorker());
        workerRepository.update(newWorker, oldWorker);
    }

    @Override
    public void delete(long id) {
        workerRepository.delete(id);
    }

    @Override
    public Worker getById(long id) {
        return workerRepository.getById(id);
    }



}
