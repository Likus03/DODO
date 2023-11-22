package by.It.academy.services;

import by.It.academy.entities.Courier;
import by.It.academy.repositories.CourierRepository;
import by.It.academy.repositories.CourierRepositoryImpl;

import java.util.List;

public class CourierServiceImpl implements CourierService{
    private final CourierRepository courierRepository = new CourierRepositoryImpl();

    public List<Courier> readCourier() {
        return courierRepository.readCourier();
    }

}
