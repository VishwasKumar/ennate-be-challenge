package com.ennatebechallenge.controller;

import com.ennatebechallenge.model.Alert;
import com.ennatebechallenge.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alert")
public class AlertsController {
    private final AlertService alertService;

    @Autowired
    public AlertsController(AlertService alertService) {
        this.alertService = alertService;
    }

    @RequestMapping(value = "/read")
    public @ResponseBody List<Alert> getAllWeights
            (@RequestParam(value = "start", required = false, defaultValue = "-1")long start,
            @RequestParam(value = "stop", required = false, defaultValue = "-1")long stop){
        return (start != -1 && stop != -1) ? alertService.getAltersInRange(start, stop) : alertService.getAllAlerts();
    }
}