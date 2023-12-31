package by.It.academy.controllers.manager;

import by.It.academy.entities.Manager;
import by.It.academy.services.manager.ManagerApiService;
import by.It.academy.services.manager.ManagerService;
import by.It.academy.services.manager.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/managers/read")
public class ReadManagerController extends HttpServlet {
    private ManagerService managerService = new ManagerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Manager> managers = managerService.readManager();

        req.setAttribute("managers", managers);
        req.getRequestDispatcher("/pages/managers/managers.jsp").forward(req, resp);
    }
}
