package com.ennatebechallenge.model;

import org.bson.types.ObjectId;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class PersonWeightTest {
    private PersonWeight personWeight = new PersonWeight();

    @Test
    public void testTimeStamp() throws Exception {
        assertThat(personWeight.getTimeStamp(), is(0L));
        personWeight.setTimeStamp(13235445);
        assertThat(personWeight.getTimeStamp(), is(13235445));
    }

    @Test
    public void testWeight() throws Exception {
        assertThat(personWeight.getWeight(), is(0));
        personWeight.setWeight(154);
        assertThat(personWeight.getWeight(), is(154));
    }

    @Test
    public void getId() throws Exception {
        assertNull(personWeight.getId());
        ObjectId id = new ObjectId();
        personWeight.setId(id);
        assertThat(personWeight.getId(), is(id));
    }
}