package com.ennatebechallenge.service;

import com.ennatebechallenge.model.Alert;
import com.ennatebechallenge.model.PersonWeight;
import com.ennatebechallenge.rules.OverWeightRule;
import com.ennatebechallenge.rules.UnderWeightRule;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class PersonWeightServiceTest {
    @Mock
    private Datastore datastore;
    private UnderWeightRule underWeightRule;
    @Mock
    private OverWeightRule overWeightRule;

    @Autowired
    private PersonWeightService personWeightService;
    @Mock
    private AlertService alertService;
    private PersonWeight personWeight;

    private Alert alert = new Alert();


    @Before
    public void setUp(){
        initMocks(this);
        underWeightRule = new UnderWeightRule(alertService, alert);
        overWeightRule = new OverWeightRule(alertService, alert);
        personWeightService = new PersonWeightService(datastore, underWeightRule, overWeightRule);
        personWeight = new PersonWeight();
        alert = new Alert();

        personWeight.setTimeStamp(1313045029);
        personWeight.setWeight(130);
    }


    @Test
    public void saveWeightData() throws Exception {
        personWeightService.saveWeightAndAlert(personWeight);

        verify(datastore).save(personWeight);
    }

    @Test
    public void testUnderWeightRule(){
        personWeightService.saveWeightAndAlert(personWeight);

        assertThat(underWeightRule.getAlert().getAlert(), is("under-weight"));
        assertThat(underWeightRule.getAlert().getTimeStamp(), is(personWeight.getTimeStamp()));
        verify(alertService).commitAlert(underWeightRule.getAlert());
    }

    @Test
    public void testOverWeightRule(){
        personWeight.setWeight(200);
        personWeightService.saveWeightAndAlert(personWeight);

        assertThat(overWeightRule.getAlert().getAlert(), is("over-weight"));
        assertThat(overWeightRule.getAlert().getTimeStamp(), is(personWeight.getTimeStamp()));
        verify(alertService).commitAlert(overWeightRule.getAlert());
    }
}