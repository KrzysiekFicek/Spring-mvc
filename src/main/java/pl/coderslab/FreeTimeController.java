package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Controller
public class FreeTimeController {

    private static final LocalTime START_WORK = LocalTime.of(9,0);
    private static final LocalTime END_WORK = LocalTime.of(17,0);

    @GetMapping("/check-time")
    @ResponseBody
    public String checkTime(){
        LocalDateTime localDateTime = LocalDateTime.now();
        if(DayOfWeek.SATURDAY.equals(LocalDateTime.now().getDayOfWeek())
                || DayOfWeek.SUNDAY.equals(LocalDateTime.now().getDayOfWeek())){
            return "WOLNE";
        } else if (localDateTime.toLocalTime().isAfter(START_WORK)
                && localDateTime.toLocalTime().isBefore(END_WORK)){
            return "Pracuję, nie dzwoń";
        } else {
            return "Po pracy";
        }
    }
}
