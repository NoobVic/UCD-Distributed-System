package com.RESTInPeace.RIPAPI.controllers;

import java.sql.Timestamp;
import java.util.Calendar;

import com.RESTInPeace.RIPAPI.constants.RipConstants;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CleanController {
    @RequestMapping(value = "/clean", method = RequestMethod.POST)
    public boolean deleteCoffins (@RequestParam int days){
        // this controller will invoke clean api
        Timestamp current = new Timestamp(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(current.getTime());
        cal.add(Calendar.DAY_OF_MONTH, -days);
        Timestamp target = new Timestamp(cal.getTime().getTime());
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(RipConstants.CLEAN_HOST+"/deleteCoffins?time={time}", target, boolean.class);
    }
}
