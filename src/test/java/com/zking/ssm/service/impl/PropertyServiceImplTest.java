package com.zking.ssm.service.impl;

import com.zking.ssm.model.Property;
import com.zking.ssm.service.IPropertyService;
import com.zking.ssm.service.impl.base.BaseTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class PropertyServiceImplTest extends BaseTestCase {

    @Autowired
    private IPropertyService iPropertyService;
    private Property property;

    @Override
    public void before() {
        super.before();
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