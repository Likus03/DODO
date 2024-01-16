package world.It.academy.controllers.admin;

import world.It.academy.services.worker.WorkerService;
import world.It.academy.services.worker.WorkerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static world.It.academy.utils.Constants.UPDATE_ACTION_PAGE;

@WebServlet(urlPatterns = "/updateAction")
public class UpdateActionWorkersController extends HttpServlet {
    private final WorkerService workerService = WorkerServiceImpl.getInstance();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        req.setAttribute("worker", workerService.getById(Long.parseLong(id)));
        req.getRequestDispatcher(UPDATE_ACTION_PAGE).forward(req, resp);
    }
}
