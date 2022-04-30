package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class FormController {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @GetMapping("/form")
    public String hello() {
        return "form.jsp";
    }

    @PostMapping("/form")
    @ResponseBody
    public String taking(@RequestParam ("paramName") String paramName, @RequestParam ("paramDate") String paramDate){
        LocalDate formatDate = LocalDate.parse(paramDate, DATE_TIME_FORMATTER);
        return "ParamName:" + paramName + " ParamDate: " + formatDate;
    }

}
