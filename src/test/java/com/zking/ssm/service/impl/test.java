package com.zking.ssm.service.impl;

import java.text.SimpleDateFormat;

public class test {


    public static void main(String[] args) {

        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        System.out.println(df.format(new java.util.Date()));// new Date()为获取当前系统时间

    }

}
