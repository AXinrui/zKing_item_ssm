package com.zking.ssm.service;

import com.zking.ssm.model.Express;
import com.zking.ssm.utils.PageBean;

import java.util.List;

public interface IExpressService {

    boolean deleteByPrimaryKey(Integer eid);

    boolean insert(Express record);

    boolean insertSelective(Express record);

    Express selectByPrimaryKey(Integer eid);

    boolean updateByPrimaryKeySelective(Express record);

    boolean updateByPrimaryKey(Express record);

    List<Express> expressList(Express express, PageBean pageBean);

}
