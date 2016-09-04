package se.acme.controller;

import com.google.common.collect.ImmutableList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.acme.transport.TagEntry;
import se.acme.transport.TestTO;

@RestController
@RequestMapping("/fake/")
public class FakeRestController {

    @RequestMapping("data/")
    public TestTO fakeData() {
        return new TestTO(ImmutableList.of(new TagEntry(1, "Volvo"), new TagEntry(2, "Opel"), new TagEntry(3, "Saab")));
    }

}
