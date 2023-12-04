package by.It.academy.services.kitchenWorker;

import by.It.academy.entities.KitchenWorker;
import by.It.academy.repositories.kitchenWorker.KitchenWorkerRepository;
import by.It.academy.repositories.kitchenWorker.KitchenWorkerRepositoryImpl;

import java.util.List;

public class KitchenWorkerServiceImpl implements KitchenWorkerService {
    private final KitchenWorkerRepository kitchenWorkerRepository = KitchenWorkerRepositoryImpl.getInstance();
    private static KitchenWorkerService kitchenWorkerService;
    private KitchenWorkerServiceImpl(){}

    public List<KitchenWorker> readKitchenWorker(){return kitchenWorkerRepository.readKitchenWorker();}

    @Override
    public KitchenWorker createKitchenWorker(KitchenWorker kitchenWorker){return kitchenWorkerRepository.createKitchenWorker(kitchenWorker);}

    public static KitchenWorkerService getInstance(){

        if(kitchenWorkerService == null){
            kitchenWorkerService = new KitchenWorkerServiceImpl();
        }
        return kitchenWorkerService;
    }

    public KitchenWorker updateKitchenWorker(KitchenWorker kitchenWorker) {
        return kitchenWorkerRepository.updateKitchenWorker(kitchenWorker);
    }

}
