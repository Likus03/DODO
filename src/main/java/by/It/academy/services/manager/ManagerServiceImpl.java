package by.It.academy.services.manager;

import by.It.academy.entities.Courier;
import by.It.academy.entities.Manager;
import by.It.academy.repositories.manager.ManagerRepository;
import by.It.academy.repositories.manager.ManagerRepositoryImpl;

import java.util.List;

public class ManagerServiceImpl implements ManagerService{
    private final ManagerRepository managerRepository = ManagerRepositoryImpl.getInstance();
    private static ManagerService managerService;

    private ManagerServiceImpl(){}
    @Override
    public void createManager(Manager manager){managerRepository.createManager(manager);}

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

    @Override
    public void updateManager(Manager manager) {
        managerRepository.updateManager(manager);
    }

    @Override
    public void deleteManager(long id) {
        managerRepository.deleteManager(id);
    }

    @Override
    public Manager getManager(long id) {
        return managerRepository.getManagerById(id);
    }
}
