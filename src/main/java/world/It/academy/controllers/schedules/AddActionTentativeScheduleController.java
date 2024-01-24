package world.It.academy.controllers.schedules;

import world.It.academy.services.tentativeSchedule.TentativeScheduleService;
import world.It.academy.services.tentativeSchedule.TentativeScheduleServiceImpl;
import static world.It.academy.utils.Utility.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@WebServlet(urlPatterns = "/addActionTentativeSchedule")
public class AddActionTentativeScheduleController extends HttpServlet {
    private static final TentativeScheduleService tentativeScheduleService = TentativeScheduleServiceImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDate parse = getLocalDate(req);
        LocalDate[] week = getWeek(parse);
        List<LocalDate> weekList = generateWeek(week[0], week[1]);

        req.setAttribute("weekList", weekList);
        req.getRequestDispatcher("/pages/schedules/addActionTentativeScheduleWorker.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("dateWork")!= null) {
            tentativeScheduleService.addTentativeSchedule((Long) req.getSession().getAttribute("worker_id"), LocalDate.parse(req.getParameter("dateWork")), LocalTime.parse(req.getParameter("startTime")), LocalTime.parse(req.getParameter("endTime")));
        }
        doGet(req, resp);
    }
}
