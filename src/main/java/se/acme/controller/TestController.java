package se.acme.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
public class TestController {

    @RequestMapping("/angular/")
    public String doTest() {
        return "../views/angular";
    }

}
