package by.It.academy.repositories.kitchenWorker;

import by.It.academy.entities.KitchenWorker;

import java.util.List;

public class KitchenWorkerRepositoryImpl implements KitchenWorkerRepository{
    private final List<KitchenWorker> kitchenWorkers = List.of(
            new KitchenWorker("Anzhelika", "Pivovar", "91515156", "cooker")
    );
    @Override
    public List<KitchenWorker> readKitchenWorker(){return kitchenWorkers;}
}
