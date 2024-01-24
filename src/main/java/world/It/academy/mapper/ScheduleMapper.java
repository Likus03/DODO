package world.It.academy.mapper;

import world.It.academy.entities.WorkSchedule;

import static world.It.academy.utils.Constants.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalTime;

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
    public WorkSchedule buildSchedule(HttpServletRequest request){
        return WorkSchedule.builder()
                .dateWork(LocalDate.parse(request.getParameter(DATE_WORK)))
                .startTime(LocalTime.parse(request.getParameter(START_TIME)))
                .endTime(LocalTime.parse(request.getParameter(END_TIME)))
                .build();
    }
}
