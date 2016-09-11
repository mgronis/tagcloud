package se.acme.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import se.acme.transport.TagEntry;

import java.util.Collection;

@RestController
@RequestMapping("/import")
public class ImportController {

    @RequestMapping("/tag")
    public Collection<TagEntry> importhashtags(){
        RestTemplate restTemplate =  new RestTemplate();
        Collection<TagEntry> result = restTemplate.getForObject("http://localhost:8081/static/tag", Collection.class);

        return result;
    }
}
