package by.It.academy.repositories.worker;

import by.It.academy.entities.WorkerType;
import by.It.academy.entities.Worker;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WorkerRepositoryImpl implements WorkerRepository {
    private static WorkerRepository workerRepository;
    private static final List<Worker> workers = new ArrayList<>();
    private static Long id = 7L;

    private WorkerRepositoryImpl() {
        workers.add(new Worker(1L, "Tom", "Cat", "80443789123", "admin", "admin", WorkerType.ADMIN));
        workers.add(new Worker(2L, "Bin", "Run", "80441271223", "33", "33", WorkerType.COURIER));
        workers.add(new Worker(3L, "Tom", "Cat", "80443789123", "1", "1", WorkerType.ADMIN));
        workers.add(new Worker(4L, "Alex", "Bon", "80442599163", "11", "11", WorkerType.MANAGER));
        workers.add(new Worker(5L, "Rick", "Gan", "80443971123", "gr", "22", WorkerType.KITCHEN_WORKER));
        workers.add(new Worker(6L, "Jake", "Zek", "80443171123", "55", "55", WorkerType.COURIER));
    }

    @Override
    public void create(Worker worker) {
        worker.setIdWorker(id++);
        workers.add(worker);
    }

    public static WorkerRepository getInstance() {
        if (workerRepository == null) {
            workerRepository = new WorkerRepositoryImpl();
        }
        return workerRepository;
    }

    @Override
    public List<Worker> read() {
        return workers;
    }

    @Override
    public void update(Worker worker) {
       workers.stream()
                .filter(o -> Objects.equals(o.getIdWorker(), worker.getIdWorker()))
                .findFirst()
                .ifPresent(findWorker ->  workers.set(workers.indexOf(findWorker), worker));
    }

    @Override
    public void delete(long id) {
        workers.removeIf(workerTemp -> workerTemp.getIdWorker() == id);
    }

    @Override
    public Worker getById(long id) {
        return workers.stream().filter(workerTemp -> workerTemp.getIdWorker() == id).findFirst().get();
    }
}
