package ru.sfedu.Medicine;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class.getName());
    public static void main(String[] args) {
        
/*
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB database = mongoClient.getDB("newMongoDb");

       database.createCollection("customers", null);
        DBCollection collection = database.getCollection("customers");
        BasicDBObject document = new BasicDBObject();
        document.put("name", "Shubham");
        document.put("company", "Baeldung");
        collection.insert(document);
        //DB database = mongoClient.getDB("myMongoDb");

        try {
            String key1 = ConfigurationUtil.getConfigurationEntry("key1");
            String key2 = ConfigurationUtil.getConfigurationEntry("key2");
            logger.info(String.format("(key1 - %s)\n", key1));
            logger.info(String.format("(key2 - %s)\n", key2, ConfigurationUtil.getConfigurationEntry(key2)));
        } catch (IOException e) {
            logger.error("Configurations not found");
        }*/


    }
}
