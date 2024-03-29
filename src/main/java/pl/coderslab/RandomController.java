package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class RandomController {

    private final  Random random = new Random();

    @GetMapping(value = "/random/{min}/{max}", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String showRandomWithMax(@PathVariable int max, @PathVariable int min) {
        int randomNumber = random.nextInt(max - min + 1) + min;
        return "Użytkownik podał wartość: " + min + " i  " + max + ". Wylosowano liczbę: " + randomNumber;
    }

/* przekazywanie parametrów: ex 1
    @GetMapping(value = "/random/{max}", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String showRandomWithMax(@PathVariable int max){
        int randomNumber = random.nextInt(max) + 1;
        return "Użytkownik podał wartość max: " + max + ". Wylosowano liczbę: " + randomNumber;
    }
*/
    @GetMapping("/show-random")
    @ResponseBody
    public String showRandom(){

        int rnd = random.nextInt(100);
        return "Wylosowano liczbę: " + rnd;
    }
}
