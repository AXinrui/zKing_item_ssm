<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/3
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html  class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>后台登录-X-admin2.2</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" href="../../../css/font.css">
    <link rel="stylesheet" href="../../../css/login.css">
    <link rel="stylesheet" href="../../../css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="../../../lib/layui/layui.js" charset="utf-8"></script>
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="login-bg">

<div class="login layui-anim layui-anim-up">
    <div class="message">后台管理登录-2.0</div>
    <div id="darkbannerwrap"></div>

    <form method="post" class="layui-form" >
        <input id="account"  placeholder="用户名" lay-verify="required"  type="text"  class="layui-input" >
        <hr class="hr15">
        <input id="password"  placeholder="密码" lay-verify="required"  type="password" class="layui-input">
        <hr class="hr15">
        <div class="layui-form-item">
            <div class="layui-input-block" style="width:100%;margin:0px;padding:0px;"   >
                <div id="slider" ></div>
            </div>
        </div>
        <input type="hidden" value="" id="yzm" />
        <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">
        <hr class="hr20" >
    </form>
</div>

<script type="text/javascript" charset="utf-8">

    var slider = "";
    layui.config({
        base: '../../../lib/layui_exts/'
    }).extend({
        sliderVerify:'sliderVerify/sliderVerify'
    }).use(['sliderVerify', 'jquery', 'form'], function() {
        var sliderVerify = layui.sliderVerify,
            form = layui.form;
        slider = sliderVerify.render({
            isAutoVerify:true,//自动验证
            elem: '#slider',
            onOk: function(){//当验证通过回调
                $.ajax({
                    url : "admin/yz",
                    dataType:'json',
                    success : function(data) {
                        $("#yzm").val(data);
                        layer.msg("滑块验证通过");
                    }
                });
            }
        })
    })

</script>


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
                var password = $("#password").val();
                var yzm = $("#yzm").val();
                var json = {
                    "account" : account,
                    "password" : password,
                    "huadong":yzm
                };

                $.ajax({
                    url : "admin/doLogin",
                    type : "POST",
                    async : true,
                    contentType : "application/json",
                    data : JSON.stringify(json),
                    dataType : 'json',
                    success : function(data) {
                        if (data =="1") {
                            layer.msg("登录成功，跳转中...",function(){
                                location.href='/url/admin/doIndex'
                            });
                        } else {
                            slider.reset();
                            layer.msg("登录失败，密码错误",function(){
                            });
                        }
                    }
                });
                //监听提交
                return false;
            });
        });
    })
</script>
<!-- 底部结束 -->
</body>
</html>
