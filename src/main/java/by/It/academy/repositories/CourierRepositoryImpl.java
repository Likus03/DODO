package by.It.academy.repositories;

import by.It.academy.entities.Courier;

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
