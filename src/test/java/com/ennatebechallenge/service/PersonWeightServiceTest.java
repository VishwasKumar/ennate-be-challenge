package com.ennatebechallenge.service;

import com.ennatebechallenge.model.PersonWeight;
import com.ennatebechallenge.rules.OverWeightRule;
import com.ennatebechallenge.rules.UnderWeightRule;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class PersonWeightServiceTest {
    @Mock
    private Datastore datastore;
    @Mock
    private UnderWeightRule underWeightRule;
    @Mock
    private OverWeightRule overWeightRule;

    @Autowired
    private PersonWeightService personWeightService;
    private PersonWeight personWeight;
    @Before
    public void setUp(){
        initMocks(this);
        personWeightService = new PersonWeightService(datastore, underWeightRule, overWeightRule);
        personWeight = new PersonWeight();
    }


    @Test
    public void saveWeightData() throws Exception {
        personWeight.setTimeStamp(1313045029);
        personWeight.setWeight(153);

        personWeightService.saveWeightAndAlert(personWeight);

        verify(datastore).save(personWeight);
    }

    @Test
    public void testUnderWeightRule(){
        personWeight.setTimeStamp(1313045029);
        personWeight.setWeight(130);

        personWeightService.saveWeightAndAlert(personWeight);

        verify(underWeightRule).checkUnderweight();
    }
}