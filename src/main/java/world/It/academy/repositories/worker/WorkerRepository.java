package world.It.academy.repositories.worker;

import world.It.academy.entities.Worker;

import java.util.List;

public interface WorkerRepository {

    List<Worker> readAll();

    List<Worker> readBySearch(String parameter);

    void update(Worker worker, Worker updateWorker);

    void setUpdatingWorker(Worker worker, Worker updateWorker);

    Worker findById(Long id);

    void delete(long id);

    Worker getById(long id);
}
