package by.It.academy.controllers;

import by.It.academy.entities.Worker;
import by.It.academy.services.Service;
import by.It.academy.services.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/update")
public class UpdateController extends HttpServlet {
    private static final String COURIERS_PAGE = "/pages/updateWorker.jsp";
    List<Worker> workers;
    private final Service service = ServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("radioGroup");
        workers = service.read();

        if (req.getParameter("editCourier").equals("delete")) {

            service.delete(Long.parseLong(id));
            req.setAttribute("workers", workers);
            req.getRequestDispatcher("/pages/readWorkers.jsp").forward(req, resp);
        } else {
            req.setAttribute("courier", service.getById(Long.parseLong(id)));
            req.getRequestDispatcher(COURIERS_PAGE).forward(req, resp);
        }
    }
}
