package com.ennatebechallenge.rules;

import com.ennatebechallenge.model.Alert;
import com.ennatebechallenge.service.AlertService;
import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Rule(name = "Over weight rule", description = "creates alert when over weight")
public class OverWeightRule extends WeightRule{
    @Autowired
    public OverWeightRule(AlertService service, Alert alert) {
        super(service, alert);
    }

    @Condition
    public boolean checkOverweight(){
        return (baseWeight + rule) <= personWeight.getWeight();
    }

    @Action
    public void isOverWeight(){
        alert.setTimeStamp(personWeight.getTimeStamp());
        alert.setAlert("over-weight");
        service.commitAlert(alert);
    }
}
