package by.It.academy.controllers.admin;

import by.It.academy.repositories.worker.WorkerRepository;
import by.It.academy.repositories.worker.WorkerRepositoryImpl;
import by.It.academy.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/updateAction")
public class UpdateActionWorkersController extends HttpServlet {
    private final WorkerRepository repository = WorkerRepositoryImpl.getInstance();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        req.setAttribute("worker", repository.getById(Long.parseLong(id)));
        req.getRequestDispatcher(Constants.UPDATE_ACTION_PAGE).forward(req, resp);
    }
}
