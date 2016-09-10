package se.acme.controller;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import se.acme.transport.TagEntry;
import se.acme.util.CommonUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BackendControllerTest {

    @Test
    public void simpleTweet() {
        SearchResults result = mock(SearchResults.class);

        Tweet tweet1 = mock(Tweet.class);
        when(tweet1.getText()).thenReturn("Some");


        when(result.getTweets()).thenReturn(ImmutableList.of(tweet1));

        Collection<TagEntry> tagEntries = new BackendController(null, null).findTop100Words(result);
        assertThat(tagEntries, notNullValue());
        assertThat(tagEntries, Matchers.contains(new TagEntry(1, "Some")));
    }

    @Test
    public void multiplTweets() {
        SearchResults result = mock(SearchResults.class);

        Tweet tweet1 = mock(Tweet.class);
        when(tweet1.getText()).thenReturn("Some fancy text that is good for creating clouds with text");

        Tweet tweet2 = mock(Tweet.class);
        when(tweet2.getText()).thenReturn("Appels and oranges are great for you");

        when(result.getTweets()).thenReturn(ImmutableList.of(tweet1, tweet2));

        Collection<TagEntry> tagEntries = new BackendController(null, null).findTop100Words(result);
        assertThat(tagEntries, notNullValue());
        assertThat(tagEntries, containsExpectedWords());
    }

    private Matcher<Iterable<? extends TagEntry>> containsExpectedWords() {
        return containsInAnyOrder(
                new TagEntry(1L, "Appels"),
                new TagEntry(1L, "and"),
                new TagEntry(1L, "oranges"),
                new TagEntry(1L, "are"),
                new TagEntry(1L, "great"),
                new TagEntry(2L, "for"),
                new TagEntry(1L, "you"),
                new TagEntry(1L, "Some"),
                new TagEntry(1L, "fancy"),
                new TagEntry(2L, "text"),
                new TagEntry(1L, "that"),
                new TagEntry(1L, "is"),
                new TagEntry(1L, "good"),
                new TagEntry(1L, "creating"),
                new TagEntry(1L, "clouds"),
                new TagEntry(1L, "with")
        );
    }

}