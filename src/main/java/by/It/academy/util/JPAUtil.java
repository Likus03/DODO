package by.It.academy.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManager ENTITY_MANAGER = buildEntityManager();

    private static EntityManager buildEntityManager() {
        return Persistence.createEntityManagerFactory("DODO")
                .createEntityManager();
    }
    public static EntityManager getEntityManager(){
        return ENTITY_MANAGER;
    }
}
