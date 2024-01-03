package by.It.academy.controllers;

import by.It.academy.entities.Worker;
import by.It.academy.entities.WorkerType;
import by.It.academy.services.worker.WorkerService;
import by.It.academy.services.worker.WorkerServiceImpl;
import lombok.SneakyThrows;

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

import static by.It.academy.utils.Constants.*;

@WebServlet(urlPatterns = "/authorization")
public class AuthorizationController extends HttpServlet {
    private final WorkerService workerService = WorkerServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        List<Worker> workers = workerService.read();

        getLoggedWorker(req.getParameter(LOGIN), req.getParameter(PASSWORD), workers)
                .ifPresentOrElse(worker -> menu(worker.getWorkerType(), req, resp), () -> forward(req, resp)
                );
    }

    @SneakyThrows
    private void forward(HttpServletRequest req, HttpServletResponse resp) {
        req.getRequestDispatcher(ERROR_LOGIN).forward(req, resp);
    }

    private Optional<Worker> getLoggedWorker(String login, String password, List<Worker> workers) {
        return workers.stream()
                .filter(worker -> Objects.equals(worker.getLogin(), login) && Objects.equals(worker.getPassword(), password))
                .findFirst();
    }

    @SneakyThrows
    private void menu(WorkerType workerType, HttpServletRequest req, HttpServletResponse resp) {
        switch (workerType) {
            case ADMIN -> req.getRequestDispatcher(ADMIN_PAGE).forward(req, resp);
            case COURIER -> goToCourier(workerType, req, resp);
            case MANAGER, KITCHEN_WORKER -> {}
            default -> req.getRequestDispatcher(ERROR_LOGIN).forward(req, resp);
        }
    }

    @SneakyThrows
    private void goToCourier(WorkerType workerType, HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession(true);
        session.setAttribute("idWorker", workerType);
        session.setAttribute(WORKER_TYPE, workerType);

        req.getRequestDispatcher(COURIERS_PAGE).forward(req, resp);
    }
}
