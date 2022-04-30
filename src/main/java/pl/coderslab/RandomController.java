package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class RandomController {

    @GetMapping("/show-random")
    @ResponseBody
    public String showRandom(){
        Random random = new Random();
        int rnd = random.nextInt(100);
        return "Wylosowano liczbę: " + rnd;
    }
}
