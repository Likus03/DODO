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

        Optional<Worker> user = getLoggedWorker(req.getParameter("username"), req.getParameter("password"), workers);

        switch (user.get().getWorkerType()) {  //TODO:нужен чек
            case ADMIN: {
                req.getRequestDispatcher(Constants.ADMIN_PAGE).forward(req, resp);
            }
            case COURIER: {
                HttpSession session = req.getSession(true);
                session.setAttribute("idWorker", user.get().getIdWorker());
                session.setAttribute("typeWorker", user.get().getWorkerType());

                req.getRequestDispatcher(Constants.COURIERS_PAGE).forward(req, resp);
                //перейти к сменам
            }
            case MANAGER:{
                //перейти к сменам
            }
            case KITCHEN_WORKER:{
                //перейти к сменам
            }
            default:{
                req.getRequestDispatcher(Constants.ERROR_LOGIN).forward(req, resp);
            }
        }
//        if (user.isEmpty()) {
//            req.getRequestDispatcher("/pages/errors/errorLogIn.jsp").forward(req, resp);
//        } else {
//            HttpSession session = req.getSession(true);
//            session.setAttribute("userType", user.get().getUserType());
//
//            req.getRequestDispatcher("/read").forward(req, resp);
//        }
    }

    private Optional<Worker> getLoggedWorker(String login, String password, List<Worker> workers) {
        return workers.stream()
                .filter(worker -> (Objects.equals(worker.getLogin(), login) && Objects.equals(worker.getPassword(), password)))
                .findFirst();
    }
}
