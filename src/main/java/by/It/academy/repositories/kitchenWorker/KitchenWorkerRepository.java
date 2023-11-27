package by.It.academy.repositories.kitchenWorker;

import by.It.academy.entities.KitchenWorker;

import java.util.List;

public interface KitchenWorkerRepository {
    List<KitchenWorker> readKitchenWorker();

    KitchenWorker createKitchenWorker(KitchenWorker kitchenWorker);
}
