package com.RESTInPeace.coffinAPI.utils;

import com.RESTInPeace.coffinAPI.constants.MongoConstants;
import com.RESTInPeace.models.Coffin;
import com.google.gson.Gson;
import com.mongodb.Mongo;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.bson.Document;

import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;

@Log4j2
public class MongoDbTalkUtils {
    protected MongoCollection<Document> collection;

    public void connectToCollection() {
        final MongoClient mongoClient = MongoClients.create(
                String.format(MongoConstants.DATABASE_URL_FORMAT,
                        MongoConstants.DATABASE_USER,
                        MongoConstants.DATABASE_PASSWORD,
                        MongoConstants.CLUSTER_NAME,
                        MongoConstants.DATABASE_NAME));
        final MongoDatabase database = mongoClient.getDatabase(MongoConstants.DATABASE_NAME);
        this.collection = database.getCollection(MongoConstants.COLLECTION_NAME);
    }

    public boolean createCoffin(@NonNull final Coffin coffin) {
        try {
            coffin.setTimeStamp(System.currentTimeMillis());
            final String json = new Gson().toJson(coffin);
            final Document doc = Document.parse(json);
            collection.insertOne(doc);
            return true;
        } catch (final Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private Coffin createCoffinFromMongoDocument(@NonNull final Document document) {
        return Coffin.builder()
                .id(document.get(MongoConstants.ID).toString())
                .userEmail(document.getString(MongoConstants.EMAIL))
                .name(document.getString(MongoConstants.NAME))
                .name(document.getString(MongoConstants.IMAGE))
                .description(document.getString(MongoConstants.DESCRIPTION))
                .price(document.getInteger(MongoConstants.PRICE))
                .timeStamp(document.getLong(MongoConstants.TIMESTAMP))

                .build();
    }

    public ArrayList<Coffin> getCoffins() {
        final ArrayList<Coffin> coffinList = new ArrayList<>();

        for (final Document coffinDoc : collection.find()) {
            coffinList.add(createCoffinFromMongoDocument(coffinDoc));
        }
        return coffinList;
    }

    // TODO search string analysis
    public ArrayList<Coffin> getCoffins(@NonNull final String search){
        final ArrayList<Coffin> coffinList = new ArrayList<>();

        for (final Document coffinDoc : collection.find()) {
            coffinList.add(createCoffinFromMongoDocument(coffinDoc));
        }
        return coffinList;
    }

    public ArrayList<Coffin> getCoffin(@NonNull final String email) {

        final ArrayList<Coffin> coffins = new ArrayList<>();

        for (Document document : collection.find(eq(MongoConstants.EMAIL, email))) {
            log.info(String.format(document + " found"));
            final Coffin coffin = createCoffinFromMongoDocument(document);
            coffins.add(coffin);
        }

        return coffins;
    }
}
