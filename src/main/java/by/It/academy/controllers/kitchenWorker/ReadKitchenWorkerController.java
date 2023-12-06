package by.It.academy.controllers.kitchenWorker;

import by.It.academy.entities.Courier;
import by.It.academy.entities.KitchenWorker;
import by.It.academy.mapper.kitchenWorker.KitchenWorkerMapper;
import by.It.academy.services.kitchenWorker.KitchenWorkerService;
import by.It.academy.services.kitchenWorker.KitchenWorkerServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/kitchenWorkers/read")
public class ReadKitchenWorkerController extends HttpServlet {
    private static final String KITCHEN_WORKERS_PAGE = "/pages/kitchenWorkers/readKitchenWorkers.jsp";
    private final KitchenWorkerService kitchenWorkerService = KitchenWorkerServiceImpl.getInstance();
    private final KitchenWorkerMapper kitchenWorkerMapper = new KitchenWorkerMapper();
    List<KitchenWorker> kitchenWorkers;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        kitchenWorkers = kitchenWorkerService.readKitchenWorker();

        req.setAttribute("kitchenWorkers", kitchenWorkers);
        req.getRequestDispatcher(KITCHEN_WORKERS_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        Long id = Long.valueOf(req.getParameter("id"));

        KitchenWorker kitchenWorker = kitchenWorkerMapper.buildUser(req);
        kitchenWorker.setId(id);

        kitchenWorkerService.updateKitchenWorker(kitchenWorker);
        kitchenWorkerService.readKitchenWorker();
        doGet(req, resp);
    }
}
