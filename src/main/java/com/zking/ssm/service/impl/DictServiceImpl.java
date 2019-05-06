package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.DictMapper;
import com.zking.ssm.model.Dict;
import com.zking.ssm.service.IDictService;
import com.zking.ssm.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DictServiceImpl implements IDictService {

    @Autowired
    private DictMapper dictMapper;

    @Override
    public int deleteByPrimaryKey(Integer tid) {
        return dictMapper.deleteByPrimaryKey(tid);
    }

    @Override
    public int insert(Dict record) {
        return dictMapper.insert(record);
    }

    @Override
    public int insertSelective(Dict record) {
        return dictMapper.insertSelective(record);
    }

    @Override
    public Dict selectByPrimaryKey(Integer tid) {
        return dictMapper.selectByPrimaryKey(tid);
    }

    @Override
    public int updateByPrimaryKeySelective(Dict record) {
        return dictMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Dict record) {
        return dictMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Dict> listDict(Dict dict, PageBean pageBean) {
        List<Dict> dictList = dictMapper.listDict(dict);
        return dictList;
    }
}
