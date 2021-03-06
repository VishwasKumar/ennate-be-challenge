package com.ennatebechallenge.service;

import com.ennatebechallenge.model.Alert;
import com.ennatebechallenge.model.PersonWeight;
import com.ennatebechallenge.rules.OverWeightRule;
import com.ennatebechallenge.rules.UnderWeightRule;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@EnableAutoConfiguration
public class PersonWeightServiceTest {
    @Mock
    private Datastore datastore;
    @Mock
    private UnderWeightRule underWeightRule;
    @Mock
    private OverWeightRule overWeightRule;
    @Mock
    private AlertService alertService;
    @Mock
    private Query<PersonWeight> query;

    private PersonWeightService personWeightService;
    private PersonWeight personWeight;
    private Alert alert = new Alert();


        @Before
        public void setUp(){
        initMocks(this);
        underWeightRule = new UnderWeightRule(alertService);
        overWeightRule = new OverWeightRule(alertService);
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
    public void testUnderWeightRule() throws InterruptedException {
        underWeightRule.setBaseValuesForTest(150, 10);
        personWeightService.saveWeightAndAlert(personWeight);

        assertThat(underWeightRule.getAlert().getAlert(), is("under-weight"));
        assertThat(underWeightRule.getAlert().getPersonWeight(), is(personWeight));
        verify(alertService).commitAlert(underWeightRule.getAlert());
    }

    @Test
    public void testOverWeightRule() throws InterruptedException {
        personWeight.setWeight(200);
        overWeightRule.setBaseValuesForTest(150, 10);
        personWeightService.saveWeightAndAlert(personWeight);

        assertThat(overWeightRule.getAlert().getAlert(), is("over-weight"));
        assertThat(overWeightRule.getAlert().getPersonWeight(), is(personWeight));
        verify(alertService).commitAlert(overWeightRule.getAlert());
    }

    @Test
    public void testGetAllMetrics(){
        when(datastore.createQuery(PersonWeight.class)).thenReturn(query);
        personWeightService.getAllWeights();

        verify(datastore).createQuery(PersonWeight.class);
    }
}