package by.It.academy.repositories.courier;

import by.It.academy.entities.Courier;

import java.util.ArrayList;
import java.util.List;

public class CourierRepositoryImpl implements CourierRepository {
    private static CourierRepository courierRepository;
    private static final List<Courier> couriers = new ArrayList<>();

    private CourierRepositoryImpl() {
    }

    @Override
    public Courier createCourier(Courier courier) {
        courier.setId((long) couriers.size() + 1);
        couriers.add(courier);
        return courier;
    }

    public static CourierRepository getInstance() {
        if (courierRepository == null) {
            courierRepository = new CourierRepositoryImpl();
        }
        return courierRepository;
    }

    @Override
    public List<Courier> readCourier() {
        return couriers;
    }

    @Override
    public Courier updateCourier(Courier courier) {
        couriers.set((int) (courier.getId() - 1), courier);
        return courier;
    }
}
