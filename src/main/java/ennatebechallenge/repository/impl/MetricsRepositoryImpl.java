package ennatebechallenge.repository.impl;

import ennatebechallenge.model.PersonWeight;
import ennatebechallenge.repository.MetricsRepository;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.springframework.beans.factory.annotation.Autowired;

public class MetricsRepositoryImpl implements MetricsRepository {
    private final Datastore datastore;

    @Autowired
    public MetricsRepositoryImpl(Datastore datastore) {
        this.datastore = datastore;
    }

    public Key<PersonWeight> create(PersonWeight personWeight) {
        return datastore.save(personWeight);
    }
}
