package com.zking.ssm.service.impl;

import com.zking.ssm.model.CourierUser;
import com.zking.ssm.model.User;
import com.zking.ssm.service.ICourierUserService;
import com.zking.ssm.service.impl.base.BaseTestCase;
import com.zking.ssm.vo.CourierUserVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class CourierUserServiceImplTest extends BaseTestCase {

    @Autowired
    private ICourierUserService iCourierUserService;

    private CourierUserVo CourierUserVo;
    private CourierUser courierUser;

    @Override
    public void before() {
        super.before();
        CourierUserVo = new CourierUserVo();
        courierUser = new CourierUser();
    }

    @Test
    public void insertCourierUser() {
        courierUser.setUid(2);
        courierUser.setEutime(new Date());
        courierUser.setCuremark("这个还是还是个测试啊");
        int insert = iCourierUserService.insert(courierUser);
        System.out.println("insert-id:"+courierUser.getCuid());//返回自动增长的id，需要配置文件

    }

    @Test
    public void listCourierUser() {
        List<CourierUser> courierUsers = iCourierUserService.listCourierUser(CourierUserVo, pageBean);
        for (CourierUser user : courierUsers) {
            System.out.println(user.toString());
        }

    }
}