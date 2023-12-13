package by.It.academy.controllers.admin;

import by.It.academy.entities.Worker;
import by.It.academy.mapper.WorkerMapper;
import by.It.academy.services.worker.WorkerService;
import by.It.academy.services.worker.WorkerServiceImpl;
import by.It.academy.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/read")
public class ReadWorkersController extends HttpServlet {
    private static final String COURIERS_PAGE = "/pages/admin/readWorkers.jsp"; //TODO: не courier
    private final WorkerMapper workerMapper = WorkerMapper.getInstance();
    private final WorkerService workerService = WorkerServiceImpl.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Worker> workers = workerService.read();
        req.setAttribute("workers", workers);
        req.getRequestDispatcher(COURIERS_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Constants.russianLang(req, resp);

        doGet(req, resp);

        Long id = Long.valueOf(req.getParameter("id"));

        Worker worker = workerMapper.buildWorker(req);
        worker.setId(id);

        workerService.update(worker);
        workerService.read();
        doGet(req, resp);
    }


}
