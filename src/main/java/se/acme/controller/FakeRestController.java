package se.acme.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.acme.transport.TestTO;

@RestController
@RequestMapping("/fake/")
public class FakeRestController {

    @RequestMapping("data/")
    public TestTO fakeData() {
        return new TestTO("Hello", "world");
    }
}
