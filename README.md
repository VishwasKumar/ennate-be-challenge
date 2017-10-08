# Ennate Challenge #

This service acts as an API 
* Consuming data sent from different sensors (emulators).
* Storing the received data in MongoDB.
*	Running the data through different rules to make basic predictions.

### How to Use the API ###

*	Consume data from the emulator via HTTP API and stores it in a MongoDB 
collection using Morphia API.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
The app is listening on **http://localhost:8080/metrics/create**      

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
To run the emulator use the following command: 

    `java -jar -Dbase.value=150 -Dapi.url=http://localhost:8080/metrics/create sensor-emulator-0.0.1-SNAPSHOT.jar`
    
* Exposes metrics data on Metric APIs using Spring MVC
    * **http://localhost:8080/metrics/read** to expose all the metrics 
    data collected.
    * **http://localhost:8080/metrics/read?start=12334&stop=43321** 
    to expose only the data which fall between the start and stop ranges.

     
* Expose alert data on Alert API using Spring MVC
    * **http://localhost:8080/alert/read** to expose all the metrics 
    data collected.
    * **http://localhost:8080/alert/read?start=12334&stop=43321** 
    to expose only the data which fall between the start and stop ranges.

### Notes ###

* There are two rules *underWeight* and *overWeight* based on the rule 
percentage and base weight build by using the easyrules rules engine.
* Please make sure mongo is up and running on localhost:27017.