package by.It.academy.repositories.courier;

import by.It.academy.entities.Courier;

import java.util.List;

public interface CourierRepository {

    List<Courier> readCourier();

    Courier createCourier(Courier courier);
}
