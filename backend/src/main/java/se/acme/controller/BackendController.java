package se.acme.controller;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.acme.transport.TagEntry;
import se.acme.util.CommonUtils;

import javax.inject.Inject;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class BackendController {

    public static final String SPACE_CHARACTER = " ";
    private Twitter twitter;

    private ConnectionRepository connectionRepository;

    @Inject
    public BackendController(Twitter twitter, ConnectionRepository connectionRepository) {
        this.twitter = twitter;
        this.connectionRepository = connectionRepository;
    }

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
        final SearchResults searchResult = readTwitterData(tag);

        return findTop100Words(searchResult);
    }

    @VisibleForTesting
    protected Collection<TagEntry> findTop100Words(SearchResults searchResult) {
        List<Tweet> tweets = searchResult.getTweets();
        Map<String, Long> wordDensity = Maps.newHashMap();

        for (Tweet tweet : tweets) {
            String tweetText = tweet.getText();
            Arrays.stream(tweetText.split(SPACE_CHARACTER)).forEach(str -> increaseDensity(wordDensity, str));
        }

        return wordDensity.entrySet().stream()
                .sorted((entry1, entry2) -> CommonUtils.compareLong(entry1, entry2))
                .map(entry -> new TagEntry(entry.getValue(), entry.getKey())) //The UI expects a ranking from 100 to 1
                                                                              // not the actual density value
                .limit(100L)
                .collect(Collectors.toList());
    }

    private SearchResults readTwitterData(@RequestParam(value = "tag", required = true, defaultValue = "tag") String tag) {
        Connection<Twitter> primaryConnection = connectionRepository.findPrimaryConnection(Twitter.class);


        // TODO: Handle big results
        return twitter.searchOperations().search(tag);
    }

    @VisibleForTesting
    protected void increaseDensity(Map<String, Long> wordDensity, String word) {
        Long density = wordDensity.get(word);
        if (density == null){
            wordDensity.put(word, 1L);
        }
        else {
            wordDensity.replace(word, ++density);
        }
    }

    @RequestMapping("rss")
    public Collection<TagEntry> rss(@RequestParam(value="feed", required=true, defaultValue="feed") String feed, Model model) {
//        model.addAttribute("feed", feed);
        return ImmutableList.of(new TagEntry(1, feed), new TagEntry(2, feed), new TagEntry(3, feed));
    }

    @RequestMapping("entry")
    public TagEntry entry() {
        return new TagEntry(3, "Test");
    }

    @RequestMapping("collection")
    public Collection<TagEntry> collection() {
        return ImmutableList.of(new TagEntry(1, "Test1"), new TagEntry(2, "Test2"));
    }

}
