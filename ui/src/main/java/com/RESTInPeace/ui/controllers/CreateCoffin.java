package com.RESTInPeace.ui.controllers;

import com.RESTInPeace.models.Coffin;
import com.RESTInPeace.models.ProductRecord;
import com.RESTInPeace.models.User;
import com.RESTInPeace.ui.utils.ImageAPIUtils;
import com.RESTInPeace.ui.utils.RIPAPIUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.jms.JMSException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@Log4j2
public class CreateCoffin {

    private final RIPAPIUtils ripapiUtils;
    private final MultipartResolver multipartResolver;

    @Autowired
    public CreateCoffin(final RIPAPIUtils ripapiUtils,
                        final MultipartResolver multipartResolver) {
        this.ripapiUtils = ripapiUtils;
        this.multipartResolver = multipartResolver;
    }

    @GetMapping("/createcoffin")
    public ModelAndView createCoffin(final HttpServletRequest httpServletRequest) {
        final ModelAndView view = new ModelAndView("createCoffin");

        log.info(String.format("%s called a CreateCoffin page", httpServletRequest.getRemoteAddr()));
        return view;
    }

    @RequestMapping(value = "/createCoffinAction",
            method = RequestMethod.POST)
    public String createCoffin(final HttpServletRequest httpServletRequest,
                               @RequestParam(value = "username") final String username,
                               @RequestParam(value = "email") final String email,
                               @RequestParam(value = "coffin_description") final String description,
                               @RequestParam(value = "coffin_name") final String name,
                               @RequestParam(value = "coffin_price") final String price) throws JMSException, IOException {

        log.info(String.format("%s called a CreateCoffin action", httpServletRequest.getRemoteAddr()));
        final MultipartFile picture = multipartResolver.resolveMultipart(httpServletRequest).getFile("pictureUpload");

        final User user = User.builder()
                .email(email)
                .name(username)
                .build();
        final Coffin coffin = Coffin.builder()
                .description(description)
                .name(name)
                .price(Integer.valueOf(price))
                .build();
        final ProductRecord record = ProductRecord.builder()
                .coffinInfo(coffin)
                .userInfo(user).build();

        ripapiUtils.setRecord(record);

        ImageAPIUtils.sendPicture(picture, String.format("%s%s%s%s",
                username,
                name,
                email,
                picture.getOriginalFilename()));

        return String.format("redirect:%s", "/");
    }
}
