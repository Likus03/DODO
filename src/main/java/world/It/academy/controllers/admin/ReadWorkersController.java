package world.It.academy.controllers.admin;

import world.It.academy.entities.Worker;
import world.It.academy.services.worker.WorkerService;
import world.It.academy.services.worker.WorkerServiceImpl;
import world.It.academy.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/read")
public class ReadWorkersController extends HttpServlet {
    private final WorkerService workerService = WorkerServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Worker> workers = workerService.readAll();

        req.setAttribute("workers", workers);
        req.getRequestDispatcher(Constants.READ_WORKERS_PAGE).forward(req, resp);
    }
}
