package by.It.academy.services.manager;

import by.It.academy.entities.Courier;
import by.It.academy.entities.Manager;

import java.util.List;

public interface ManagerService {
    void createManager(Manager manager);

    List<Manager> readManager();

    void updateManager(Manager manager);
    void deleteManager(long id);
    Manager getManager(long id);
}
