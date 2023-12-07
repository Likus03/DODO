package by.It.academy.services;

import by.It.academy.entities.Worker;
import by.It.academy.repositories.Repository;
import by.It.academy.repositories.RepositoryImpl;

import java.util.List;

public class ServiceImpl implements Service{
    private final Repository repository = RepositoryImpl.getInstance();

    private static Service service;

    private ServiceImpl() {
    }

    @Override
    public List<Worker> read() {
        return repository.read();
    }

    @Override
    public void create(Worker worker) {
        repository.create(worker);
    }

    @Override
    public void update(Worker worker) {
repository.update(worker);
    }

    @Override
    public void delete(long id) {
repository.delete(id);
    }

    @Override
    public Worker getById(long id) {
        return repository.getById(id);
    }

    public static Service getInstance(){

        if(service == null){
            service = new ServiceImpl();
        }
        return service;
    }
}
