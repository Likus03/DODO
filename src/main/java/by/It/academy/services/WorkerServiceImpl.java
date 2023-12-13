package by.It.academy.services;

import by.It.academy.entities.Worker;
import by.It.academy.repositories.WorkerRepository;
import by.It.academy.repositories.WorkerRepositoryImpl;

import java.util.List;

public class WorkerServiceImpl implements WorkerService {
    private final WorkerRepository workerRepository = WorkerRepositoryImpl.getInstance();

    private static WorkerService workerService;

    private WorkerServiceImpl() {
    }

    @Override
    public List<Worker> read() {
        return workerRepository.read();
    }

    @Override
    public void create(Worker worker) {
        workerRepository.create(worker);
    }

    @Override
    public void update(Worker worker) {
workerRepository.update(worker);
    }

    @Override
    public void delete(long id) {
workerRepository.delete(id);
    }

    @Override
    public Worker getById(long id) {
        return workerRepository.getById(id);
    }

    public static WorkerService getInstance(){

        if(workerService == null){
            workerService = new WorkerServiceImpl();
        }
        return workerService;
    }
}
