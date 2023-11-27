package by.It.academy.controllers.kitchenWorker;

import by.It.academy.entities.KitchenWorker;
import by.It.academy.mapper.kitchenWorker.KitchenWorkerMapper;
import by.It.academy.services.kitchenWorker.KitchenWorkerService;
import by.It.academy.services.kitchenWorker.KitchenWorkerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/kitchenWorkers/create")
public class CreateKitchenWorkerController extends HttpServlet {
    private static final String KITCHEN_WORKERS_PAGE = "/pages/kitchenWorkers/createKitchenWorkers.jsp";
    private final KitchenWorkerService kitchenWorkerService = KitchenWorkerServiceImpl.getInstance();
    private final KitchenWorkerMapper kitchenWorkerMapper = new KitchenWorkerMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        KitchenWorker kitchenWorker = kitchenWorkerMapper.buildUser(req);
        kitchenWorkerService.createKitchenWorker(kitchenWorker);

        req.getRequestDispatcher("/kitchenWorkers/read").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(KITCHEN_WORKERS_PAGE).forward(req, resp);
    }
}
