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
import java.util.List;

@WebServlet(urlPatterns = "/update")
public class UpdateWorkersController extends HttpServlet {
    private final WorkerService workerService = WorkerServiceImpl.getInstance();
    private final WorkerMapper workerMapper = WorkerMapper.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Worker> workers = workerService.read();
        req.setAttribute("workers", workers);
        req.getRequestDispatcher("/pages/admin/updateWorkers.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        Worker worker = workerMapper.buildWorker(req);
        worker.setId(id);
        workerService.update(worker);
        doGet(req, resp);
    }
}
