package com.ennatebechallenge.service;

import com.ennatebechallenge.model.Alert;
import com.ennatebechallenge.repository.impl.AlertRepositoyImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mongodb.morphia.Datastore;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class AlertServiceTest {
    @Mock
    private Datastore datastore;
    @Mock
    private AlertRepositoyImpl alertRepositoy;

    private Alert alert;
    @Before
    public void setUp() {
        initMocks(this);
        alert = new Alert();
    }


        @Test
    public void testCommitAlert() throws Exception {
        AlertService alertService = new AlertService(datastore);

        alert.setTimeStamp(123345);
        alert.setAlert("under-weight");
        alertService.commitAlert(alert);
        verify(datastore).save(alert);
    }

}