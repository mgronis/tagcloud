package se.acme.controller;

import com.google.common.collect.ImmutableList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.acme.transport.TagEntry;

import java.util.Collection;

@RestController
@RequestMapping("/fake/")
public class FakeRestController {

    @RequestMapping("data")
    public Collection<TagEntry> fakeData() {
        return ImmutableList.of(new TagEntry(1, "Volvo"), new TagEntry(2, "Opel"), new TagEntry(3, "Saab"));
    }

    @RequestMapping("data2")
    public TagEntry fakeData2() {
        return new TagEntry(3, "gurka");
    }

}
