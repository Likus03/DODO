package by.It.academy.services.kitchenWorker;

import by.It.academy.entities.Courier;
import by.It.academy.entities.KitchenWorker;

import java.util.List;

public interface KitchenWorkerService {
    List<KitchenWorker> readKitchenWorker();

    KitchenWorker createKitchenWorker(KitchenWorker kitchenWorker);
    KitchenWorker updateKitchenWorker(KitchenWorker kitchenWorker);

}
