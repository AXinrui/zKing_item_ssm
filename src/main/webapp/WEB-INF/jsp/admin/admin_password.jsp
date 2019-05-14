<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/13
  Time: 23:51
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
    <link rel="stylesheet" href="${ctx}/css/font.css">
    <link rel="stylesheet" href="${ctx}/css/xadmin.css">
    <script type="text/javascript" src="${ctx}/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${ctx}/js/xadmin.js"></script>
    <script src="${ctx}/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${ctx}/js/jquery.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row">
        <form class="layui-form" method="post" >
            <input type="hidden" id="account" value="${account}" >
            <div class="layui-form-item">
                <label for="L_pass" class="layui-form-label">
                    <span class="x-red">*</span>新密码</label>
                <div class="layui-input-inline">
                    <input type="password" id="L_pass" name="" required="" lay-verify="pass" autocomplete="off" class="layui-input"></div>
                <div class="layui-form-mid layui-word-aux">6到16个字符</div></div>
            <div class="layui-form-item">
                <label for="L_repass" class="layui-form-label">
                    <span class="x-red">*</span>确认密码</label>
                <div class="layui-input-inline">
                    <input type="password" id="L_repass" name="password" required="" lay-verify="repass" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="L_repass" class="layui-form-label"></label>
                <input value="修改" class="layui-input" lay-submit lay-filter="login" style="width:100%;" type="submit">
            </div>
        </form>
    </div>
</div>

<script>
    $(function  () {
        layui.use('form', function(){
            var form = layui.form;
            // layer.msg('玩命卖萌中', function(){
            //关闭后的操作
            //   });
            //监听提交
            form.on('submit(login)', function(){
                var account = $("#account").val();
                var password = $("#L_pass").val();
                var pwd = $("#L_repass").val();
                var json = {
                    "account" : account,
                    "password" : password
                };
                if(pwd==password){
                    if(""!=account&&""!=password){
                        $.ajax({
                            url : "admin/adminForget?account="+account+"&password="+password,
                            type : "GET",
                            async : true,
                            dataType : 'json',
                            success : function(data) {
                                if (data =="1") {
                                    layer.msg("修改成功，请重新登录",function(){
                                        //关闭当前frame
                                        xadmin.close();

                                        // 可以对父窗口进行刷新
                                        xadmin.father_reload();

                                    });
                                } else {
                                    layer.msg("修改失败，密码错误",function(){
                                    });
                                }
                            }
                        });
                        //监听提交
                        return false;
                    }
                }else{
                    layer.msg('请输入2次相同的密码!',{icon: 5,time:1000});
                }
            });
        });
    })
</script>
</body>

</html>
