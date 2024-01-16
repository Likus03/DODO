package world.It.academy.controllers.admin;

import world.It.academy.entities.User;
import world.It.academy.mapper.UserMapper;
import world.It.academy.mapper.WorkerMapper;
import world.It.academy.services.user.UserService;
import world.It.academy.services.user.UserServiceImpl;
import world.It.academy.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/create")
public class CreateWorkersController extends HttpServlet {
    private final UserService userService = UserServiceImpl.getInstance();
    private final WorkerMapper workerMapper = WorkerMapper.getInstance();
    private final UserMapper userMapper = UserMapper.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userMapper.buildWorker(req, workerMapper.buildWorker(req));
        userService.create(user);

        req.getRequestDispatcher(Constants.ADMIN_PAGE).forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(Constants.CREATE_WORKER_PAGE).forward(req, resp);
    }
}
