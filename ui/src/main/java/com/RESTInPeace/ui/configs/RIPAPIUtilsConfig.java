package com.RESTInPeace.ui.configs;

import com.RESTInPeace.ui.utils.RIPAPIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RIPAPIUtilsConfig {
    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RIPAPIUtils ripapiUtils() {
        return new RIPAPIUtils(restTemplate);
    }
}
