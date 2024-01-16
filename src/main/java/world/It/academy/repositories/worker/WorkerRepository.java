package world.It.academy.repositories.worker;

import world.It.academy.entities.Worker;

import java.util.List;

public interface WorkerRepository{

    List<Worker> readAll();

    List<Worker> readBySearch(String parameter);

    void update(Worker worker);

    void delete(long id);
    Worker getById(long id);
}