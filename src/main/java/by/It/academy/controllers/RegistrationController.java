package by.It.academy.controllers;

import by.It.academy.entities.Worker;
import by.It.academy.mapper.WorkerMapper;
import by.It.academy.services.Service;
import by.It.academy.services.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/create")
public class RegistrationController extends HttpServlet {
    private static final String COURIERS_PAGE = "/pages/createWorker.jsp";
    private final Service service = ServiceImpl.getInstance();
    private final WorkerMapper workerMapper = new WorkerMapper();
    HttpSession session = null;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Worker worker = workerMapper.buildUser(req);
        List<Worker> workers = service.read();
        service.create(worker);

        session = req.getSession(true);
        session.setAttribute("userType", worker.getUserType());

        req.setAttribute("workers", workers);
        req.getRequestDispatcher("/pages/readWorkers.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(COURIERS_PAGE).forward(req, resp);

    }
}
