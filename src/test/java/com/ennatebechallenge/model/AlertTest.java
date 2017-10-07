package com.ennatebechallenge.model;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class AlertTest {
    private Alert alert = new Alert();
    @Test
    public void testAlert() throws Exception {
        assertNull(alert.getAlert());
        alert.setAlert("underweight");
        assertThat(alert.getAlert(), is("underweight"));
    }

    @Test
    public void testTimeStamp() throws Exception {
        assertThat(alert.getTimeStamp(), is(0L));
        alert.setTimeStamp(13235445);
        assertThat(alert.getTimeStamp(), is(13235445L));
    }

    @Test
    public void testPersonWeight() throws Exception {
        PersonWeight personWeight = new PersonWeight();
        assertNull(alert.getPersonWeight());
        alert.setPersonWeight(personWeight);
        assertThat(alert.getPersonWeight(), is(personWeight));
    }
}