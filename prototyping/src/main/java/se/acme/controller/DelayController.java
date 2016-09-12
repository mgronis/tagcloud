package se.acme.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.acme.transport.TagEntry;

@RestController
@RequestMapping("/time")
public class DelayController {

    @RequestMapping("/delay")
    public TagEntry delay(@RequestParam(name = "millis", defaultValue = "10000") long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new TagEntry(1, "Done");
    }
}
