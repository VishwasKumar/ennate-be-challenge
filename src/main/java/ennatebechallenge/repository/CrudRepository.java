package ennatebechallenge.repository;

import org.mongodb.morphia.Key;

import java.io.Serializable;

public interface CrudRepository<T, ID extends Serializable> {
    public Key<T> create(T entiry);
}
