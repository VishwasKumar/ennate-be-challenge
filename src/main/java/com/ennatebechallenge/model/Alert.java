package com.ennatebechallenge.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;
import org.mongodb.morphia.utils.IndexDirection;

@Entity(value = "alert")
public class Alert {
    @Id
    private ObjectId id;
    private String alert;
    @Indexed(value = IndexDirection.ASC)
    private long timeStamp;
    @Embedded
    private PersonWeight personWeight;



    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public PersonWeight getPersonWeight() {
        return personWeight;
    }

    public void setPersonWeight(PersonWeight personWeight) {
        this.personWeight = personWeight;
    }
}
