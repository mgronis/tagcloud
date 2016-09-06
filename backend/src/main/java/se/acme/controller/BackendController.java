package se.acme.controller;

import com.google.common.collect.ImmutableList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.acme.transport.TagEntry;

import java.util.Collection;

@RestController
@RequestMapping("/")
public class BackendController {

    @RequestMapping("tag")
    public Collection<TagEntry> tag() {
        return ImmutableList.of(new TagEntry(1, "Volvo"), new TagEntry(2, "Opel"), new TagEntry(3, "Saab"));
    }

    @RequestMapping("rss")
    public Collection<TagEntry> rss() {
        return ImmutableList.of(new TagEntry(1, "Bear"), new TagEntry(2, "Snake"), new TagEntry(3, "Moose"));
    }

}
