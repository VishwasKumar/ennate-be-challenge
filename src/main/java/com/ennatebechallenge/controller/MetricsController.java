package com.ennatebechallenge.controller;

import com.ennatebechallenge.model.PersonWeight;
import com.ennatebechallenge.service.PersonWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metrics")
public class MetricsController {
    private final PersonWeightService personWeightService;

    @Autowired
    public MetricsController(PersonWeightService personWeightService) {
        this.personWeightService = personWeightService;
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody PersonWeight personWeight){
        personWeightService.saveWeightAndAlert(personWeight);
    }


}
