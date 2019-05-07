package com.zking.ssm.mapper;

import com.zking.ssm.model.Express;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpressMapper {
    int deleteByPrimaryKey(Integer eid);

    int insert(Express record);

    int insertSelective(Express record);

    Express selectByPrimaryKey(Integer eid);

    int updateByPrimaryKeySelective(Express record);

    int updateByPrimaryKey(Express record);

    List<Express> listExpress(Express express);
}