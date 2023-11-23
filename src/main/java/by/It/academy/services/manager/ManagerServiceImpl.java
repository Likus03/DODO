package by.It.academy.services.manager;

import by.It.academy.entities.Manager;
import by.It.academy.repositories.manager.ManagerRepository;
import by.It.academy.repositories.manager.ManagerRepositoryImpl;

import java.util.List;

public class ManagerServiceImpl implements ManagerService{
    private final ManagerRepository managerRepository = new ManagerRepositoryImpl();

    @Override
    public List<Manager> readManager() {
        return managerRepository.readManager();
    }
}
