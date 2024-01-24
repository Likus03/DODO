package world.It.academy.controllers.schedules;

import world.It.academy.entities.TentativeSchedule;
import world.It.academy.services.tentativeSchedule.TentativeScheduleService;
import world.It.academy.services.tentativeSchedule.TentativeScheduleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static world.It.academy.utils.Utility.getLocalDate;

@WebServlet(urlPatterns = "/readTentativeSchedule")
public class ReadTentativeScheduleController extends HttpServlet {
    private static final TentativeScheduleService tentativeScheduleService = TentativeScheduleServiceImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDate parse = getLocalDate(req);
        List<TentativeSchedule> tentativeSchedules = tentativeScheduleService
                        .readTentativeScheduleById((Long) req.getSession().getAttribute("worker_id"), parse);

        req.setAttribute("tentativeSchedules", tentativeSchedules);
        req.getRequestDispatcher("/pages/schedules/readTentativeSchedule.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
