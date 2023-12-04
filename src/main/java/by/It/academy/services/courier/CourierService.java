package by.It.academy.services.courier;

import by.It.academy.entities.Courier;

import java.util.List;

public interface CourierService {
    List<Courier> readCourier();

    Courier createCourier(Courier courier);

    Courier updateCourier(Courier courier, Long id);
}
