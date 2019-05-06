package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.NoticeMapper;
import com.zking.ssm.model.Notice;
import com.zking.ssm.service.INoticeService;
import com.zking.ssm.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NoticeServiceImpl implements INoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public int deleteByPrimaryKey(Integer nid) {
        return noticeMapper.deleteByPrimaryKey(nid);
    }

    @Override
    public int insert(Notice record) {
        return noticeMapper.insert(record);
    }

    @Override
    public int insertSelective(Notice record) {
        return noticeMapper.insertSelective(record);
    }

    @Override
    public Notice selectByPrimaryKey(Integer nid) {
        return noticeMapper.selectByPrimaryKey(nid);
    }

    @Override
    public int updateByPrimaryKeySelective(Notice record) {
        return noticeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Notice record) {
        return noticeMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Notice> listNotice(Notice notice, PageBean pageBean) {
        return noticeMapper.listNotice(notice);
    }
}
