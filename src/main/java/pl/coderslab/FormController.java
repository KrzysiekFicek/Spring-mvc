package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/first") //- powoduje dodanie przed wszystkimi adresami "/form" dodatkowego adresu "/first" - "/first/form"
public class FormController {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @GetMapping("/anyForm")
    public String hello() {
        return "form";
    }

    @PostMapping("/anyForm")
    @ResponseBody
    public String taking(@RequestParam ("paramName") String paramName, @RequestParam ("paramDate") String paramDate){
        LocalDate formatDate = LocalDate.parse(paramDate, DATE_TIME_FORMATTER);
        return "ParamName:" + paramName + " ParamDate: " + formatDate;
    }

}