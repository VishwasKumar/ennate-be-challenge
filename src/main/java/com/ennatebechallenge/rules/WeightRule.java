package com.ennatebechallenge.rules;

import com.ennatebechallenge.model.Alert;
import com.ennatebechallenge.model.PersonWeight;
import com.ennatebechallenge.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class WeightRule {
    PersonWeight personWeight;
    AlertService service;
    Alert alert;
    int baseWeight = 150;
    private int rulePercent = 10;
    int rule = (int)(baseWeight * (rulePercent/100.0f));

    @Autowired
    WeightRule(AlertService service, Alert alert){
        this.service = service;
        this.alert = alert;
    }

    public void setPersonWeight(PersonWeight personWeight) {
        this.personWeight = personWeight;
    }

    public Alert getAlert() {
        return alert;
    }

    public void setAlert(Alert alert) {
        this.alert = alert;
    }
}
