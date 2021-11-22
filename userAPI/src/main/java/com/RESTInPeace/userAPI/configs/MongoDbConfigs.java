package com.RESTInPeace.userAPI.configs;

import com.RESTInPeace.userAPI.utils.MongoDbTalkUtils;
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
