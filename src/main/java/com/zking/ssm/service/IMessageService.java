package com.zking.ssm.service;

import com.zking.ssm.model.Message;
import com.zking.ssm.utils.PageBean;

import java.util.List;

public interface IMessageService {
    int deleteByPrimaryKey(Integer mid);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

    List<Message> listMessage(Message message, PageBean pageBean);
}
