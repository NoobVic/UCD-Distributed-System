package com.RESTInPeace.coffinAPI.configs;

import com.RESTInPeace.coffinAPI.utils.MongoDbTalkUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoDbConfigs {
    @Bean
    public MongoDbTalkUtils createMongoDbTalkUtils() {
        final MongoDbTalkUtils mongoDbTalkUtils = new MongoDbTalkUtils();
        mongoDbTalkUtils.connectToCollection();
        return mongoDbTalkUtils;
    }
}
