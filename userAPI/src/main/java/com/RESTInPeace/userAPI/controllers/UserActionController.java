package com.RESTInPeace.userAPI.controllers;

import com.RESTInPeace.models.User;
import com.RESTInPeace.userAPI.utils.MongoDbTalkUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Log4j2
public class UserActionController {

    private final MongoDbTalkUtils mongoDbTalkUtils;

    @Autowired
    public UserActionController(MongoDbTalkUtils mongoDbTalkUtils) {
        this.mongoDbTalkUtils = mongoDbTalkUtils;
    }

    /**
     * This method creates a user given a user object that contains name and email
     *
     * @param httpServletRequest
     * @param user
     * @return boolean
     */
    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public boolean createUser(final HttpServletRequest httpServletRequest,
                              @RequestBody final User user) {
        log.info(String.format("%s invoked createUser().", httpServletRequest.getRemoteAddr()));

        // add a new object ( record ) to the MongoDB collection on the cloud
        return mongoDbTalkUtils.createUser(user);
    }

    /**
     * This method retrieves a user given an email
     * Throws an error if the user doesn't exist
     *
     * @param email
     * @param httpServletRequest
     * @return user object
     * @throws NoSuchFieldException
     */
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public User getUser(@RequestParam(value = "email", required = false, defaultValue = "") final String email,
                        final HttpServletRequest httpServletRequest) throws NoSuchFieldException {
        log.info(String.format("%s invoked getUser().", httpServletRequest.getRemoteAddr()));

        // throws an error if the user doesn't exist
        // else - returns the user
        final User user = mongoDbTalkUtils.getUser(email);

        return user;
    }
}