package com.zking.ssm.service.impl;

import com.zking.ssm.model.ExpressSite;
import com.zking.ssm.service.IExpressSiteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExpressSiteServiceImpl implements IExpressSiteService {
    @Override
    public int deleteByPrimaryKey(Integer sid) {
        return 0;
    }

    @Override
    public int insert(ExpressSite record) {
        return 0;
    }

    @Override
    public int insertSelective(ExpressSite record) {
        return 0;
    }

    @Override
    public ExpressSite selectByPrimaryKey(Integer sid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(ExpressSite record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(ExpressSite record) {
        return 0;
    }
}
