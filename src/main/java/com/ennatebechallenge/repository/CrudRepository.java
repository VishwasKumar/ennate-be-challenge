package com.ennatebechallenge.repository;

import com.ennatebechallenge.model.Alert;
import com.ennatebechallenge.model.PersonWeight;
import org.mongodb.morphia.Key;

import java.io.Serializable;
import java.util.List;

public interface CrudRepository<T, ID extends Serializable> {
    Key<T> create(T entiry);
    List<PersonWeight> getAllMetrics();
    List<Alert> getAllAlerts();
    List<PersonWeight> getMetricsInRange(long start, long end);
    List<Alert> getAlertInRange(long start, long end);
}
