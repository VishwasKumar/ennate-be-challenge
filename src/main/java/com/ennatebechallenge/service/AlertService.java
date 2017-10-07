package com.ennatebechallenge.service;

import com.ennatebechallenge.model.Alert;
import com.ennatebechallenge.repository.impl.AlertRepositoyImpl;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlertService {
    private final Datastore datastore;
    private final AlertRepositoyImpl alertRepositoy;

    @Autowired
    public AlertService(Datastore datastore, AlertRepositoyImpl alertRepositoy) {
        this.datastore = datastore;
        this.alertRepositoy = alertRepositoy;
    }

    public void commitAlert(Alert alert){
        alertRepositoy.create(alert);
    }
}
