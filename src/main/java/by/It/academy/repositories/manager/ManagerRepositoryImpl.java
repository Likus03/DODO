package by.It.academy.repositories.manager;

import by.It.academy.entities.Manager;

import java.util.List;

public class ManagerRepositoryImpl implements ManagerRepository{
    private final List<Manager> managers = List.of(
            new Manager("Margo", "Svechko", "448464646"),
            new Manager()
    );

    @Override
    public List<Manager> readManager() {
        return managers;
    }
}
