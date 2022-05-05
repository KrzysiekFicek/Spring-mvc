package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

@Controller
public class HelloController {

//    @RequestMapping(value = "/hello", method = RequestMethod.GET) - wersja alternatywna
    @GetMapping(value = "/hello/{firstName}/{lastName}", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String helloWorld(@PathVariable String firstName, @PathVariable String lastName) {
        return "Witaj " + firstName + " " + lastName;
    }
    @GetMapping(value = "/helloView")
    public String helloView(Model model){
        LocalTime actualTime = LocalTime.of(4,56);
        if(actualTime.isAfter(LocalTime.of(8,0)) && actualTime.isBefore(LocalTime.of(20,0))){
        // pomiędzy 8 a 20
            model.addAttribute("color", "black");
            model.addAttribute("backgroundColor", "white");
        } else {
            // noc
            model.addAttribute("color", "white");
            model.addAttribute("backgroundColor", "black");
        }
        return "home";
    }


}
