package by.It.academy.controllers.manager;

import by.It.academy.entities.Manager;
import by.It.academy.mapper.manager.ManagerMapper;
import by.It.academy.services.manager.ManagerService;
import by.It.academy.services.manager.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/managers/create")
public class RegistrationManagerController extends HttpServlet {
    private static final String MANAGERS_PAGE = "/pages/managers/createManagers.jsp";
    private final ManagerService managerService = ManagerServiceImpl.getInstance();
    private final ManagerMapper managerMapper = new ManagerMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Manager manager = managerMapper.buildUser(req);
        managerService.createManager(manager);

        req.getRequestDispatcher(MANAGERS_PAGE).forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(MANAGERS_PAGE).forward(req, resp);
    }
}
