package com.ennatebechallenge.rules;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import org.springframework.stereotype.Component;

@Component
@Rule(name = "Under weight rule", description = "creates alert when under weight")
public class UnderWeightRule extends WeightRule{
    @Condition
    public boolean checkUnderweight(){
        return (baseWeight - personWeight.getWeight()) > rule;
    }

    @Action
    public void isUnderWeight(){
        System.out.println("is under");
    }
}
