package com.zking.ssm.service.impl;

import com.zking.ssm.model.Dict;
import com.zking.ssm.service.IDictService;
import com.zking.ssm.service.impl.base.BaseTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DictServiceImplTest extends BaseTestCase {

    @Autowired
    private IDictService iDictService;
    private Dict dict;

    @Override
    public void before() {
        super.before();
        dict = new Dict();
    }

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }
}