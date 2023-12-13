package by.It.academy.controllers;

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
import java.util.Objects;
import java.util.Optional;

@WebServlet(urlPatterns = "/authorization")
public class AuthorizationController extends HttpServlet {
    private final WorkerService workerService = WorkerServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Worker> workers = workerService.read();

        Optional<Worker> user = getLoggedWorker(req.getParameter("username"), req.getParameter("password"), workers);

        switch (user.get().getUserType()) {  //TODO:нужен чек
            case ADMIN: {
                req.getRequestDispatcher("/pages/admin/admin.jsp").forward(req, resp);
            }
            case COURIER: {
                req.getRequestDispatcher("/pages/couriers/couriersPage.jsp").forward(req, resp);
                //перейти к сменам
                //перейти к завершенным заказам
            }
            case MANAGER:{
                //перейти к сменам
            }
            case KITCHEN_WORKER:{
                //перейти к сменам
            }
            default:{
                req.getRequestDispatcher("/pages/errors/errorLogIn.jsp").forward(req, resp);
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
