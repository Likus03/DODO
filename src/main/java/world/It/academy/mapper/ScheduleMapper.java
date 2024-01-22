package world.It.academy.mapper;

import world.It.academy.entities.WorkSchedule;
import world.It.academy.entities.Worker;

import static world.It.academy.utils.Constants.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.sql.Time;

public class ScheduleMapper {
    private static ScheduleMapper scheduleMapper;
    public static ScheduleMapper getInstance(){
        if(scheduleMapper == null){
            scheduleMapper = new ScheduleMapper();
        }
        return scheduleMapper;
    }

    private ScheduleMapper() {
    }
    public WorkSchedule buildSchedule(HttpServletRequest request, Worker worker){
        return WorkSchedule.builder()
                .dateWork(LocalDate.parse(request.getParameter(DATE_WORK)))
                .startTime(Time.valueOf(request.getParameter(START_TIME)))
                .endTime(Time.valueOf(request.getParameter(END_TIME)))
                .worker(worker)
                .build();
    }
}
