package org.cccgermantown.web.contact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by LeOn on 12/1/14.
 */
@Controller
public class UiController {

    @RequestMapping(value = "/view/index.html", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView handleDefault() {
        ModelAndView model = new ModelAndView("index");
        model.addObject("msg", "hello!--");
        return model;

    }
}
