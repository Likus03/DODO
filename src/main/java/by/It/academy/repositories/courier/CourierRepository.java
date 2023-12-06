package by.It.academy.repositories.courier;

import by.It.academy.entities.Courier;

import java.util.List;

public interface CourierRepository {

    List<Courier> readCourier();

    void createCourier(Courier courier);

    void updateCourier(Courier courier);

    void deleteCourier(long id);
    Courier getCourierById(long id);
}
