package com.ennatebechallenge.rules;

import com.ennatebechallenge.model.PersonWeight;
import org.springframework.stereotype.Component;

@Component
public abstract class WeightRule {
    PersonWeight personWeight;
    int baseWeight = 150;
    int rulePercent = 10;
    int rule = (int)(baseWeight * (rulePercent/100.0f));

    public void setPersonWeight(PersonWeight personWeight) {
        this.personWeight = personWeight;
    }
}
