package com.ennatebechallenge.config;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {
    private final MongoProperties mongoProperties;

    @Autowired
    public MongoConfig(MongoProperties mongoProperties) {
        this.mongoProperties = mongoProperties;
    }

    private Morphia morphia() {
        // Generate all the interfaces we need to access to manipulate mongo
        final Morphia morphia = new Morphia();
        morphia.mapPackage("com.ennatebechallenge");
        return morphia;
    }

    @Bean
    public Datastore datastore(MongoClient mongoClient) {
        final Datastore datastore = morphia().createDatastore(mongoClient, mongoProperties.getDatabase());
        datastore.ensureIndexes();

        return datastore;
    }
}