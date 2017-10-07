package com.ennatebechallenge.repository;

import com.ennatebechallenge.model.Alert;
import com.ennatebechallenge.model.PersonWeight;

import java.io.Serializable;
import java.util.List;

public interface CrudRepository<T, ID extends Serializable> {
    public void create(T entiry);
    public List<PersonWeight> getAllMetrics();
    public List<Alert> getAllAlerts();
    public List<PersonWeight> getMetricsInRange(long start, long end);
    public List<Alert> getAlertInRange(long start, long end);
}
