package by.It.academy.services.kitchenWorker;

import by.It.academy.entities.Courier;
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
    public void createKitchenWorker(KitchenWorker kitchenWorker){kitchenWorkerRepository.createKitchenWorker(kitchenWorker);}

    public static KitchenWorkerService getInstance(){

        if(kitchenWorkerService == null){
            kitchenWorkerService = new KitchenWorkerServiceImpl();
        }
        return kitchenWorkerService;
    }

    public void updateKitchenWorker(KitchenWorker kitchenWorker) {
        kitchenWorkerRepository.updateKitchenWorker(kitchenWorker);
    }

    @Override
    public void deleteKitchenWorker(long id) {
        kitchenWorkerRepository.deleteKitchenWorker(id);
    }

    @Override
    public KitchenWorker getKitchenWorker(long id) {
        return kitchenWorkerRepository.getKitchenWorkerById(id);
    }

}
