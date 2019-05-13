<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/9
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../../common/head.jsp"%>
<!DOCTYPE html>
<html class="x-admin-sm">

<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.2</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="${ctx}/css/font.css">
    <link rel="stylesheet" href="${ctx}/css/xadmin.css">
</head>
<body>
<div class="x-nav">
            <span class="layui-breadcrumb">
                <a href="">首页</a>
                <a href="">系统设置</a>
                <a>
                    <cite>短信配置设置</cite></a>
            </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
        <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i>
    </a>
</div>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-form-item">
        </div>
            <form action="${ctx}/url/admin/setNote" method="post" >
             <div class="layui-form-item">
            <label for="username" class="layui-form-label">
                <span class="x-red">*</span>请求接口地址：</label>
            <div class="layui-input-inline">
                <input type="text" id="mail" value="${note.url}" name="url" required="" lay-verify="required" autocomplete="off" class="layui-input"></div>
             </div>
        <div class="layui-form-item">
            <label for="username" class="layui-form-label">
                <span class="x-red">*</span>短信模板ID：</label>
            <div class="layui-input-inline">
                <input type="text" id="tpl_id" name="tpl_id" value="${note.tpl_id}" required="" lay-verify="required" autocomplete="off" class="layui-input"></div>
        </div>
        <div class="layui-form-item">
            <label for="phone" class="layui-form-label">
                <span class="x-red">*</span>APPKEY：</label>
            <div class="layui-input-inline">
                <input type="password" id="smtphost" name="key" value="${note.key}" lay-verify="required" autocomplete="off" class="layui-input"></div>
        </div>
        <div class="layui-form-item">
            <label for="username" class="layui-form-label">
                <span class="x-red">*</span>模板变量：</label>
            <div class="layui-input-inline">
                <input type="text" id="title" name="tpl_value" value="${note.tpl_value}" lay-verify="required" autocomplete="off" class="layui-input"></div>
        </div>
        <div class="layui-form-item">
            <label for="L_repass" class="layui-form-label"></label>
            <button class="layui-btn" lay-filter="add" lay-submit="">修改</button></div>
        </form>

    </div>
</div>
</body>
<script src="${ctx}/lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/js/xadmin.js"></script>
</html>
