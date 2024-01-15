package by.It.academy.controllers.admin;

import by.It.academy.entities.User;
import by.It.academy.mapper.UserMapper;
import by.It.academy.mapper.WorkerMapper;
import by.It.academy.services.user.UserService;
import by.It.academy.services.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.It.academy.utils.Constants.*;

@WebServlet(urlPatterns = "/create")
public class CreateWorkersController extends HttpServlet {
    private final UserService userService = UserServiceImpl.getInstance();
    private final WorkerMapper workerMapper = WorkerMapper.getInstance();
    private final UserMapper userMapper = UserMapper.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userMapper.buildWorker(req, workerMapper.buildWorker(req));
        userService.create(user);

        req.getRequestDispatcher(ADMIN_PAGE).forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(CREATE_WORKER_PAGE).forward(req, resp);
    }
}
