package com.RESTInPeace.userAPI.utils;

import com.RESTInPeace.models.User;
import com.RESTInPeace.userAPI.constants.MongoConstants;
import com.google.gson.Gson;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

@Log4j2
public class MongoDbTalkUtils {
    // will be able to reassign it
    protected MongoCollection<Document> collection;

    /**
     * This method connects to the mongo database
     * and establishes a connection to the collection 'users'
     */
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

    /**
     * This method parses a User object as a json >> document and
     * inserts it into the DB collection 'users'
     *
     * @param user user object
     * @return
     */
    public boolean createUser(@NonNull final User user) {
        // check if a user exists
        // if yes - return it
        // if no - create a new user with the passed data
        try {
            User tmpUser = getUser(user.getEmail());
            log.info("USER ALREADY EXISTS");
            return false;
        } catch (NoSuchFieldException e) { // create a new user
            final String json = new Gson().toJson(user);
            final Document doc = Document.parse(json);
            collection.insertOne(doc);
            return true;
        }
    }

    /**
     * This method looks for a user in the MongoDB collection 'users'
     *
     * @param email retrieve user by email
     * @return user ( if found )
     * @throws NoSuchFieldException
     */
    public User getUser(@NonNull final String email) throws NoSuchFieldException {
        try {
            final Document document = collection.find(eq(MongoConstants.EMAIL, email)).first();
            return createUserObject(document);
        } catch (final Exception e) {
            throw new NoSuchFieldException(
                    String.format("The given email: <{%s}> does not correspond to a user.", email));
        }
    }

    /**
     * This method creates a user object given a MongoDB document (record) that contains user details
     *
     * @param document contains user details
     * @return user object
     */
    private User createUserObject(@NonNull final Document document) {
        return User.builder()
                .name(document.getString(MongoConstants.NAME))
                .email(document.getString(MongoConstants.EMAIL))
                .id(document.get(MongoConstants.ID).toString())
                .build();
    }
}
