package by.It.academy.controllers;

import by.It.academy.entities.User;
import by.It.academy.WorkerType;
import by.It.academy.services.user.UserService;
import by.It.academy.services.user.UserServiceImpl;
import lombok.SneakyThrows;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static by.It.academy.utils.Constants.*;

@WebServlet(urlPatterns = "/authorization")
public class AuthorizationController extends HttpServlet {
    private final UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        User user = userService.getLoggedUser(req.getParameter(LOGIN), req.getParameter(PASSWORD));

        if(user == null) {
            forwardErrorLogIn(req, resp);
        }
        else {
            menu(user.getWorker().getWorkerType(), user.getIdUser(), req, resp);
        }
    }

    @SneakyThrows
    private void forwardErrorLogIn(HttpServletRequest req, HttpServletResponse resp) {
        req.getRequestDispatcher(ERROR_LOGIN).forward(req, resp);
    }

    @SneakyThrows
    private void menu(WorkerType workerType, long idUser, HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession(true);
        session.setAttribute(WORKER_TYPE, workerType);

        switch (workerType) {
            case ADMIN -> req.getRequestDispatcher(ADMIN_PAGE).forward(req, resp);
            case COURIER -> goToCourier(idUser, req, resp);
            case MANAGER, KITCHEN_WORKER -> {}
            default -> req.getRequestDispatcher(ERROR_LOGIN).forward(req, resp);
        }
    }

    @SneakyThrows
    private void goToCourier(long idUser, HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession(true);
        session.setAttribute("idUser", idUser);

        req.getRequestDispatcher(COURIERS_PAGE).forward(req, resp);
    }
}
