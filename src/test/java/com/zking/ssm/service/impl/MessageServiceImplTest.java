package com.zking.ssm.service.impl;

import com.zking.ssm.model.Message;
import com.zking.ssm.service.IMessageService;
import com.zking.ssm.service.impl.base.BaseTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class MessageServiceImplTest extends BaseTestCase {


    @Autowired
    private IMessageService iMessageService;
    private Message message;

    @Override
    public void before() {
        super.before();
        message = new Message();
    }

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
        message.setMname("刘海杰");
        message.setMphone("15080922540");
        message.setMcontent("特别棒");
        iMessageService.insertSelective(message);
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