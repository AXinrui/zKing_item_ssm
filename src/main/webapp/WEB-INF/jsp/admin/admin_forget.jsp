<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/13
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html  class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>忘记密码-X-admin2.2</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" href="${ctx}/css/font.css">
    <link rel="stylesheet" href="${ctx}/css/login.css">
    <link rel="stylesheet" href="${ctx}/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="${ctx}/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${ctx}/js/xadmin.js"></script>
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="login-bg">

<div class="login layui-anim layui-anim-up">
    <div class="message">忘记密码-2.0</div>
    <div id="darkbannerwrap"></div>

    <form method="post" class="layui-form" >
        <input id="account"  placeholder="账号" lay-verify="required"  type="text"  class="layui-input" >
        <hr class="hr15">
        <input id="email"  placeholder="邮箱" id = "email" lay-verify="email" type="text" class="layui-input">
        <hr class="hr15">
        <div class="layui-form-item">
            <input type="text" id="yzm" style="width: 200px;height: 50px;" placeholder="验证码" lay-verify="required" class="layui-input-inline" >
            <input type="button" value="获取验证码" onclick="doyzm()"  style="width: 130px;height: 50px;" lay-verify="required" class="layui-input-inline"  >
        </div>
        <input value="提交" lay-submit lay-filter="login" style="width:100%;" type="submit">
        <a href="${ctx}/admin/login.html" style="font-size: 15px;margin-top: 10px;float:right;" >返回登录</a>
        <hr class="hr20" >
    </form>
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
                var yzm = $("#yzm").val();
                $.ajax({
                    url : "yzm?yzm="+yzm+"&account="+account,
                    dataType : 'json',
                    success : function(data) {
                        if (data =="1") {
                            layer.msg("验证码正确，跳转中...",function(){
                                //location.href='/admin/doPassword'
                                xadmin.open('修改密码','doPassword?account='+account,500,300);
                            });
                        }else if(data="2"){
                            layer.msg("账号不存在，请重新输入！",function(){
                            });
                        }else {
                            layer.msg("验证码错误，请重新输入！",function(){
                            });
                        }
                    }
                });
                //监听提交
                return false;
            });

        });
    })
    function doyzm() {
        var account = $("#email").val();
        if(""!=account){
            var loadingFlag;
            $.ajax({
                url : "doyzm?account="+account,
                async : true,
                dataType : 'json',
                beforeSend: function (XMLHttpRequest) {
                    //注意，layer.msg默认3秒自动关闭，如果数据加载耗时比较长，需要设置time
                    loadingFlag= layer.msg('正在发送中，请稍候……', { icon: 16, shade: 0.01,shadeClose:false,time:60000 });
                },
                success : function(data) {
                    layer.close(loadingFlag);
                    if (data =="1") {
                        layer.msg("发送成功！");
                    }else if(data =="2") {
                        layer.msg("邮箱tm的都不存在！！！，请重新输入！");
                    }else{
                        layer.msg("发送失败，请重新输入！");
                    }
                }
            });
        }else{
            layer.msg("请输入！",{icon:5,time:1000});
        }
    }
    
    
</script>
<!-- 底部结束 -->
</body>
</html>
