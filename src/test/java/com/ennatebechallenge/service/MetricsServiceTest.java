package com.ennatebechallenge.service;

import com.ennatebechallenge.model.PersonWeight;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class MetricsServiceTest {
    @Mock
    private Datastore datastore;
    @Autowired
    private MetricsService metricsService;

    @Before
    public void setUp(){
        initMocks(this);
        metricsService = new MetricsService(datastore);
    }


    @Test
    public void saveWeightData() throws Exception {
        PersonWeight personWeight = new PersonWeight();
        personWeight.setTimeStamp(1313045029);
        personWeight.setWeight(153);

        metricsService.saveWeightData(personWeight);

        verify(datastore).save(personWeight);
    }
}