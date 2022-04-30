package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

//    @RequestMapping(value = "/hello", method = RequestMethod.GET) - wersja alternatywna
    @GetMapping("/hello")
    @ResponseBody
    public String helloWorld(){
        return "Hello World";
    }

}
