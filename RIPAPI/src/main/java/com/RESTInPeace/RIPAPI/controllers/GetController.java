package com.RESTInPeace.RIPAPI.controllers;

import com.RESTInPeace.RIPAPI.constants.RipConstants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;

import com.RESTInPeace.models.*;

@RestController
public class GetController {

    @RequestMapping(value = "/getRecords", method = RequestMethod.GET)
    public ArrayList<ProductRecord> getRecords (@RequestParam final String searchStr){

        RestTemplate restTemplate = new RestTemplate();
        ArrayList<ProductRecord> records = new ArrayList<ProductRecord>();
        HashMap<String, User> users = new HashMap<>();
        ArrayList<Coffin> coffins = new ArrayList<>();
        
        // Step 1: Decide whether to search or get all coffins
        if(searchStr == null) {
            //get all records
            coffins.addAll(restTemplate.getForObject(RipConstants.COFFIN_HOST + "/getCoffins", ArrayList.class));
        } else {
            //get search result
            coffins.addAll(restTemplate.getForObject(RipConstants.COFFIN_HOST + "/getCoffins?search={searchStr}", ArrayList.class, searchStr));
        }

        // Step 2: For each coffin, create product record for it
        for( Coffin coffin : coffins) 
        {
            // Step 3: Save user info locally
            final String userEmail = coffin.getUserEmail();
            if( !users.containsKey(userEmail) ) { 
                final User user = restTemplate.getForObject(RipConstants.USER_HOST+"/getUser?email={email}", User.class, userEmail);
                users.put(userEmail, user);
            }
            // Step 4: Create product record and save into records
            records.add(ProductRecord.builder().coffinInfo(coffin).userInfo(users.get(userEmail)).build());
        }
        // Step 5: return.
        return records;
    }

}
