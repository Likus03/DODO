package by.It.academy.services.kitchenWorker;

import by.It.academy.entities.KitchenWorker;
import by.It.academy.repositories.kitchenWorker.KitchenWorkerRepository;
import by.It.academy.repositories.kitchenWorker.KitchenWorkerRepositoryImpl;

import java.util.List;

public class KitchenWorkerServiceImpl implements KitchenWorkerService {
    private final KitchenWorkerRepository kitchenWorkerRepository = new KitchenWorkerRepositoryImpl();

    public List<KitchenWorker> readKitchenWorker(){return kitchenWorkerRepository.readKitchenWorker();}
}
