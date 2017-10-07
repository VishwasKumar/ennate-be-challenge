package com.ennatebechallenge.service;

import com.ennatebechallenge.model.PersonWeight;
import com.ennatebechallenge.repository.impl.MetricsRepositoryImpl;
import com.ennatebechallenge.rules.OverWeightRule;
import com.ennatebechallenge.rules.UnderWeightRule;
import org.easyrules.api.RulesEngine;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.easyrules.core.RulesEngineBuilder.aNewRulesEngine;

@Service
public class PersonWeightService {
    private Datastore datastore;
    private UnderWeightRule underWeightRule;
    private OverWeightRule overWeightRule;
    private RulesEngine rulesEngine;
    private MetricsRepositoryImpl metricsRepository;

    @Autowired
    public PersonWeightService(Datastore datastore, UnderWeightRule underWeightRule, OverWeightRule overWeightRule) {
        this.datastore = datastore;
        this.underWeightRule = underWeightRule;
        this.overWeightRule = overWeightRule;
        rulesEngine = aNewRulesEngine().build();
        metricsRepository = new MetricsRepositoryImpl(datastore);
    }

    public void saveWeightAndAlert(PersonWeight personWeight) throws InterruptedException {
        Thread alertSaver = new Thread(() -> saveAlert(personWeight));
        Thread metricsSaver = new Thread(() -> commitPersonWeight(personWeight));
        alertSaver.start();
        metricsSaver.start();

        try {
            alertSaver.join();
            metricsSaver.join();
        } catch (InterruptedException e) {
            System.out.println("Please do not interrupt which data is being stored");
            throw new InterruptedException();
        }
    }

    private void commitPersonWeight(PersonWeight personWeight) {
        metricsRepository.create(personWeight);
    }

    private void saveAlert(PersonWeight personWeight){
        underWeightRule.setPersonWeight(personWeight);
        overWeightRule.setPersonWeight(personWeight);
        rulesEngine.registerRule(underWeightRule);
        rulesEngine.registerRule(overWeightRule);
        rulesEngine.fireRules();
    }

    public List<PersonWeight> getAllWeights() {
        return metricsRepository.getAllMetrics();
    }

    public List<PersonWeight> getWeightsInRange(long start, long end) {
        return metricsRepository.getMetricsInRange(start, end);
    }
}
