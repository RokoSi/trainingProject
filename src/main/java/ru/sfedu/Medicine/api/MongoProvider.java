package ru.sfedu.Medicine.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import ru.sfedu.Medicine.model.CommandType;
import ru.sfedu.Medicine.model.RepositoryType;
import ru.sfedu.Medicine.utils.Constants;

import javax.swing.text.Document;
import java.util.Date;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoProvider {
   /* private static final Logger log = LogManager.getLogger(Mongoprovider.class.getName());
    public static <T> void save(String NameOpr, String NameApi, String NameBD) {
        log.debug("save [1]: command = {}, type = {}, object = {}, dbName = {}", NameOpr, NameApi, NameBD);
        MongoCollection<Document> collection = getCollection(obj.getClass(), bdName);
        ObjectMapper objectMapper = new ObjectMapper();

        MongoClient mongoClient = new MongoClient(getConfigurationEntry(Constants.MONGO_HOST),
                Integer.parseInt(getConfigurationEntry(Constants.MONGO_PORT)));
        DB database = mongoClient.getDB("myMongoDb");
        database.createCollection("customers", null);
        DBCollection collection = database.getCollection("customers");

        //чтобы можно было записовать состояние pojo используем кодек
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        BasicDBObject document = new BasicDBObject();
        document.put(Constants.MONGO_FIELD_TIME, new Date());
        document.put(Constants.MONGO_FIELD_COMMAND, NameOpr);
        document.put(Constants.MONGO_FIELD_REPOSITORY, NameApi);
        collection.insert(document);
    }

    private static <T> MongoCollection<Document> getCollection(Class<T> clazz, String bdName) {
        //подключение к БД
        MongoClient mongoClient = new MongoClient(getConfigurationEntry(Constants.MONGO_HOST), Integer.parseInt(getConfigurationEntry(Constants.MONGO_PORT)));
        //чтобы можно было записовать состояние pojo используем кодек
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(), fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        MongoDatabase database = mongoClient.getDatabase(bdName).withCodecRegistry(pojoCodecRegistry);
        return database.getCollection(clazz.getSimpleName().toLowerCase());
    }*/

    private static final Logger log = LogManager.getLogger(MongoProvider.class.getName());
    public static <T> void save(CommandType command, RepositoryType repositoryType, String bdName, T obj) {
        log.debug("save [1]: command = {}, type = {}, object = {}, dbName = {}", command, repositoryType, obj, bdName);
        try {
            MongoCollection<Document> collection = getCollection(obj.getClass(), bdName);
            ObjectMapper objectMapper = new ObjectMapper();
            Document document = new Document();
            document.put(Constants.MONGO_FIELD_TIME, new Date());
            document.put(Constants.MONGO_FIELD_COMMAND, command.toString());
            document.put(Constants.MONGO_FIELD_REPOSITORY, repositoryType.toString());
            document.put(Constants.MONGO_FIELD_OBJECT, objectMapper.writeValueAsString(obj));
            collection.insertOne(document);
        } catch (Exception e) {
            log.error("save [2]: {}", e.getMessage());
        }
    }

    private static <T> MongoCollection<Document> getCollection(Class<T> clazz, String bdName) {
        /*MongoClient mongoClient = new MongoClient(
                getConfigurationEntry(Constants.MONGO_HOST),
                Integer.parseInt(getConfigurationEntry(Constants.MONGO_PORT)));*/
        MongoClient mongoClient = new MongoClient("localhost",27017);

        CodecRegistry pojoCodecRegistry = fromRegistries(
                MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        MongoDatabase database = mongoClient.getDatabase("Mongonew").withCodecRegistry(pojoCodecRegistry);
        return database.getCollection(clazz.getSimpleName().toLowerCase());
    }

}




