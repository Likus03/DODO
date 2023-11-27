package by.It.academy.services.manager;

import by.It.academy.entities.Manager;
import by.It.academy.repositories.manager.ManagerRepository;
import by.It.academy.repositories.manager.ManagerRepositoryImpl;

import java.util.List;

public class ManagerServiceImpl implements ManagerService{
    private final ManagerRepository managerRepository = ManagerRepositoryImpl.getInstance();
    private static ManagerService managerService;

    private ManagerServiceImpl(){}
    @Override
    public Manager createManager(Manager manager){return managerRepository.createManager(manager);}

    public static ManagerService getInstance() {
        if(managerService == null){
            managerService = new ManagerServiceImpl();
        }
        return managerService;
    }

    @Override
    public List<Manager> readManager() {
        return managerRepository.readManager();
    }
}
