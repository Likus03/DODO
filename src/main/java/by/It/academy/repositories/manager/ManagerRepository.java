package by.It.academy.repositories.manager;

import by.It.academy.entities.Manager;

import java.util.List;

public interface ManagerRepository {
    List<Manager> readManager();

    Manager createManager(Manager manager);
}
