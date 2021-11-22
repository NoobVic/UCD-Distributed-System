package com.RESTInPeace.ui.controllers;

import com.RESTInPeace.models.Coffin;
import com.RESTInPeace.models.ProductRecord;
import com.RESTInPeace.models.User;
import com.RESTInPeace.ui.utils.RIPAPIUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Log4j2
public class SearchCoffin {

        private final RIPAPIUtils ripapiUtils;

        @Autowired
        public SearchCoffin(final RIPAPIUtils ripapiUtils) {
                this.ripapiUtils = ripapiUtils;
        }

        @GetMapping({ "/searchcoffin", "/searchcoffin" })
        public ModelAndView searchCoffin(final HttpServletRequest httpServletRequest,
                        @RequestParam(value = "searchString", defaultValue = "") final String searchString) {
                final ModelAndView view = new ModelAndView("searchCoffin");

                List<ProductRecord> recordList = ripapiUtils.getRecords(searchString);

                // just a placeholder
                final User user = User.builder().email("email").name("username").build();
                final Coffin coffin = Coffin.builder().description("some description").name("name")
                                .price(Integer.valueOf("120")).build();
                recordList = List.of(ProductRecord.builder().userInfo(user).coffinInfo(coffin).build(),
                                ProductRecord.builder().userInfo(user).coffinInfo(coffin).build(),
                                ProductRecord.builder().userInfo(user).coffinInfo(coffin).build(),
                                ProductRecord.builder().userInfo(user).coffinInfo(coffin).build());
                // placeholder end

                log.info(String.format("%s called a SearchCoffin page", httpServletRequest.getRemoteAddr()));
                view.addObject("records", recordList);
                return view;
        }
}
