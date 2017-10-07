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
    public void create(@RequestBody PersonWeight personWeight){
        personWeightService.saveWeightAndAlert(personWeight);
    }

    @RequestMapping(value = "/read")
    public @ResponseBody
    List<PersonWeight> getAllWeights(){
        personWeightService.getWeightsInRange(1313045029, 1313045030);
        return personWeightService.getAllWeights();
    }

}
