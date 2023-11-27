package by.It.academy.repositories.kitchenWorker;

import by.It.academy.entities.KitchenWorker;
import by.It.academy.repositories.courier.CourierRepository;
import by.It.academy.repositories.courier.CourierRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class KitchenWorkerRepositoryImpl implements KitchenWorkerRepository{
    private static KitchenWorkerRepository kitchenWorkerRepository;
    private final List<KitchenWorker> kitchenWorkers = new ArrayList<>();

    private KitchenWorkerRepositoryImpl(){}

    @Override
    public KitchenWorker createKitchenWorker(KitchenWorker kitchenWorker) {
        kitchenWorker.setId((long) kitchenWorkers.size() + 1);
        kitchenWorkers.add(kitchenWorker);
        return kitchenWorker;
    }

    public static KitchenWorkerRepository getInstance() {
        if(kitchenWorkerRepository == null){
            kitchenWorkerRepository = new KitchenWorkerRepositoryImpl();
        }
        return kitchenWorkerRepository;
    }

    @Override
    public List<KitchenWorker> readKitchenWorker(){return kitchenWorkers;}
}
