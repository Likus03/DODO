package by.It.academy.repositories;

import by.It.academy.entities.UserType;
import by.It.academy.entities.Worker;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RepositoryImpl implements Repository {
    private static Repository repository;
    private static final List<Worker> workers = new ArrayList<>();
    private static long id=6;

    private RepositoryImpl() {
        workers.add(new Worker(1L, "Tom", "Cat", "80443789123", "admin", "admin", UserType.ADMIN));
        workers.add(new Worker(2L, "Alex", "Bon", "80442599163", "11", "11", UserType.MANAGER));
        workers.add(new Worker(3L, "Rick", "Gan", "80443971123", "gr", "22", UserType.KITCHEN_WORKER));
        workers.add(new Worker(4L, "Jake", "Zek", "80443171123", "yy", "33", UserType.COURIER));
        workers.add(new Worker(5L, "Li", "Ran", "80441271123", "io", "44", UserType.KITCHEN_WORKER));
    }

    @Override
    public void create(Worker worker) {
        worker.setId(id++);
        workers.add(worker);
    }

    public static Repository getInstance() {
        if (repository == null) {
            repository = new RepositoryImpl();
        }
        return repository;
    }

    @Override
    public List<Worker> read() {
        return workers;
    }

    @Override
    public void update(Worker worker) {
        Worker findWorker = workers.stream().filter(o -> Objects.equals(o.getId(), worker.getId())).findFirst().get();
        workers.set(workers.indexOf(findWorker), worker);
    }

    @Override
    public void delete(long id) {
        workers.removeIf(workerTemp -> workerTemp.getId()==id);
    }

    @Override
    public Worker getById(long id) {
        return workers.stream().filter(workerTemp -> workerTemp.getId()==id).findFirst().get();
    }


}
