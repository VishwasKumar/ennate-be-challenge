package com.ennatebechallenge.controller;

import com.ennatebechallenge.model.PersonWeight;
import com.ennatebechallenge.service.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metrics")
public class MetricsController {
    private final MetricsService metricsService;

    @Autowired
    public MetricsController(MetricsService metricsService) {
        this.metricsService = metricsService;
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody PersonWeight personWeight){
        metricsService.saveWeightData(personWeight);
    }


}
