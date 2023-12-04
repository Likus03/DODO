package by.It.academy.services.manager;

import by.It.academy.entities.Manager;

import java.util.List;

public interface ManagerService {
    Manager createManager(Manager manager);

    List<Manager> readManager();

    Manager updateManager(Manager manager);
}
