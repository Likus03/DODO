package by.It.academy.services.kitchenWorker;

import by.It.academy.entities.Courier;
import by.It.academy.entities.KitchenWorker;

import java.util.List;

public interface KitchenWorkerService {
    List<KitchenWorker> readKitchenWorker();

    void createKitchenWorker(KitchenWorker kitchenWorker);
    void updateKitchenWorker(KitchenWorker kitchenWorker);

    void deleteKitchenWorker(long id);
    KitchenWorker getKitchenWorker(long id);
}
