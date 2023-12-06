package by.It.academy.repositories.courier;

import by.It.academy.entities.Courier;
import by.It.academy.entities.UserType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class CourierRepositoryImpl implements CourierRepository {
    private static CourierRepository courierRepository;
    private static final List<Courier> couriers = new ArrayList<>();
    private static long id=1;

    private CourierRepositoryImpl() {
        couriers.add(new Courier(1L, "Tom", "Cat", "80443789123", "car", "ADMIN", "ADMIN", UserType.ADMIN));
        couriers.add(new Courier(2L, "Alex", "Bon", "80442599163", "car", "11", "111", UserType.USER));
        couriers.add(new Courier(3L, "Rick", "Gan", "80443971123", "velo", "22", "111", UserType.USER));
        couriers.add(new Courier(4L, "Jake", "Zek", "80443171123", "car", "33", "111", UserType.USER));
        couriers.add(new Courier(5L, "Li", "Ran", "80441271123", "velo", "44", "111", UserType.USER));

    }

    @Override
    public void createCourier(Courier courier) {
        courier.setId(id++);
        couriers.add(courier);
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
    public void updateCourier(Courier courier) {
        Courier findCourier=couriers.stream().filter(o-> Objects.equals(o.getId(), courier.getId())).findFirst().get();
        couriers.set(couriers.indexOf(findCourier),courier);
    }

    @Override
    public void deleteCourier(long id) {
        couriers.removeIf(courierTemp -> courierTemp.getId()==id);
    }

    @Override
    public Courier getCourierById(long id) {
        return couriers.stream().filter(courierTemp -> courierTemp.getId()==id).findFirst().get();
    }
}
