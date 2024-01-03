package by.It.academy.services.worker;

import by.It.academy.entities.Worker;

import java.util.List;

public interface WorkerService {
    List<Worker> read();
    void create(Worker worker);
    void update(Worker worker);
    void delete(long id);
    Worker getById(long id);
}