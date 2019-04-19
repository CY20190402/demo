package com.cy.demo.demo.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test {

    @Value("${testname}")
    String name;

    @RequestMapping(value = "test")
    @ResponseBody
    public String test() {
        return "111" + name;
    }
}
