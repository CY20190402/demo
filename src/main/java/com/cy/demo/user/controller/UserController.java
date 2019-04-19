package com.cy.demo.user.controller;

import com.cy.demo.user.entity.User;
import com.cy.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/get")
    @ResponseBody
    public List<User> get(){
        List<User> users = this.userService.get();
        return users;
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "test";
    }
}




