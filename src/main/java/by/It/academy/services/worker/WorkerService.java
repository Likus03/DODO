package by.It.academy.services.worker;

import by.It.academy.entities.Worker;

import java.util.List;

public interface WorkerService {
    List<Worker> readAll();
    List<Worker> readBySearch(String parameter);
//    void create(User user);
    void update(Worker worker);
    void delete(long id);
    Worker getById(long id);
}