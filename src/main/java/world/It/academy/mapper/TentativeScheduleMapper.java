package world.It.academy.mapper;

import world.It.academy.entities.TentativeSchedule;

import javax.servlet.http.HttpServletRequest;

import java.time.LocalDate;
import java.time.LocalTime;

import static world.It.academy.utils.Constants.*;

public class TentativeScheduleMapper {
    private static TentativeScheduleMapper tentativeScheduleMapper;
    public static TentativeScheduleMapper getInstance(){
        if(tentativeScheduleMapper == null){
            tentativeScheduleMapper = new TentativeScheduleMapper();
        }
        return tentativeScheduleMapper;
    }
    private TentativeScheduleMapper() {
    }
    public TentativeSchedule buildSchedule(HttpServletRequest request){
        return TentativeSchedule.builder()
                .dateWork(LocalDate.parse(request.getParameter(DATE_WORK)))
                .startTime(LocalTime.parse(request.getParameter(START_TIME)))
                .endTime(LocalTime.parse(request.getParameter(END_TIME)))
                .build();
    }
}
