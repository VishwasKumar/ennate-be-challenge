package ennatebechallenge.controller;

import ennatebechallenge.model.PersonWeight;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metrics")
public class MetricsController {
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody PersonWeight personWeight){
        System.out.println(personWeight.getTimeStamp());
        System.out.println(personWeight.getWeight());
    }


}
