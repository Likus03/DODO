package world.It.academy.controllers;

import world.It.academy.entities.User;
import world.It.academy.WorkerType;
import world.It.academy.services.user.UserService;
import world.It.academy.services.user.UserServiceImpl;
import lombok.SneakyThrows;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static world.It.academy.utils.Constants.*;

@WebServlet(urlPatterns = "/authorization")
public class AuthorizationController extends HttpServlet {
    private final UserService userService = UserServiceImpl.getInstance();

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        User user = userService.getLoggedUser(req.getParameter(LOGIN), req.getParameter(PASSWORD));

        if (user == null) {
            req.getRequestDispatcher(ERROR_LOGIN).forward(req, resp);
        } else {
            menu(user.getWorker().getWorkerType(), user.getIdUser(), req, resp);
        }
    }

    @SneakyThrows
    private void menu(WorkerType workerType, long idUser, HttpServletRequest req, HttpServletResponse resp) {
        addSessionAttribute(workerType, idUser, req);

        switch (workerType) {
            case ADMIN -> req.getRequestDispatcher(ADMIN_PAGE).forward(req, resp);
            case COURIER -> req.getRequestDispatcher(COURIERS_PAGE).forward(req, resp);
            case MANAGER -> {}
            case KITCHEN_WORKER -> req.getRequestDispatcher(WORKERS_PAGE).forward(req, resp);
            default -> req.getRequestDispatcher(ERROR_LOGIN).forward(req, resp);
        }
    }

    private void addSessionAttribute(WorkerType workerType, long idUser, HttpServletRequest req) {
        HttpSession session = req.getSession(true);
        session.setAttribute(WORKER_TYPE, workerType);
        session.setAttribute("worker_id", idUser);
    }
}
