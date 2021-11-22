package com.RESTInPeace.ui.controllers;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@Log4j2
public class Homepage {

    @GetMapping({"/", "/home", "/index"})
    public ModelAndView homepage(final HttpServletRequest httpServletRequest) {
        final ModelAndView view = new ModelAndView("index");

        log.info(String.format("%s called a home page", httpServletRequest.getRemoteAddr()));
        return view;
    }
}
