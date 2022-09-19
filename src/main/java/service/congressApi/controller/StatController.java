package service.congressApi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatController {

    @GetMapping("/")
    public String main(){
        return "index";
    }


}
