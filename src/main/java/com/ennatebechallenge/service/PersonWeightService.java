package com.ennatebechallenge.service;

import com.ennatebechallenge.model.PersonWeight;
import com.ennatebechallenge.repository.impl.MetricsRepositoryImpl;
import com.ennatebechallenge.rules.OverWeightRule;
import com.ennatebechallenge.rules.UnderWeightRule;
import org.easyrules.api.RulesEngine;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.easyrules.core.RulesEngineBuilder.aNewRulesEngine;

@Service
public class PersonWeightService {
    private Datastore datastore;
    private UnderWeightRule underWeightRule;
    private OverWeightRule overWeightRule;
    private RulesEngine rulesEngine;

    @Autowired
    public PersonWeightService(Datastore datastore, UnderWeightRule underWeightRule, OverWeightRule overWeightRule) {
        this.datastore = datastore;
        this.underWeightRule = underWeightRule;
        this.overWeightRule = overWeightRule;
        rulesEngine = aNewRulesEngine().build();
    }

    public void saveWeightAndAlert(PersonWeight personWeight){
        saveAlert(personWeight);
        MetricsRepositoryImpl metricsRepository = new MetricsRepositoryImpl(datastore);
        metricsRepository.create(personWeight);
    }

    private void saveAlert(PersonWeight personWeight){
        underWeightRule.setPersonWeight(personWeight);
        overWeightRule.setPersonWeight(personWeight);
        rulesEngine.registerRule(underWeightRule);
        rulesEngine.registerRule(overWeightRule);
        rulesEngine.fireRules();
    }
}
