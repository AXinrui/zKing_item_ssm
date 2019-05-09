package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.PropertyMapper;
import com.zking.ssm.model.Property;
import com.zking.ssm.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PropertyServiceImpl implements IPropertyService {

    @Autowired
    private PropertyMapper propertyMapper;

    @Override
    public int deleteByPrimaryKey(Integer pid) {
        return propertyMapper.deleteByPrimaryKey(pid);
    }

    @Override
    public int insert(Property record) {
        return propertyMapper.insert(record);
    }

    @Override
    public int insertSelective(Property record) {
        return propertyMapper.insertSelective(record);
    }

    @Override
    public Property selectByPrimaryKey(Integer pid) {
        return propertyMapper.selectByPrimaryKey(pid);
    }

    @Override
    public int updateByPrimaryKeySelective(Property record) {
        return propertyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Property record) {
        return propertyMapper.updateByPrimaryKey(record);
    }
}
