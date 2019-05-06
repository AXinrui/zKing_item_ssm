package com.zking.ssm.service;

import com.zking.ssm.model.Notice;
import com.zking.ssm.utils.PageBean;

import java.util.List;

public interface INoticeService {
    int deleteByPrimaryKey(Integer nid);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer nid);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);

    List<Notice> listNotice(Notice notice, PageBean pageBean);

}
