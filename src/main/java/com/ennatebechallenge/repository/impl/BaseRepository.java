package com.ennatebechallenge.repository.impl;

import com.ennatebechallenge.repository.CrudRepository;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

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
        return datastore.save(entity);
    }
}
