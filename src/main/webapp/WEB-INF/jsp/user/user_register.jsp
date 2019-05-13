<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/5/4
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta name="Keywords" content="网站关键词">
    <meta name="Description" content="网站介绍">
    <link rel="stylesheet" href="../../../css/base.css">
    <link rel="stylesheet" href="../../../css/iconfont.css">
    <link rel="stylesheet" href="../../../css/reg.css">
    <%@include file="/common/head.jsp"%>

    <script type="text/javascript">

        function checkIsNull() {
            var uphone = "isNull";
            var verificationCode = "isNull";

            if(document.getElementById("tel").value != null && document.getElementById("tel").value != ""){ uphone = document.getElementById("tel").value; }
            if(document.getElementById("veri-code").value != null && document.getElementById("veri-code").value != ""){ verificationCode = document.getElementById("veri-code").value; }

            //alert("电话:" + uphone + "验证码:"+verificationCode);

            if(uphone != "isNull" && verificationCode != "isNull"){
                document.getElementById("nextStep").className = "lang-btn";
            }
            if(uphone == "isNull" || verificationCode == "isNull"){
                document.getElementById("nextStep").className = "lang-btn off log-btn";
            }
        }

        function sendVerificationCode() {
            //定义json对象
            var uphone = $("#tel").val();
            alert(uphone);
            var json = {
                "uphone" : uphone
            };

            // Jquery Ajax请求
            $.ajax({
                url : "user/sendVerificationCode",
                type : "POST",
                async : true,
                data : json,
                dataType : 'json',
                success : function(data) {}
            });
        }

        function isVerificationCode() {
            //定义json对象
            var userVerificationCode = $("#veri-code").val();
            alert(userVerificationCode);
            var json = {
                "userVerificationCode" : userVerificationCode
            };

            // Jquery Ajax请求
            $.ajax({
                url : "user/isVerificationCode",
                type : "POST",
                async : true,
                data : json,
                dataType : 'json',
                success : function(data) {
                    if(data == "1"){
                        alert("验证码正确");
                        buttonTransformation();
                    }else{
                        alert("验证码错误,请重新输入！");
                    }
                }
            });
        }
        
        function buttonTransformation() {
            document.getElementById("nextStep").style.display = "none";
            document.getElementById("register").style.display = "block";
            document.getElementById("phone").className = "p-input pos hide";
            document.getElementById("sendcode").className = "p-input pos hide";
            document.getElementById("pwd").className = "p-input pos";
            document.getElementById("confirmpwd").className = "p-input pos";
        }

    </script>

</head>
<body>
<div id="ajax-hook"></div>
<div class="wrap">
    <div class="wpn">
        <div class="form-data pos">

            <a href=""><img src="${ctx}/images/img/logo.png" class="head-logo"></a>
            <!--<p class="tel-warn hide"><i class="icon-warn"></i></p>-->
            <form action="${ctx}/user/userRegister" method="post">
                <p class="p-input pos" id="phone">
                    <label for="tel">手机号</label>
                    <input type="number" id="tel" autocomplete="off" name="uphone" onfocus="checkIsNull()">
                    <span class="tel-warn tel-err hide"><em></em><i class="icon-warn"></i></span>
                </p>
                <p class="p-input pos" id="sendcode">
                    <label for="veri-code">输入验证码</label>
                    <input type="number" id="veri-code" name="userVerificationCode" onfocus="checkIsNull()">
                    <a href="javascript:;" class="send">发送验证码</a>
                    <span class="time hide"><em>120</em>s</span>
                    <span class="error hide"><em></em><i class="icon-warn" style="margin-left: 5px"></i></span>
                </p>
                <p class="p-input pos hide" id="pwd">
                    <label for="passport">输入密码</label>
                    <input type="password" style="display: none" />
                    <input type="password" id="passport" name="upassword" />
                    <span class="tel-warn pwd-err hide"><em></em><i class="icon-warn" style="margin-left: 5px"></i></span>
                </p>
                <p class="p-input pos hide" id="confirmpwd">
                    <label for="passport2">确认密码</label>
                    <input type="password" style="position:absolute;top:-998px"/>
                    <input type="password" id="passport2">
                    <span class="tel-warn confirmpwd-err hide"><em></em><i class="icon-warn" style="margin-left: 5px"></i></span>
                </p>

            <div class="reg_checkboxline pos">
                <span class="z"><i class="icon-ok-sign boxcol" nullmsg="请同意!"></i></span>
                <input type="hidden" name="agree" value="1">
                <div class="Validform_checktip"></div>
                <p>我已阅读并接受 <a href="#" target="_brack">《天地物流协议说明》</a></p>
            </div>
            <button class="lang-btn off log-btn" type="button" id="nextStep" onclick="isVerificationCode()">下一步</button>
            <button class="lang-btn" id="register" type="submit" style="display: none;">注册</button>
            <div class="bottom-info">已有账号，<a href="${ctx}/user/toUserLogin">马上登录</a></div>
            </form>
            <div class="third-party" style="display: none;"><!--onclick="sendVerificationCode()"-->
                <a href="#" class="log-qq icon-qq-round"></a>
                <a href="#" class="log-qq icon-weixin"></a>
                <a href="#" class="log-qq icon-sina1"></a>
            </div>
            <p class="right">天地物流 © 2019</p>
        </div>
    </div>
</div>
<script src="../../../js/jquery.js"></script>
<script src="../../../js/agree.js"></script>
</body>
</html>
