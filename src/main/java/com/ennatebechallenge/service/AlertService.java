package com.ennatebechallenge.service;

import com.ennatebechallenge.model.Alert;
import com.ennatebechallenge.repository.impl.AlertRepositoyImpl;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertService {
    private final Datastore datastore;
    private AlertRepositoyImpl alertRepositoy;

    @Autowired
    public AlertService(Datastore datastore) {
        this.datastore = datastore;
        alertRepositoy = new AlertRepositoyImpl(datastore);
    }

    public void commitAlert(Alert alert){
        alertRepositoy.create(alert);
    }

    public List<Alert> getAllAlerts() {
        return alertRepositoy.getAllAlerts();
    }

    public List<Alert> getAltersInRange(long start, long end) {
        return alertRepositoy.getAlertInRange(start, end);
    }
}
