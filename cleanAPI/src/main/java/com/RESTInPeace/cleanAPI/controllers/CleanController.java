package com.RESTInPeace.cleanAPI.controllers;

import com.RESTInPeace.cleanAPI.constants.CleanConstants;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.sql.Timestamp;

import java.util.ArrayList;

import com.RESTInPeace.models.*;

@RestController
public class CleanController {

    @RequestMapping(value = "/deleteCoffins", method = RequestMethod.POST)
    public boolean clean(@RequestParam final Timestamp time) {
        
        // pass the time variable into coffin api and ask it to delete all coffins whose timeStamp greater than this value 
        return false;
    }
}
