package by.It.academy.repositories.manager;

import by.It.academy.entities.Courier;
import by.It.academy.entities.Manager;

import java.util.List;

public interface ManagerRepository {
    List<Manager> readManager();

    void createManager(Manager manager);

    void updateManager(Manager manager);
    void deleteManager(long id);
    Manager getManagerById(long id);
}
