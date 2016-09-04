package se.acme.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@RestController
@Controller
public class TagController {

//    @RequestMapping("/")
    @RequestMapping(value="/",method = RequestMethod.GET)
    public String index() {
        return "Greetings from Spring Boot!";
    }

}

