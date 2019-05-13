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
    <title>天地物流有限公司 - 派送中包裹</title>
    <%@include file="/common/head.jsp"%>
    <%@taglib prefix="z" uri="/zking" %>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/main.css" />
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
                <span>派送中包裹</span>
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
                        <th>发货时间</th>
                        <th>收货人</th>
                        <th>状态</th>
                        <th>操作</th>
                        </thead>

                        <c:forEach items="${expressList}" var="e">
                            <tr>
                                <td>${e.orderid}</td>
                                <td>${e.ordername}</td>
                                <td>${e.orderprice}</td>
                                <td>${e.shipper}</td>
                                <td><fmt:formatDate value="${e.shippertime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                                <td>${e.consignee}</td>
                                <td>
                                    <c:if test="${e.esid == 1}">
                                        等待物流公司确认
                                    </c:if>
                                    <c:if test="${e.esid == 2}">
                                        等待物流公司揽件
                                    </c:if>
                                    <c:if test="${e.esid == 3}">
                                        快递运输中
                                    </c:if>
                                    <c:if test="${e.esid == 4}">
                                        等待收件人签收
                                    </c:if>
                                    <c:if test="${e.esid == 6}">
                                        快递员派送中
                                    </c:if>
                                </td>
                                <td>
                                    <input type="button" value="查看" style="background-color: green; font-size: 12px; color: #fff; width: 86px; height: 37px; border: none; cursor: pointer; border: 0px;text-align: center;" />
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
<script src="${ctx}/static/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${ctx}/static/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${ctx}/static/js/main.js" type="text/javascript" charset="utf-8"></script>
</body>

</html>
