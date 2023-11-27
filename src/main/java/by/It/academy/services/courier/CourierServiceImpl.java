package by.It.academy.services.courier;

import by.It.academy.entities.Courier;
import by.It.academy.repositories.courier.CourierRepository;
import by.It.academy.repositories.courier.CourierRepositoryImpl;

import java.util.List;

public class CourierServiceImpl implements CourierService {
    private final CourierRepository courierRepository = CourierRepositoryImpl.getInstance();

    private static CourierService courierService;

    private CourierServiceImpl(){}

    public List<Courier> readCourier() {
        return courierRepository.readCourier();
    }

    @Override
    public Courier createCourier(Courier courier) {
        return courierRepository.createCourier(courier);
    }

    public static CourierService getInstance(){

        if(courierService == null){
            courierService = new CourierServiceImpl();
        }
        return courierService;
    }

}
