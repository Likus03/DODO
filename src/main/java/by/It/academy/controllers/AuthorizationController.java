package by.It.academy.controllers;

import by.It.academy.entities.Worker;
import by.It.academy.services.worker.WorkerService;
import by.It.academy.services.worker.WorkerServiceImpl;
import by.It.academy.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@WebServlet(urlPatterns = "/authorization")
public class AuthorizationController extends HttpServlet {
    private final WorkerService workerService = WorkerServiceImpl.getInstance();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Worker> workers = workerService.read();

        Optional<Worker> workerOptional = getLoggedWorker(req.getParameter(Constants.LOGIN), req.getParameter(Constants.PASSWORD), workers);
        if (workerOptional.isPresent()) {
            menu(workerOptional, req, resp);
        } else {
            req.getRequestDispatcher(Constants.ERROR_LOGIN).forward(req, resp);
        }
    }

    private Optional<Worker> getLoggedWorker(String login, String password, List<Worker> workers) {
        return workers.stream()
                .filter(worker -> Objects.equals(worker.getLogin(), login) && Objects.equals(worker.getPassword(), password))
                .findFirst();
    }

    private void menu(Optional<Worker> workerOptional, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (workerOptional.get().getWorkerType()) {
            case ADMIN: {
                req.getRequestDispatcher(Constants.ADMIN_PAGE).forward(req, resp);
            }
            case COURIER: {
                goToCourier(workerOptional, req, resp);
            }
            case MANAGER: {}
            case KITCHEN_WORKER: {}
        }
    }

    private void goToCourier(Optional<Worker> workerOptional, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        session.setAttribute("idWorker", workerOptional.get().getIdWorker());
        session.setAttribute(Constants.WORKER_TYPE, workerOptional.get().getWorkerType());

        req.getRequestDispatcher(Constants.COURIERS_PAGE).forward(req, resp);
    }
}
