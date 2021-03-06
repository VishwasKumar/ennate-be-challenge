package com.ennatebechallenge.rules;

import com.ennatebechallenge.model.Alert;
import com.ennatebechallenge.service.AlertService;
import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Rule(name = "Under weight rule", description = "creates alert when under weight")
public class UnderWeightRule extends WeightRule{
    @Autowired
    public UnderWeightRule(AlertService service) {
        super(service);
    }

    @Condition
    public boolean checkUnderweight(){
        return personWeight.getWeight() <= (baseWeight - rule);
    }

    @Action
    public void isUnderWeight(){
        alert = new Alert();
        alert.setAlert("under-weight");
        alert.setPersonWeight(personWeight);
        service.commitAlert(alert);
    }
}
