package world.It.academy.utils;

import javax.servlet.http.HttpServletRequest;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Utility {
    public static LocalDate[] getWeek(LocalDate date) {
        LocalDate[] week = new LocalDate[2];

        week[0] = date.with(DayOfWeek.MONDAY);
        week[1] = date.with(DayOfWeek.SUNDAY);
        return week;
    }

    public static List<LocalDate> generateWeek(LocalDate startDate, LocalDate endDate) {
        List<LocalDate> weekList = new ArrayList<>();

        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(endDate)) {
            weekList.add(currentDate);
            currentDate = currentDate.plusDays(1);
        }

        return weekList;
    }

    public static LocalDate getLocalDate(HttpServletRequest req) {
        if (req.getParameter("calendar") == null) {return LocalDate.now().plusWeeks(1);}
        else {return LocalDate.parse(req.getParameter("calendar"));}
    }
}
