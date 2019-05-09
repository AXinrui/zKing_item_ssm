package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.CourierSonUserMapper;
import com.zking.ssm.model.CourierSonUser;
import com.zking.ssm.service.ICourierSonUserService;
import com.zking.ssm.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourierSonUserServiceImpl implements ICourierSonUserService {

    @Autowired
    private CourierSonUserMapper courierSonUserMapper;

    @Override
    public int deleteByPrimaryKey(Integer csuid) {
        return courierSonUserMapper.deleteByPrimaryKey(csuid);
    }

    @Override
    public int insert(CourierSonUser record) {
        return courierSonUserMapper.insert(record);
    }

    @Override
    public int insertSelective(CourierSonUser record) {
        return courierSonUserMapper.insertSelective(record);
    }

    @Override
    public CourierSonUser selectByPrimaryKey(Integer csuid) {
        return courierSonUserMapper.selectByPrimaryKey(csuid);
    }

    @Override
    public int updateByPrimaryKeySelective(CourierSonUser record) {
        return courierSonUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CourierSonUser record) {
        return courierSonUserMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<CourierSonUser> listCourierSonUser(CourierSonUser courierSonUser, PageBean pageBean) {
        return courierSonUserMapper.listCourierSonUser(courierSonUser);
    }
}
