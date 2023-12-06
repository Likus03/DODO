package by.It.academy.repositories.kitchenWorker;

import by.It.academy.entities.Courier;
import by.It.academy.entities.KitchenWorker;
import by.It.academy.entities.UserType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class KitchenWorkerRepositoryImpl implements KitchenWorkerRepository{
    private static KitchenWorkerRepository kitchenWorkerRepository;
    private final List<KitchenWorker> kitchenWorkers = new ArrayList<>();

    private static long id=1;

    private KitchenWorkerRepositoryImpl(){
        kitchenWorkers.add(new KitchenWorker(1L, "Tom", "Cat", "80443789123", "cashier", "ADMIN", "ADMIN", UserType.ADMIN));
        kitchenWorkers.add(new KitchenWorker(2L, "Alex", "Bon", "80442599163", "cook", "11", "111", UserType.USER));
        kitchenWorkers.add(new KitchenWorker(3L, "Rick", "Gan", "80443971123", "cook", "22", "111", UserType.USER));
        kitchenWorkers.add(new KitchenWorker(4L, "Jake", "Zek", "80443171123", "cook", "33", "111", UserType.USER));
        kitchenWorkers.add(new KitchenWorker(5L, "Li", "Ran", "80441271123", "cashier", "44", "111", UserType.USER));

    }

    @Override
    public void createKitchenWorker(KitchenWorker kitchenWorker) {
        kitchenWorker.setId(id++);
        kitchenWorkers.add(kitchenWorker);
    }

    public static KitchenWorkerRepository getInstance() {
        if(kitchenWorkerRepository == null){
            kitchenWorkerRepository = new KitchenWorkerRepositoryImpl();
        }
        return kitchenWorkerRepository;
    }

    @Override
    public List<KitchenWorker> readKitchenWorker(){return kitchenWorkers;}

    @Override
    public void updateKitchenWorker(KitchenWorker kitchenWorker) {
        KitchenWorker findCourier=kitchenWorkers.stream().filter(o-> Objects.equals(o.getId(), kitchenWorker.getId())).findFirst().get();
        kitchenWorkers.set(kitchenWorkers.indexOf(findCourier),kitchenWorker);
    }

    @Override
    public void deleteKitchenWorker(long id) {
        kitchenWorkers.removeIf(kitchenWorkerTemp -> kitchenWorkerTemp.getId()==id);
    }

    @Override
    public KitchenWorker getKitchenWorkerById(long id) {
        return kitchenWorkers.stream().filter(kitchenWorkerTemp -> kitchenWorkerTemp.getId()==id).findFirst().get();
    }
}
