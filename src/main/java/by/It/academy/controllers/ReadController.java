package by.It.academy.controllers;

import by.It.academy.entities.Worker;
import by.It.academy.mapper.WorkerMapper;
import by.It.academy.repositories.Repository;
import by.It.academy.repositories.RepositoryImpl;
import by.It.academy.services.Service;
import by.It.academy.services.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/read")
public class ReadController extends HttpServlet {
    private static final String COURIERS_PAGE = "/pages/readWorkers.jsp";
    private final WorkerMapper courierMapper = new WorkerMapper();
    private final Service service = ServiceImpl.getInstance();
    List<Worker> workers;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        workers = service.read();
        req.setAttribute("workers", workers);
        req.getRequestDispatcher(COURIERS_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        Long id = Long.valueOf(req.getParameter("id"));

        Worker worker = courierMapper.buildUser(req);
        worker.setId(id);

        service.update(worker);
        service.read();
        doGet(req, resp);
    }
}
