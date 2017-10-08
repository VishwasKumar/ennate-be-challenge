package com.ennatebechallenge.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;
import org.mongodb.morphia.utils.IndexDirection;

@Entity(value = "alert")
public class Alert {
    @Id
    private ObjectId id;

    private String alert;

    @Embedded
    @Indexed(value = IndexDirection.ASC)
    private PersonWeight personWeight;



    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
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
