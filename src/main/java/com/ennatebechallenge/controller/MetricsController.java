package com.ennatebechallenge.controller;

import com.ennatebechallenge.model.PersonWeight;
import com.ennatebechallenge.service.PersonWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metrics")
public class MetricsController {
    private PersonWeightService personWeightService;

    @Autowired
    public MetricsController(PersonWeightService personWeightService) {
        this.personWeightService = personWeightService;
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody PersonWeight personWeight) throws InterruptedException {
        personWeightService.saveWeightAndAlert(personWeight);
    }

    @RequestMapping(value = "/read")
    public @ResponseBody List<PersonWeight> getAllWeights
            (@RequestParam(value = "start", required = false, defaultValue = "-1")long start,
             @RequestParam(value = "stop", required = false, defaultValue = "-1")long stop){
        return (start != -1 && stop != -1) ? personWeightService.getWeightsInRange(start, stop)
                : personWeightService.getAllWeights();
    }

}
