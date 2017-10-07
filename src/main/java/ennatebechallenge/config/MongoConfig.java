package ennatebechallenge.config;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.MongoDbFactory;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
public class MongoConfig{

    private static final String host = "127.0.0.1";
    private static final String port = "27017";
    private static final String dbname = "ennateChallengeDb";

    /*
        we are intended to reference @Bean methods among each other within the same class,
        the @Configuration class and its factory methods should not be final or private.
     */
    public @Bean MongoClient mongoClient(){
        return new MongoClient(host + ":" + port);
    }

    /*
        Note that inside this function a @Bean method is calling another @Bean method within the same class,
        we are calling mongoClient() method inside datastore() method. Spring ensures that references between
        beans are strongly typed and navigable and when a @Bean method is being called/referenced the @Bean
        method being called/referenced is guaranteed to return the same bean as it would for other places.
    */
    @Bean
    public Datastore datastore() {
        // Generate all the interfaces we need to access to manipulate mongo
        Morphia morphia = new Morphia();
        morphia.mapPackage("ennatebechallenge.model");
        Datastore datastore = morphia.createDatastore(mongoClient(), dbname);
        datastore.ensureIndexes();
        return datastore;
    }

    /*
        mongoTemplate() bean method is required for Spring Data. The reason to add this is that there seems to
        be no API in Morphia that can drop the whole collection, so I used this MongoTemplate as a shortcut of
        cleaning up our datastore after each run of our application. MongoTemplate provides remove() interface
        which will provide drop collection capability.
     */
//    public @Bean MongoDbFactory mongoDbFactory(){
//        return new SimpleMongoDbFactory(mongoClient(), dbname);
//    }
//
//    public @Bean MongoTemplate mongoTemplate(){
//        return new MongoTemplate(mongoDbFactory());
//    }






}