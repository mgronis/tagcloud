package se.acme.controller;

import com.rometools.rome.feed.synd.SyndContent;
import com.rometools.rome.feed.synd.SyndEntry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.acme.reader.RssReader;

import java.util.Collection;
import java.util.List;

@RestController
public class RssController {

    @RequestMapping("/rss1")
    public String read1() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "rss-inbound.xml");

        // create a pollable channel
        PollableChannel feedChannel = context.getBean("feedChannel", PollableChannel.class);

        Message<SyndEntry> message;
        do {
            message = (Message<SyndEntry>) feedChannel.receive(1000);
            if (message != null) {
                SyndEntry entry = message.getPayload();

                SyndContent contents = entry.getDescription();

//                for (SyndContent content : contents) {
//                    String value = content.getValue();
//                }
            }

        } while (message != null);

        return null;
    }

    @RequestMapping("/rss2")
    public Collection<String> read2() {

        RssReader rssReader = new RssReader("http://www.agical.se/pod/vag74.xml");

        return rssReader.readFeed();
    }
}
