package com.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by asehgal on 1/4/2018.
 */
@Controller
@RequestMapping("/appointments")
public class AppointmentsController {

    @RequestMapping(method = RequestMethod.GET)
    public Map<String, String> get() {
        return null;
    }

}
