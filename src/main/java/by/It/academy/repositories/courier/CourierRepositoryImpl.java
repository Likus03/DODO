package by.It.academy.repositories.courier;

import by.It.academy.entities.Courier;
import by.It.academy.repositories.courier.CourierRepository;

import java.util.List;

public class CourierRepositoryImpl implements CourierRepository {
    private final List<Courier> couriers = List.of(
            new Courier("Slava", "Petrov", "41451464", "auto"),
            new Courier()
    );
    @Override
    public List<Courier> readCourier() {
        return couriers;
    }
}
