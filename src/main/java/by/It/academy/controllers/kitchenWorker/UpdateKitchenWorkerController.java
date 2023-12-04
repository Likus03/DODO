package by.It.academy.controllers.kitchenWorker;

import by.It.academy.entities.KitchenWorker;
import by.It.academy.services.kitchenWorker.KitchenWorkerService;
import by.It.academy.services.kitchenWorker.KitchenWorkerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/kitchenWorkers/update")
public class UpdateKitchenWorkerController extends HttpServlet {
    private static final String KITCHEN_WORKER_PAGE = "/pages/kitchenWorkers/updateKitchenWorkers.jsp";
    List<KitchenWorker> kitchenWorkers;
    private final KitchenWorkerService kitchenWorkerService = KitchenWorkerServiceImpl.getInstance();
    private String id;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        kitchenWorkers = kitchenWorkerService.readKitchenWorker();
        id = req.getParameter("radioGroup");
       // System.out.println(id);

        req.setAttribute("kitchenWorkers", kitchenWorkers.get(Integer.parseInt(id) - 1));
        req.getRequestDispatcher(KITCHEN_WORKER_PAGE).forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
