package world.It.academy.controllers.admin;

import world.It.academy.entities.Worker;
import world.It.academy.services.user.UserService;
import world.It.academy.services.user.UserServiceImpl;
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

@WebServlet(urlPatterns = "/delete")
public class DeleteWorkersController extends HttpServlet {
    private final WorkerService workerService = WorkerServiceImpl.getInstance();
    private final UserService userService = UserServiceImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Worker> workers = workerService.readAll();
        req.setAttribute(Constants.WORKERS, workers);
        req.getRequestDispatcher(Constants.DELETE_WORKER_PAGE).forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter(Constants.ID_WORKER);
        userService.delete(Long.parseLong(id));
        doGet(req,resp);
    }
}
