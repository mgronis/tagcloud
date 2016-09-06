package se.acme.controller;

import com.google.common.collect.ImmutableList;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.acme.transport.TagEntry;

import java.util.Collection;

@RestController
@RequestMapping("/")
public class BackendController {

    @RequestMapping("static/tag")
    public Collection<TagEntry> staticTags() {
        return ImmutableList.of(new TagEntry(1, "Volvo"), new TagEntry(2, "Opel"), new TagEntry(3, "Saab"));
    }

    @RequestMapping("static/rss")
    public Collection<TagEntry> staticRss() {
        return ImmutableList.of(new TagEntry(1, "Bear"), new TagEntry(2, "Snake"), new TagEntry(3, "Moose"));
    }

    @RequestMapping("tag")
    public Collection<TagEntry> tags(@RequestParam(value="tag", required=true, defaultValue="tag") String tag, Model model) {
//        model.addAttribute("tag", tag);
        return ImmutableList.of(new TagEntry(1, tag), new TagEntry(2, tag), new TagEntry(3, tag));
    }

    @RequestMapping("rss")
    public Collection<TagEntry> rss(@RequestParam(value="feed", required=true, defaultValue="feed") String feed, Model model) {
//        model.addAttribute("feed", feed);
        return ImmutableList.of(new TagEntry(1, feed), new TagEntry(2, feed), new TagEntry(3, feed));
    }

}
