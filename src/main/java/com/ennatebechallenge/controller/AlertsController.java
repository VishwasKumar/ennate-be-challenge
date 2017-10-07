package com.ennatebechallenge.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlertsController {
    @RequestMapping("/alert")
    public String alert(){
        return "Get Request test";
    }
}