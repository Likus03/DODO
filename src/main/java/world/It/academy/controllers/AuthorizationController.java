package world.It.academy.controllers;

import world.It.academy.entities.User;
import world.It.academy.WorkerType;
import world.It.academy.services.user.UserService;
import world.It.academy.services.user.UserServiceImpl;
import lombok.SneakyThrows;
import world.It.academy.utils.Constants;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/authorization")
public class AuthorizationController extends HttpServlet {
    private final UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        User user = userService.getLoggedUser(req.getParameter(Constants.LOGIN), req.getParameter(Constants.PASSWORD));

        if(user == null) {
            forwardErrorLogIn(req, resp);
        }
        else {
            menu(user.getWorker().getWorkerType(), user.getIdUser(), req, resp);
        }
    }

    @SneakyThrows
    private void forwardErrorLogIn(HttpServletRequest req, HttpServletResponse resp) {
        req.getRequestDispatcher(Constants.ERROR_LOGIN).forward(req, resp);
    }

    @SneakyThrows
    private void menu(WorkerType workerType, long idUser, HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession(true);
        session.setAttribute(Constants.WORKER_TYPE, workerType);

        switch (workerType) {
            case ADMIN -> req.getRequestDispatcher(Constants.ADMIN_PAGE).forward(req, resp);
            case COURIER -> goToCourier(idUser, req, resp);
            case MANAGER, KITCHEN_WORKER -> {}
            default -> req.getRequestDispatcher(Constants.ERROR_LOGIN).forward(req, resp);
        }
    }

    @SneakyThrows
    private void goToCourier(long workerId, HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession(true);
        session.setAttribute("worker_id", workerId);

        req.getRequestDispatcher(Constants.COURIERS_PAGE).forward(req, resp);
    }
}
