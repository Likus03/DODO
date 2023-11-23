package by.It.academy.services.courier;

import by.It.academy.entities.Courier;
import by.It.academy.repositories.courier.CourierRepository;
import by.It.academy.repositories.courier.CourierRepositoryImpl;
import by.It.academy.services.courier.CourierService;

import java.util.List;

public class CourierServiceImpl implements CourierService {
    private final CourierRepository courierRepository = new CourierRepositoryImpl();

    public List<Courier> readCourier() {
        return courierRepository.readCourier();
    }

}
