package by.It.academy.controllers.manager;

import by.It.academy.entities.Courier;
import by.It.academy.entities.Manager;
import by.It.academy.services.courier.CourierService;
import by.It.academy.services.courier.CourierServiceImpl;
import by.It.academy.services.manager.ManagerService;
import by.It.academy.services.manager.ManagerServiceImpl;

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

@WebServlet(urlPatterns = "/managers/authorization")
public class AuthorizationManagerController extends HttpServlet {
    ManagerService managerService = ManagerServiceImpl.getInstance();
    List<Manager> managers;
    HttpSession session = null;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        managers = managerService.readManager();
        req.setAttribute("managers", managers);

        Optional<Manager> user = getLogInId(req.getParameter("login"), req.getParameter("password"));

        if (user.isEmpty()) {
            req.getRequestDispatcher("/pages/errors/errorLogIn.jsp").forward(req, resp);
        } else {
            session = req.getSession(true);
            session.setAttribute("userType", user.get().getUserType());
            req.getRequestDispatcher("/pages/managers/readManagers.jsp").forward(req,resp);
        }
    }

    private Optional<Manager> getLogInId(String login, String password) {
        return managers.stream()
                .filter(courier -> (Objects.equals(courier.getLogin(), login) && Objects.equals(courier.getPassword(), password)))
                .findFirst();
    }

}
