package by.It.academy.services.worker;

import by.It.academy.entities.User;
import by.It.academy.entities.Worker;
import by.It.academy.repositories.worker.WorkerRepository;
import by.It.academy.repositories.worker.WorkerRepositoryImpl;

import java.util.ArrayList;
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
    public List<Worker> read() {
        return workerRepository.read();
    }

    @Override
    public List<Worker> readBySearch(String parameter) {
        return workerRepository.readBySearch(parameter);
    }

//    @Override
//    public void create(User user) {
//        workerRepository.create(user);
//    }

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


}
