<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/5/6
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta charset="utf-8" />
    <title>天地物流有限公司 - 待付款包裹</title>
    <%@include file="/common/head.jsp"%>
    <%@taglib prefix="z" uri="/zking" %>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/main.css" />
    <style>

        #tableA,#tableB td:hover{
            background-color: silver;
        }

        #tableA td{
            width: 16.7%;
            height: 25px;
        }

        #tableB td{
            width: 33.3%;
        }

        .td_num{
            font-size: 14px;
        }

    </style>

    <script type="text/javascript">

        //弹出新的浏览器打开页面
        // function openwin() {
        //     window.open ("zking/new.jsp", "newwindow", "height=100, width=400, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no");
        // }

        var password = "";

        function passwordSplicing(num) {
            //alert("num:"+num);

            if(password.length < 6){
                if(num == "删除"){
                    //alert("删除");
                    var pwdLength1 = password.length - 1;
                    password = password.substring(0,pwdLength1);
                    //alert("用户输入长度："+pwdLength1+",密码:"+password);
                    var pwdLength2 = password.length;
                    passwordTransformation(pwdLength2);
                }else{
                    password = password + num;
                    var pwdLength = password.length;
                    passwordTransformation(pwdLength);
                }
            }

            if(password.length == 6){
                isPassword();
            }
        }

        function passwordTransformation(length) {
            for (var i = 1; i <= 6; i++){
                document.getElementById("td_transformation"+i).innerHTML = "";
            }
            for (var i = 1; i <= length; i++){
                document.getElementById("td_transformation"+i).innerHTML = "*";
            }
        }

        function isPassword() {
            alert("判断密码");
            var userPaymentPassword = document.getElementById("userPaymentPassword").value;
            if(password == userPaymentPassword){
                if(document.getElementById("price").value > document.getElementById("balance").value){
                    alert("余额不足，请充值");
                    location.href = "/express/toBalanceInsufficient";
                }else{
                    var price = document.getElementById("price").value;
                    alert("用户需支付运单费人民币："+price);
                    //定义json对象
                    var eid = $("#eid").val();
                    alert("eid:"+eid);
                    var json = {
                        "eid" : eid,
                        "price":price
                    };

                    // Jquery Ajax请求
                    $.ajax({
                        url : "express/pendingPayment",
                        type : "POST",
                        async : true,
                        data : json,
                        dataType : 'json',
                        success : function(data) {
                            if(data == "1"){
                                alert("支付成功！");
                                var uid = document.getElementById("uid").value;
                                location.href='/express/myLogistics?esid=1&uid='+uid;
                            }else{
                                alert("支付失败!");
                            }
                        }
                    });
                }
            }else{
                alert("支付密码输入错误，请重新输入");
                password = "";
                passwordTransformation(0);
            }
        }

        function assignment(eid,price) {
            document.getElementById("eid").value = eid;
            document.getElementById("price").value = price;
        }


    </script>
</head>

<body>
<nav class="navbar navbar-default">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${ctx}/zking/zking.shtml"><img src="${ctx}/static/images/logo.png"></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li class="active">
                    <a href="${ctx}/zking/zking.shtml">网站首页</a>
                </li>
                <li>
                    <a href="${ctx}/express/toOrderOnline">在线下单</a>
                </li>
                <li>
                    <a href="${ctx}/notice/loadService?nid=1">业务范围</a>
                </li>
                <li>
                    <a href="${ctx}/notice/listNews">新闻资讯</a>
                </li>
                <li>
                    <a href="${ctx}/contactUs">联系我们</a>
                </li>
                <li>
                    <a href="${ctx}/notice/aboutUs?nid=18">关于我们</a>
                </li>
                <c:if test="${not empty user}">
                    <li><a href="${ctx}/user/toUserCenter">个人中心</a></li>
                </c:if>
                <c:if test="${empty user}">
                    <li><a href="${ctx}/user/toUserLogin">登录</a></li>
                </c:if>
            </ul>

        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>

<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img src="${ctx}/static/images/banner/banner1.jpg" >
        </div>
        <div class="item">
            <img src="${ctx}/static/images/banner/banner2.jpg" >
        </div>
        <div class="item">
            <img src="${ctx}/static/images/banner/banner3.jpg" >
        </div>
    </div>

    <!-- Controls -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

<!--aboupg-->
<div class="sec aboutpg container">
    <div class="pg-nav col-sm-3">
        <div class="tit-ab">
            <p>用户操作</p>
        </div>
        <ul>
            <li><a href="${ctx}/user/toUserCenter">用户信息</a></li>
            <li><a href="${ctx}/user/toPerfectInformaction">完善个人信息</a></li>
            <li><a href="${ctx}/user/toChangePassword">修改密码</a></li>
            <li><a href="${ctx}/user/userExit">退出登录</a></li>
            <li><a href="" onclick="Cancellation()">账号注销</a></li>
            <input type="hidden" id="uid" value="${sessionScope.user.uid}" />
            <%--${ctx}/user/Cancellation?uid=${sessionScope.user.uid}--%>
        </ul>
        <div class="tit-ol">
            <p>用户钱包</p>
        </div>
        <ul>
            <c:if test="${sessionScope.user.pid == null}">
                <li>
                    <a href="${ctx}/property/toOpenWallet">
                        开通钱包
                    </a>
                </li>
            </c:if>
            <c:if test="${sessionScope.user.pid != null}">
                <li>
                    <a href="${ctx}/property/toAccountBalance?pid=${sessionScope.user.pid}">
                        账户余额
                    </a>
                </li>
                <li>
                    <a href="${ctx}/property/toChangeTheTransactionPassword?pid=${sessionScope.user.pid}">
                        更改交易密码
                    </a>
                </li>
                <li>
                    <a href="${ctx}/property/toRecharge?pid=${sessionScope.user.pid}">
                        账户充值
                    </a>
                </li>
            </c:if>
        </ul>
        <div class="tit-co">
            <p>我的物流</p>
        </div>
        <ul>
            <li><a href="${ctx}/express/myLogistics?esid=7&uid=${sessionScope.user.uid}">待付款包裹</a></li>
            <li><a href="${ctx}/express/myLogistics?esid=1&uid=${sessionScope.user.uid}">派送中包裹</a></li>
            <li><a href="${ctx}/express/myLogistics?esid=5&uid=${sessionScope.user.uid}">已签收包裹</a></li>
        </ul>
    </div>
    <div class="col-sm-9 introduce">
        <section class="title">
            <h1>
                我的物流
                <span>待付款包裹</span>
                <input type="hidden" id="userPaymentPassword" value="${sessionScope.user.property.ppwd}" />
                <input type="hidden" id="balance" value="${sessionScope.user.property.pbalance}" />
                <input type="hidden" id="uid" value="${sessionScope.user.uid}" />
            </h1>
        </section>
        <div class="contact con-pad">
            <div id="message" class="row">

                <c:if test="${not empty expressList}">
                    <table class="table table-hover">
                        <thead>
                        <th>订单号</th>
                        <th>货物名</th>
                        <th>运单费(元)</th>
                        <th>发货人</th>
                        <th>收货人</th>
                        <th>收货人手机</th>
                        <th>操作</th>
                        </thead>

                        <c:forEach items="${expressList}" var="e">
                            <tr>
                                <td>${e.orderid}</td>
                                <td>${e.ordername}</td>
                                <td>${e.orderprice}</td>
                                <td>${e.shipper}</td>
                                <td>${e.consignee}</td>
                                <td>${e.consigneephone}</td>
                                <td>
                                    <a href="#" style="margin-right: 10px;"   title="立刻支付" onclick="assignment(${e.eid},${e.orderprice})"  data-dismiss="modal" data-toggle="modal" data-target="#drd"><input type="button" value="付款" style="background-color: green; font-size: 12px; color: #fff; width: 86px; height: 37px; border: none; cursor: pointer; border: 0px;text-align: center;" /></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <div style="position: absolute;left: 400px;top: 420px;">
                        <z:page pageBean="${pageBean}"/>
                    </div>

                </c:if>


                <c:if test="${empty expressList}">
                    <h1>暂无更多订单哦!</h1>
                </c:if>

            </div>
        </div>
    </div>
</div>

<footer>
    <div class="container">
        <ul class="foot-nav clearfix">
            <li><a href="${ctx}/zking/zking.shtml">网站首页</a></li>
            <li><a href="${ctx}/express/toOrderOnline">在线下单</a></li>
            <li><a href="${ctx}/notice/loadService?nid=1">业务范围</a></li>
            <li><a href="${ctx}/notice/listNews">新闻资讯</a></li>
            <li><a href="${ctx}/contactUs">联系我们</a></li>
            <li><a href="${ctx}/notice/aboutUs?nid=18">关于我们</a></li>
            <c:if test="${not empty user}">
                <li><a href="${ctx}/user/toUserCenter">个人中心</a></li>
            </c:if>
        </ul>
        <p class="cpr" style="display: none;">
            Copyright © 2009-2011,All rights reserved 更多模板：<a href="http://www.mycodes.net/" target="_blank">源码之家</a>
        </p>
    </div>
</footer>
<div class="fl">
    <ul>
        <li><a href="tel:15995656015">电话咨询</a></li>
        <li><a href="${ctx}/zking/zking.shtml">网站首页</a></li>
        <li><a href="${ctx}/solution">在线留言</a></li>
    </ul>
</div>


<div class="modal fade" data-backdrop="false" id="drd" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">天地支付</div>
            <input type="hidden" id="eid" />
            <input type="hidden" id="price" />
            <div class="modal-body">
                <table class="table">
                    <tr>
                        <td>
                            <table class="table" border="1" id="tableA"  style="text-align: center;font-size: 16px;">
                                <tr>
                                    <td id="td_transformation1"></td>
                                    <td id="td_transformation2"></td>
                                    <td id="td_transformation3"></td>
                                    <td id="td_transformation4"></td>
                                    <td id="td_transformation5"></td>
                                    <td id="td_transformation6"></td>
                                </tr>
                            </table>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <table class="table" border="1" id="tableB"  style="text-align: center;">
                                <tr>
                                    <td class="td_num" onclick="passwordSplicing('1')">1</td>
                                    <td class="td_num" onclick="passwordSplicing('2')">2</td>
                                    <td class="td_num" onclick="passwordSplicing('3')">3</td>
                                </tr>
                                <tr>
                                    <td class="td_num" onclick="passwordSplicing('4')">4</td>
                                    <td class="td_num" onclick="passwordSplicing('5')">5</td>
                                    <td class="td_num" onclick="passwordSplicing('6')">6</td>
                                </tr>
                                <tr>
                                    <td class="td_num" onclick="passwordSplicing('7')">7</td>
                                    <td class="td_num" onclick="passwordSplicing('8')">8</td>
                                    <td class="td_num" onclick="passwordSplicing('9')">9</td>
                                </tr>
                                <tr>
                                    <td data-dismiss="modal">取消</td>
                                    <td  class="td_num" onclick="passwordSplicing('0')">0</td>
                                    <td onclick="passwordSplicing('删除')">删除</td>
                                </tr>
                            </table>
                        </td>
                    </tr>

                </table>

            </div>

        </div>
    </div>
</div>

<script src="${ctx}/static/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${ctx}/static/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${ctx}/static/js/main.js" type="text/javascript" charset="utf-8"></script>
</body>

</html>
