package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.CourierUserMapper;
import com.zking.ssm.model.CourierUser;
import com.zking.ssm.model.User;
import com.zking.ssm.service.ICourierUserService;
import com.zking.ssm.utils.PageBean;
import com.zking.ssm.vo.CourierUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourierUserServiceImpl implements ICourierUserService {

    @Autowired
    private CourierUserMapper courierUserMapper;

    @Override
    public int deleteByPrimaryKey(Integer cuid) {
        return courierUserMapper.deleteByPrimaryKey(cuid);
    }

    @Override
    public int insert(CourierUser record) {
        return courierUserMapper.insert(record);
    }

    @Override
    public int insertSelective(CourierUser record) {
        return courierUserMapper.insertSelective(record);
    }

    @Override
    public CourierUser selectByPrimaryKey(Integer cuid) {
        return courierUserMapper.selectByPrimaryKey(cuid);
    }

    @Override
    public int updateByPrimaryKeySelective(CourierUser record) {
        return courierUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CourierUser record) {
        return courierUserMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<CourierUser> listCourierUser(CourierUserVo courierUserVo, PageBean pageBean) {
        return courierUserMapper.listCourierUser(courierUserVo);
    }
}
