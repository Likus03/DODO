package world.It.academy.filters;

import world.It.academy.services.tentativeSchedule.TentativeScheduleService;
import world.It.academy.services.tentativeSchedule.TentativeScheduleServiceImpl;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebFilter(urlPatterns = "/readTentativeSchedule")
public class ScheduleFilter extends HttpFilter {
    private static final TentativeScheduleService tentativeScheduleService = TentativeScheduleServiceImpl.getInstance();
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        LocalDate now = LocalDate.now();
        Long workerId = (Long) req.getSession().getAttribute("worker_id");
        LocalDate maxDate = tentativeScheduleService.getMaxDate(workerId);

        if(maxDate.isBefore(now.plusWeeks(1))){
            tentativeScheduleService.AddEmptySchedule(workerId, now.plusWeeks(1));
        }
        chain.doFilter(req, res);

    }

    @Override
    public void destroy() {

    }
}
