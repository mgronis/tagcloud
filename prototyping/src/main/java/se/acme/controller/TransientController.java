package se.acme.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import se.acme.transport.TagEntry;

import java.util.Collection;

@RequestMapping("/transient")
@RestController
public class TransientController {

    @RequestMapping("entry")
    public TagEntry entry() {
        RestTemplate restTemplate =  new RestTemplate();
        TagEntry result = restTemplate.getForObject("http://localhost:8081/entry", TagEntry.class);

        System.out.println(result);

        return result;
    }

    @RequestMapping("collection")
    public Collection<TagEntry> collection() {
        RestTemplate restTemplate =  new RestTemplate();
        Collection<TagEntry> result = restTemplate.getForObject("http://localhost:8081/collection", Collection.class);

        System.out.println(result);

        return result;
    }

}
