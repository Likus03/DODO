package world.It.academy.controllers.schedules;

import world.It.academy.entities.WorkSchedule;
import world.It.academy.services.schedule.ScheduleService;
import world.It.academy.services.schedule.ScheduleServiceImpl;
import world.It.academy.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static world.It.academy.utils.Utility.getLocalDate;

@WebServlet(urlPatterns = "/readSchedule")
public class ReadScheduleController extends HttpServlet {
    private static final ScheduleService scheduleService = ScheduleServiceImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDate parse = getLocalDate(req);

        List<WorkSchedule> schedules = scheduleService
                .readScheduleByIdWorker((Long)req.getSession().getAttribute("worker_id"), parse);

        req.setAttribute("schedules", schedules);
        req.getRequestDispatcher(Constants.READ_SCHEDULE_WORKER).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
