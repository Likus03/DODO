package by.It.academy.services.courier;

import by.It.academy.entities.Courier;

import java.util.List;

public interface CourierService {
    List<Courier> readCourier();

    void createCourier(Courier courier);

    void updateCourier(Courier courier);
    void deleteCourier(long id);
    Courier getCourier(long id);
}
