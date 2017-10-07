package com.ennatebechallenge.rules;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import org.springframework.stereotype.Component;

@Component
@Rule(name = "Over weight rule", description = "creates alert when over weight")
public class OverWeightRule extends WeightRule{
    @Condition
    public boolean checkOverweight(){
        return (baseWeight + rule) <= personWeight.getWeight();
    }

    @Action
    public void isOverWeight(){
        System.out.println("is over");
    }
}
