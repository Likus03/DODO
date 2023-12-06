package by.It.academy.repositories.manager;

import by.It.academy.entities.Courier;
import by.It.academy.entities.Manager;
import by.It.academy.entities.UserType;
import by.It.academy.repositories.courier.CourierRepository;
import by.It.academy.repositories.courier.CourierRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ManagerRepositoryImpl implements ManagerRepository{
    private static ManagerRepository managerRepository;
    private final List<Manager> managers = new ArrayList<>();
    private static long id=1;

    private ManagerRepositoryImpl(){
        managers.add(new Manager(1L, "Tom", "Cat", "80443789123", "ADMIN", "ADMIN", UserType.ADMIN));
        managers.add(new Manager(2L, "Alex", "Bon", "80442599163", "11", "111", UserType.USER));
        managers.add(new Manager(3L, "Rick", "Gan", "80443971123", "22", "111", UserType.USER));
        managers.add(new Manager(4L, "Jake", "Zek", "80443171123", "33", "111", UserType.USER));
        managers.add(new Manager(5L, "Li", "Ran", "80441271123", "44", "111", UserType.USER));
    }

    @Override
    public List<Manager> readManager() {
        return managers;
    }
    @Override
    public void createManager(Manager manager) {
        manager.setId(id++);
        managers.add(manager);
    }

    public static ManagerRepository getInstance() {
        if(managerRepository == null){
            managerRepository = new ManagerRepositoryImpl();
        }
        return managerRepository;
    }

    @Override
    public void updateManager(Manager manager) {
        Manager findCourier = managers.stream().filter(o -> Objects.equals(o.getId(), manager.getId())).findFirst().get();
        managers.set(managers.indexOf(findCourier), manager);
    }

    @Override
    public void deleteManager(long id) {
        managers.removeIf(managerTemp -> managerTemp.getId()==id);
    }

    @Override
    public Manager getManagerById(long id) {
        return managers.stream().filter(managerTemp -> managerTemp.getId()==id).findFirst().get();
    }
}
