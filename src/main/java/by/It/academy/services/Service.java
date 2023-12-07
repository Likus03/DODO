package by.It.academy.services;

import by.It.academy.entities.Worker;

import java.util.List;

public interface Service {
    List<Worker> read();
    void create(Worker worker);
    void update(Worker worker);
    void delete(long id);
    Worker getById(long id);
}