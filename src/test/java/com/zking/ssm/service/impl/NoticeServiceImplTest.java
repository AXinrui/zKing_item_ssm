package com.zking.ssm.service.impl;

import com.zking.ssm.model.Notice;
import com.zking.ssm.service.INoticeService;
import com.zking.ssm.service.impl.base.BaseTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NoticeServiceImplTest extends BaseTestCase {

    @Autowired
    private INoticeService iNoticeService;
    private Notice notice;

    @Override
    public void before() {
        super.before();
        notice = new Notice();
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

    @Test
    public void listNotice() {
        notice.setDictItem("服务介绍");
        List<Notice> listNotice = iNoticeService.listNotice(notice, pageBean);
        for (Notice n : listNotice) {
            System.out.println(n);
        }
    }
}