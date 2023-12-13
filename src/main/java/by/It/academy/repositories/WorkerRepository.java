package by.It.academy.repositories;
import by.It.academy.entities.Worker;

import java.util.List;

public interface WorkerRepository {

    List<Worker> read();

    void create(Worker worker);

    void update(Worker worker);

    void delete(long id);
    Worker getById(long id);
}
