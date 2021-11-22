package com.RESTInPeace.coffinAPI.controllers;

import com.RESTInPeace.coffinAPI.utils.MongoDbTalkUtils;
import com.RESTInPeace.models.Coffin;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RestController
@Log4j2
public class CoffinActionController {

    private final MongoDbTalkUtils mongoDbTalkUtils;

    @Autowired
    public CoffinActionController(MongoDbTalkUtils mongoDbTalkUtils) {
        this.mongoDbTalkUtils = mongoDbTalkUtils;
    }


    @RequestMapping(value = "/createCoffin", method = RequestMethod.POST)
    public Boolean createCoffin(@RequestBody final Coffin coffin, final HttpServletRequest httpServletRequest) {
        log.info(String.format("%s invoked createCoffin()", httpServletRequest.getRemoteAddr()));

        return mongoDbTalkUtils.createCoffin(coffin);
    }

    @RequestMapping(value = "/getCoffins", method = RequestMethod.GET)
    public ArrayList<Coffin> getCoffins(final HttpServletRequest httpServletRequest,
                                        @RequestParam(value = "search", defaultValue = "") final String search) {
        log.info(String.format("%s invoked getCoffin()", httpServletRequest.getRemoteAddr()));

        if (search.equals("")) {
            return mongoDbTalkUtils.getCoffins();

        } else {
            return mongoDbTalkUtils.getCoffins(search);
        }
    }

    @RequestMapping(value = "/getCoffin", method = RequestMethod.GET)
    public ArrayList<Coffin> getCoffin(@RequestParam(value = "email") final String email,
                                       final HttpServletRequest httpServletRequest) {

        log.info(String.format("%s invoked getCoffin()", httpServletRequest.getRemoteAddr()));
        log.info(String.format("email: %s", email));

        return mongoDbTalkUtils.getCoffin(email);
    }

}
