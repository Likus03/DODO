package by.It.academy.repositories.manager;

import by.It.academy.entities.Courier;
import by.It.academy.entities.Manager;
import by.It.academy.repositories.courier.CourierRepository;
import by.It.academy.repositories.courier.CourierRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class ManagerRepositoryImpl implements ManagerRepository{
    private static ManagerRepository managerRepository;
    private final List<Manager> managers = new ArrayList<>();

    private ManagerRepositoryImpl(){}

    @Override
    public List<Manager> readManager() {
        return managers;
    }
    @Override
    public Manager createManager(Manager manager) {
        manager.setId((long) managers.size() + 1);
        managers.add(manager);
        return manager;
    }

    public static ManagerRepository getInstance() {
        if(managerRepository == null){
            managerRepository = new ManagerRepositoryImpl();
        }
        return managerRepository;
    }

    @Override
    public Manager updateManager(Manager manager) {
        managers.set((int) (manager.getId() - 1), manager);
        return manager;
    }
}
