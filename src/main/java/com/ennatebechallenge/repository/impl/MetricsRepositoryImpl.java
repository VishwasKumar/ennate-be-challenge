package com.ennatebechallenge.repository.impl;

import com.ennatebechallenge.model.PersonWeight;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MetricsRepositoryImpl extends BaseRepository<PersonWeight, ObjectId> {

    @Autowired
    public MetricsRepositoryImpl(Datastore datastore){
        super(datastore, PersonWeight.class);
    }
}
