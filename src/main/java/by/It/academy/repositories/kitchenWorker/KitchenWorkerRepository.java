package by.It.academy.repositories.kitchenWorker;

import by.It.academy.entities.Courier;
import by.It.academy.entities.KitchenWorker;

import java.util.List;

public interface KitchenWorkerRepository {
    List<KitchenWorker> readKitchenWorker();

    void createKitchenWorker(KitchenWorker kitchenWorker);

    void updateKitchenWorker(KitchenWorker kitchenWorker);

    void deleteKitchenWorker(long id);
    KitchenWorker getKitchenWorkerById(long id);
}
