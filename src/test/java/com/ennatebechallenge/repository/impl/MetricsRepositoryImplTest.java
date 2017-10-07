package com.ennatebechallenge.repository.impl;

import com.ennatebechallenge.model.PersonWeight;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class MetricsRepositoryImplTest {
    @Mock
    private Datastore datastore;
    @Autowired
    private MetricsRepositoryImpl metricsRepository;

    @Before
    public void setUp(){
        initMocks(this);
        metricsRepository = new MetricsRepositoryImpl(datastore);
    }


    @Test
    public void create() throws Exception {
        PersonWeight personWeight = new PersonWeight();
        personWeight.setTimeStamp(1313045029);
        personWeight.setWeight(153);

        metricsRepository.create(personWeight);

        verify(datastore).save(personWeight);
    }

}