package com.ennatebechallenge.repository.impl;

import com.ennatebechallenge.model.Alert;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AlertRepositoyImpl extends BaseRepository<Alert, ObjectId>{

    @Autowired
    public AlertRepositoyImpl(Datastore datastore) {
        super(datastore, Alert.class);
    }
}
