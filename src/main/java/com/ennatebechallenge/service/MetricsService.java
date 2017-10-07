package com.ennatebechallenge.service;

import com.ennatebechallenge.model.PersonWeight;
import com.ennatebechallenge.repository.impl.MetricsRepositoryImpl;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetricsService {
    private final Datastore datastore;

    @Autowired
    public MetricsService(Datastore datastore) {
        this.datastore = datastore;
    }

    public void saveWeightData(PersonWeight personWeight){
        MetricsRepositoryImpl metricsRepository = new MetricsRepositoryImpl(datastore);
        metricsRepository.create(personWeight);
    }
}
