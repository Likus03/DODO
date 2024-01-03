package by.It.academy.controllers.admin;

import by.It.academy.entities.Worker;
import by.It.academy.mapper.WorkerMapper;
import by.It.academy.services.worker.WorkerService;
import by.It.academy.services.worker.WorkerServiceImpl;

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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Worker worker = workerMapper.buildWorker(req);
        workerService.create(worker);

        req.getRequestDispatcher(ADMIN_PAGE).forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(CREATE_WORKER_PAGE).forward(req, resp);
    }
}
