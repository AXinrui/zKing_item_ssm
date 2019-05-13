<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/5/4
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>找回密码</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta name="Keywords" content="网站关键词">
    <meta name="Description" content="网站介绍">
    <link rel="stylesheet" href="../../../css/base.css">
    <link rel="stylesheet" href="../../../css/iconfont.css">
    <link rel="stylesheet" href="../../../css/reg.css">
    <%@include file="/common/head.jsp"%>

    <script type="text/javascript">

        function myfa() {
            document.getElementById("tel").value = document.getElementById("pc_tel").value;
        }

        function buttonTransformation() {
            document.getElementById("nextStep").style.display = "none";
            document.getElementById("register").style.display = "block";
            document.getElementById("p_one").className = "p-input pos code pc-code";
            document.getElementById("p_two").className = "p-input pos code pc-code";
            document.getElementById("p_three").className = "p-input pos";
            document.getElementById("p_four").className = "p-input pos";
        }

        function isVerificationCode() {
            //定义json对象
            var userVerificationCode = $("#veri-code").val();
            //alert(userVerificationCode);
            var json = {
                "userVerificationCode" : userVerificationCode
            };

            // Jquery Ajax请求
            $.ajax({
                url : "user/isVerificationCodeLogin",
                type : "POST",
                async : true,
                data : json,
                dataType : 'json',
                success : function(data) {
                    if(data == "1"){
                        buttonTransformation();
                    }else{
                        alert("验证码错误,请重新输入!");
                    }
                }
            });
        }

        function isPassword() {
            var newPassword = document.getElementById("newPassword").value;
            var rePassword = document.getElementById("rePassword").value;
            if(newPassword != rePassword){
                alert("俩次密码输入不一致");
            }
        }

    </script>

</head>
<body>
<div id="ajax-hook"></div>
<div class="wrap">
    <div class="wpn">
        <div class="form-data find_password">
            <h4>找回密码</h4>
            <p class="right_now">已有账号，<a href="${ctx}/user/toUserLogin">马上登录</a></p>
            <form action="${ctx}/user/userRetrieve" method="post">
                <p class="p-input pos" id="p_one">
                    <label for="pc_tel">手机号</label>
                    <input type="text" id="pc_tel" name="uaccount"  onchange="myfa()"/>
                    <input type="hidden" id="tel"/>
                    <span class="tel-warn pc_tel-err hide"><em>最多五个字</em><i class="icon-warn"></i></span>
                </p>
                <p class="p-input pos" id="p_two">
                    <label for="veri-code">输入验证码</label>
                    <input type="number" id="veri-code">
                    <a href="javascript:;" class="send">发送验证码</a>
                    <span class="time hide"><em>120</em>s</span>
                    <span class="tel-warn error hide"><em>验证码错误，请重新输入</em><i class="icon-warn"></i></span>
                </p>
                <p class="p-input pos code pc-code" id="p_three">
                    <label for="veri">新密码</label>
                    <input type="text" id="newPassword">
                    <img src="">
                    <span class="tel-warn img-err hide"><em>最多五个字</em><i class="icon-warn"></i></span>
                    <!-- <a href="javascript:;">换一换</a> -->
                </p>
                <p class="p-input pos code pc-code" id="p_four">
                    <label for="veri">确认密码</label>
                    <input type="text" id="rePassword" name="upassword" onchange="isPassword()">
                    <img src="">
                    <span class="tel-warn img-err hide"><em>最多五个字</em><i class="icon-warn"></i></span>
                    <!-- <a href="javascript:;">换一换</a> -->
                </p>
                <button class="lang-btn" id="register" type="submit" style="display: none;">确认</button>
            </form>
            <button class="lang-btn next" id="nextStep" onclick="isVerificationCode()">下一步</button>
            <p class="right">天地物流 © 2019</p>

        </div>
    </div>
</div>
<script src="../../../js/jquery.js"></script>
<script src="../../../js/agree.js"></script>
<script src="../../../js/reset.js"></script>
</body>
</html>
