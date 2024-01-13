package by.It.academy.controllers.admin;

import by.It.academy.entities.Worker;
import by.It.academy.entities.WorkerType;
import by.It.academy.mapper.WorkerMapper;
import by.It.academy.services.worker.WorkerService;
import by.It.academy.services.worker.WorkerServiceImpl;
import by.It.academy.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.It.academy.utils.Constants.*;

@WebServlet(urlPatterns = "/create")
public class CreateWorkersController extends HttpServlet {
    private final WorkerService workerService = WorkerServiceImpl.getInstance();
    private final WorkerMapper workerMapper = WorkerMapper.getInstance();

    private static void save() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Worker worker = new Worker("pasha", "durov", "4736732932", "44", "44");

        entityManager.persist(worker);
        transaction.commit();
        entityManager.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Worker worker = workerMapper.buildWorker(req);
//        workerService.create(worker);
        save();

        req.getRequestDispatcher(ADMIN_PAGE).forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(CREATE_WORKER_PAGE).forward(req, resp);
    }
}
