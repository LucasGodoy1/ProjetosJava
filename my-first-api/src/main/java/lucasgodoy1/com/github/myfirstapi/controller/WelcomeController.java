package lucasgodoy1.com.github.myfirstapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/inicio")
    public String bemVindo(){
        return "Bem - Vindoo !!";
    }

}
