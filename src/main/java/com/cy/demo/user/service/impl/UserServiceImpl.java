package com.cy.demo.user.service.impl;

import com.cy.demo.user.dao.UserDao;
import com.cy.demo.user.entity.User;
import com.cy.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    public List<User> get(){
        return userDao.get();

    }
}
