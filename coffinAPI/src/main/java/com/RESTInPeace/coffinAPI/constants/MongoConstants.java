package com.RESTInPeace.coffinAPI.constants;

public class MongoConstants {
    public static final String DATABASE_URL_FORMAT = "mongodb+srv://%s:%s@%s.pkzn4.mongodb.net/%s?retryWrites=true&w=majority";

    public static final String DATABASE_PASSWORD = "12345678AaaA";
    public static final String DATABASE_USER = "RESTinPeace";
    public static final String DATABASE_NAME = "REST_in_peace";
    public static final String CLUSTER_NAME = "cluster0";
    public static final String COLLECTION_NAME = "coffins";

    // not a DB parameter - but an object
    public static final String DESCRIPTION = "description";
    public static final String NAME = "name";
    public static final String ID = "_id";
    public static final String EMAIL = "userEmail";
    public static final String IMAGE = "image";
    public static final String PRICE = "price";
    public static final String TIMESTAMP = "timeStamp";
}
