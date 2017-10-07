package ennatebechallenge.repository;

import ennatebechallenge.model.PersonWeight;
import org.bson.types.ObjectId;

public interface MetricsRepository extends CrudRepository<PersonWeight, ObjectId>{

}
