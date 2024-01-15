package by.It.academy.repositories.worker;
import by.It.academy.entities.User;
import by.It.academy.entities.Worker;

import javax.persistence.TypedQuery;
import java.util.List;

public interface WorkerRepository{

    List<Worker> read();

    List<Worker> readBySearch(String parameter);

    void update(Worker worker);

    void delete(long id);
//    Worker getById(long id);
}
