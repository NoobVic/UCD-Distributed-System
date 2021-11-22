package com.RESTInPeace.coffinAPI.utils;

import com.RESTInPeace.models.Coffin;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class MongoDbTalkUtilsTests {
    @Mock
    private MongoCollection<Document> collection;

    private MongoDbTalkUtils classUnderTest;

    private Coffin testCoffin = Coffin.builder()
            .id("id")
            .description("description")
            .timeStamp(System.currentTimeMillis())
            .name("name")
            .price(10)
            .userEmail("email@email.email")
            .build();

    @Before
    public void setUp() {
        classUnderTest = new MongoDbTalkUtils();
        classUnderTest.collection = this.collection;
    }

    @Test
    public void testCreateCoffinHappy() {
        final Boolean result = classUnderTest.createCoffin(testCoffin);
        Assert.assertTrue(result);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateCoffinNoCoffinObj() {
        classUnderTest.createCoffin(null);
    }


}
