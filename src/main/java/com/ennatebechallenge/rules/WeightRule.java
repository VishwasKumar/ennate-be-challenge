package com.ennatebechallenge.rules;

import com.ennatebechallenge.model.Alert;
import com.ennatebechallenge.model.PersonWeight;
import com.ennatebechallenge.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public abstract class WeightRule {
    PersonWeight personWeight;
    AlertService service;
    Alert alert;
    @Value("${rules.baseWeight}")
    int baseWeight;
    @Value("${rules.rulePercent}")
    private float rulePercent;
    int rule = (int)(baseWeight * (rulePercent/100.0f));

    @Autowired
    WeightRule(AlertService service){
        this.service = service;
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

    public void setBaseValuesForTest(int baseWeight, float rulePercent){
        this.baseWeight = baseWeight;
        this.rulePercent = rulePercent;
    }
}
