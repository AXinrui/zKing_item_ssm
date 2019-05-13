package com.zking.ssm.service;

import com.zking.ssm.model.Finance;
import com.zking.ssm.utils.PageBean;
import com.zking.ssm.vo.FinanceVo;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IFinanceService {
    int deleteByPrimaryKey(Integer fid);

    int insert(Finance record);

    int insertSelective(Finance record);

    Finance selectByPrimaryKey(Integer fid);

    int updateByPrimaryKeySelective(Finance record);

    int updateByPrimaryKey(Finance record);

    List<Finance> listFinance(FinanceVo financeVo, PageBean pageBean);
}