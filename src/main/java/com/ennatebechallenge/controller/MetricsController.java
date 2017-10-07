package com.ennatebechallenge.controller;

import com.ennatebechallenge.model.PersonWeight;
import com.ennatebechallenge.repository.impl.MetricsRepositoryImpl;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metrics")
public class MetricsController {
    private final Datastore datastore;

    @Autowired
    public MetricsController(Datastore datastore) {
        this.datastore = datastore;
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody PersonWeight personWeight){

        System.out.println(personWeight.getTimeStamp());
        System.out.println(personWeight.getWeight());
        MetricsRepositoryImpl metricsRepository = new MetricsRepositoryImpl(datastore);
        metricsRepository.create(personWeight);
    }


}
