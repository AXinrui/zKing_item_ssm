<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/5/6
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta charset="utf-8" />
    <title>天地物流有限公司 - 用户中心 - 完善信息</title>
    <%@include file="/common/head.jsp"%>
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
            <a class="navbar-brand" href="index.html"><img src="${ctx}/static/images/logo.png"></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li class="active">
                    <a href="${ctx}/zking/zking.shtml">网站首页</a>
                </li>
                <li>
                    <a href="${ctx}/notice/aboutUs?nid=18">关于我们</a>
                </li>
                <li>
                    <a href="${ctx}/express/toOrderOnline">在线下单</a>
                </li>
                <li>
                    <a href="${ctx}/notice/loadService?nid=1">业务范围</a>
                </li>
                <li>
                    <a href="${ctx}/notice/loadService?nid=1">新闻资讯</a>
                </li>
                <li>
                    <a href="${ctx}/contactUs">联系我们</a>
                </li>
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
            <li><a href="${ctx}/aboutUs?nid=${n.nid}">用户信息</a></li>
            <li><a href="${ctx}/aboutUs?nid=${n.nid}">完善个人信息</a></li>
            <li><a href="${ctx}/aboutUs?nid=${n.nid}">修改密码</a></li>
            <li><a href="${ctx}/aboutUs?nid=${n.nid}">退出登录</a></li>
            <li><a href="${ctx}/aboutUs?nid=${n.nid}">账号注销</a></li>
        </ul>
        <div class="tit-ol">
            <p>用户钱包</p>
        </div>
        <ul>
            <c:if test="${sessionScope.user.pid == null}">
                <li>
                    <a href="${ctx}/express/toOrderOnline">
                        开通钱包
                    </a>
                </li>
            </c:if>
            <c:if test="${sessionScope.user.pid != null}">
                <li>
                    <a href="${ctx}/express/toOrderOnline">
                        账户余额
                    </a>
                </li>
                <li>
                    <a href="${ctx}/notice/listProblem">
                        更改交易密码
                    </a>
                </li>
            </c:if>
        </ul>
        <div class="tit-co">
            <p>我的物流</p>
        </div>
        <ul>
            <li><a href="contact.html">寄出包裹</a></li>
            <li><a href="contact.html">我的包裹</a></li>
            <li><a href="contact.html">编辑地址</a></li>
        </ul>
    </div>

    <form action="${ctx}/user/updateUser" method="post">
    <div class="col-sm-9 introduce">
        <section class="title">
            <h1>
                用户中心
                <span>完善个人信息</span>
            </h1>
        </section>
        <div class="contact con-pad">
            <div class="address">
                <p>用户账号：${sessionScope.user.uaccount}</p>
                <p>用户昵称：
                    <input type="text" value="${sessionScope.user.uname}" name="uname" />
                </p>
                <P>我的地址：
                    <c:if test="${sessionScope.user.uaddress != null}">
                        ${sessionScope.user.uaddress}
                    </c:if>
                    <c:if test="${sessionScope.user.uaddress == null}">
                        <a href="#">编辑地址</a>
                    </c:if>
                </P>
                <P>用户身份：
                    <c:if test="${sessionScope.user.iid == 1}">
                        普通用户
                    </c:if>
                    <c:if test="${sessionScope.user.iid == 2}">
                        物流派送员
                    </c:if>
                </P>
            </div>
        </div>
    </div>
    </form>

</div>

<footer>
    <div class="container">
        <ul class="foot-nav clearfix">
            <li><a href="${ctx}/zking/zking.shtml">网站首页</a></li>
            <li><a href="${ctx}/notice/aboutUs?nid=18">关于我们</a></li>
            <li><a href="${ctx}/express/toOrderOnline">在线下单</a></li>
            <li><a href="${ctx}/notice/loadService?nid=1">业务范围</a></li>
            <li><a href="${ctx}/notice/loadNews?nid=7">新闻资讯</a></li>
            <li><a href="${ctx}/contactUs">联系我们</a></li>
        </ul>
        <p class="cpr">
            Copyright © 2009-2011,All rights reserved 更多模板：<a href="http://www.mycodes.net/" target="_blank">源码之家</a>
        </p>
    </div>
</footer>
<script src="${ctx}/static/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${ctx}/static/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${ctx}/static/js/main.js" type="text/javascript" charset="utf-8"></script>
</body>

</html>
