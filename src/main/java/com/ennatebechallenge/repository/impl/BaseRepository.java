package com.ennatebechallenge.repository.impl;

import com.ennatebechallenge.model.Alert;
import com.ennatebechallenge.model.PersonWeight;
import com.ennatebechallenge.repository.CrudRepository;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class BaseRepository<T, ID extends Serializable> implements CrudRepository<T, ID> {
    private final Datastore datastore;
    private Class<T> t;

    @Autowired
    public BaseRepository(Datastore datastore, Class<T> t) {
        this.datastore = datastore;
        this.t = t;
    }

    @Override
    public Key<T> create(T entity) {
        System.out.println("writing alert");
        return datastore.save(entity);
    }

    @Override
    public List<PersonWeight> getAllMetrics() {
        final Query<PersonWeight> query = datastore.createQuery(PersonWeight.class);
        return query.asList();
    }

    @Override
    public List<Alert> getAllAlerts() {
        final Query<Alert> query = datastore.createQuery(Alert.class);
        return query.asList();
    }

    @Override
    public List<PersonWeight> getMetricsInRange(long start, long end) {
        return datastore.createQuery(PersonWeight.class)
                .filter("timeStamp >=", start)
                .filter("timeStamp <=", end)
                .asList();
    }

    @Override
    public List<Alert> getAlertInRange(long start, long end) {
        return datastore.createQuery(Alert.class)
                .filter("timeStamp >=", start)
                .filter("timeStamp <=", end)
                .asList();
    }
}
