package com.ennatebechallenge.service;

import com.ennatebechallenge.model.Alert;
import com.ennatebechallenge.repository.impl.AlertRepositoyImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class AlertServiceTest {
    @Mock
    private Datastore datastore;
    @Mock
    private Query<Alert> query;
    @Mock
    private AlertRepositoyImpl alertRepositoy;
    private AlertService alertService;
    private Alert alert;
    @Before
    public void setUp() {
        initMocks(this);
        alert = new Alert();
        alertService = new AlertService(datastore);
    }


    @Test
    public void testCommitAlert() throws Exception {
        alert.setTimeStamp(123345);
        alert.setAlert("under-weight");
        alertService.commitAlert(alert);
        verify(datastore).save(alert);
    }

    @Test
    public void testGetAllAlters(){
        when(datastore.createQuery(Alert.class)).thenReturn(query);
        alertService.getAllAlerts();

        verify(datastore).createQuery(Alert.class);
    }

}