package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.FinanceMapper;
import com.zking.ssm.model.Finance;
import com.zking.ssm.service.IFinanceService;
import com.zking.ssm.utils.PageBean;
import com.zking.ssm.vo.FinanceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FinanceServiceImpl implements IFinanceService {

    @Autowired
    private FinanceMapper financeMapper;

    @Override
    public int deleteByPrimaryKey(Integer fid) {
        return financeMapper.deleteByPrimaryKey(fid);
    }

    @Override
    public int insert(Finance record) {
        return financeMapper.insert(record);
    }

    @Override
    public int insertSelective(Finance record) {
        return financeMapper.insertSelective(record);
    }

    @Override
    public Finance selectByPrimaryKey(Integer fid) {
        return financeMapper.selectByPrimaryKey(fid);
    }

    @Override
    public int updateByPrimaryKeySelective(Finance record) {
        return financeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Finance record) {
        return financeMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Finance> listFinance(FinanceVo financeVo,PageBean pageBean) {
        return financeMapper.listFinance(financeVo);
    }
}
