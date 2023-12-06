package by.It.academy.controllers.kitchenWorker;

import by.It.academy.entities.Courier;
import by.It.academy.entities.KitchenWorker;
import by.It.academy.services.courier.CourierService;
import by.It.academy.services.courier.CourierServiceImpl;
import by.It.academy.services.kitchenWorker.KitchenWorkerService;
import by.It.academy.services.kitchenWorker.KitchenWorkerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@WebServlet(urlPatterns = "/kitchenWorkers/authorization")
public class AuthorizationKitchenWorkerController extends HttpServlet {

    KitchenWorkerService kitchenWorkerService = KitchenWorkerServiceImpl.getInstance();
    List<KitchenWorker> kitchenWorkers;
    HttpSession session = null;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        kitchenWorkers = kitchenWorkerService.readKitchenWorker();
        req.setAttribute("kitchenWorkers", kitchenWorkers);

        Optional<KitchenWorker> user = getLogInId(req.getParameter("login"), req.getParameter("password"));

        if (user.isEmpty()) {
            req.getRequestDispatcher("/pages/errors/errorLogIn.jsp").forward(req, resp);
        } else {
            session = req.getSession(true);
            session.setAttribute("userType", user.get().getUserType());
            req.getRequestDispatcher("/pages/kitchenWorkers/readKitchenWorkers.jsp").forward(req,resp);
        }
    }

    private Optional<KitchenWorker> getLogInId(String login, String password) {
        return kitchenWorkers.stream()
                .filter(courier -> (Objects.equals(courier.getLogin(), login) && Objects.equals(courier.getPassword(), password)))
                .findFirst();
    }

}
