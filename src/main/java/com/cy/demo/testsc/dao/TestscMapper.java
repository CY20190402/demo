package com.cy.demo.testsc.dao;

import com.cy.demo.testsc.entity.Testsc;

public interface TestscMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Testsc record);

    int insertSelective(Testsc record);

    Testsc selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Testsc record);

    int updateByPrimaryKey(Testsc record);
}