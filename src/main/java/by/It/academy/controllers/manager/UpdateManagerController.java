package by.It.academy.controllers.manager;

import by.It.academy.entities.Manager;
import by.It.academy.services.manager.ManagerService;
import by.It.academy.services.manager.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/managers/update")
public class UpdateManagerController extends HttpServlet {
    private static final String MANAGERS_PAGE = "/pages/managers/updateManagers.jsp";
    List<Manager> managers;
    private final ManagerService managerService = ManagerServiceImpl.getInstance();
    private String id;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id = req.getParameter("radioGroup");
        managers = managerService.readManager();

        if (req.getParameter("editManager").equals("delete")) {
            managers.remove(Integer.parseInt(id) - 1);
            req.setAttribute("managers", managers);
            req.getRequestDispatcher("/pages/managers/readManagers.jsp").forward(req, resp);
        } else {
            req.setAttribute("managers", managers.get(Integer.parseInt(id) - 1));
            req.getRequestDispatcher(MANAGERS_PAGE).forward(req, resp);
        }
    }
}
