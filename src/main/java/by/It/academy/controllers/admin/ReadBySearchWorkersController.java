package by.It.academy.controllers.admin;

import by.It.academy.entities.Worker;
import by.It.academy.services.worker.WorkerService;
import by.It.academy.services.worker.WorkerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.It.academy.utils.Constants.INPUT_SEARCH;
import static by.It.academy.utils.Constants.READ_BY_SEARCH;

@WebServlet(urlPatterns = "/readBySearch")
public class ReadBySearchWorkersController extends HttpServlet {
    private final WorkerService workerService = WorkerServiceImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Worker> workers = workerService.readBySearch(req.getParameter(INPUT_SEARCH));
        req.setAttribute("workers", workers);
        req.getRequestDispatcher(READ_BY_SEARCH).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
