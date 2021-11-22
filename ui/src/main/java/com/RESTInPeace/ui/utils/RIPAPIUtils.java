package com.RESTInPeace.ui.utils;

import com.RESTInPeace.models.ProductRecord;
import com.RESTInPeace.ui.constants.RIPAPIConstants;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class RIPAPIUtils {

    private final RestTemplate restTemplate;

    @Autowired
    public RIPAPIUtils(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ProductRecord> getRecords(@NonNull final String request) {
        // final String uri = String.format("%s?request=%s", RIPAPIConstants.RIP_API_URL_GET_RECORD, request);
        // return restTemplate.getForObject(uri, ArrayList.class);
        return null;

    }

    public void setRecord(@NonNull final ProductRecord record) {
        // final Boolean result = restTemplate.postForObject(RIPAPIConstants.RIP_API_URL_SET_RECORD,
        //         new HttpEntity<>(record),
        //         Boolean.class);
        // log.info(String.format("setRecord status <{%d}>", result));
    }
}
