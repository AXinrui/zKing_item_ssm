<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/5/6
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <title>天地物流有限公司</title>
    <%@include file="/common/head.jsp"%>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" type="text/css" href="static/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="static/css/main.css" />
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
            <a class="navbar-brand" href="index.html"><img src="static/images/logo.png"></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="index.html">网站首页</a>
                </li>
                <li>
                    <a href="about.html">关于我们</a>
                </li>
                <li>
                    <a href="online.html">在线下单</a>
                </li>
                <li>
                    <a href="service.html">业务范围</a>
                </li>
                <li class="active">
                    <a href="news.html">新闻资讯</a>
                </li>
                <li>
                    <a href="contact.html">联系我们</a>
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
            <img src="static/images/banner/banner1.jpg" >
        </div>
        <div class="item">
            <img src="static/images/banner/banner2.jpg" >
        </div>
        <div class="item">
            <img src="static/images/banner/banner3.jpg" >
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
            <p>新闻资讯</p>
        </div>
        <ul>
            <li><a href="news.html">新闻中心</a></li>
        </ul>
        <div class="tit-ol">
            <p>在线下单</p>
        </div>
        <ul>
            <li><a href="online.html">立即下单</a></li>
            <li><a href="problem.html">常见问题</a></li>
        </ul>
        <div class="tit-co">
            <p>联系我们</p>
        </div>
        <ul>
            <li><a href="contact.html">在线留言</a></li>
        </ul>
    </div>
    <div class="col-sm-9">
        <section class="title">
            <h1>
                新闻中心
                <span>NEWS CENTER</span>
            </h1>
        </section>
        <div class="news-detail con-pad">
            <h1>国家邮政局发通告要求严格落实收寄验视制度</h1>
            <p>发布时间：2017-7-13</p>
            <div>
                <p>
                    新华网北京8月1日电国家邮政局近日会同公安部、国家安全部联合发出通告，要求切实维护南京青奥会期间的寄递物品安全，严格落实收寄验视制度.
                </p>
                <p>
                    《通告》要求邮政企业、快递企业严格执行关于禁止、限制寄递物品的规定，严格落实收寄验视制度。对用户交寄的除信件以外的邮件、快件，寄递企业要当面验视内件，确认安全并加盖收寄验视戳记后方可收寄；对国家明令禁止寄递的物品、不能确认安全的物品（如不明机电装置、粉末、装有不明气体或液体的密闭装置等）或用户拒绝验视的，寄递企业不予收寄。
                </p>
                <p>
                    《通告》要求，在南京青奥会期间，寄递企业对寄往南京的邮件、快件，应要求用户出示有效身份证件，认真登记寄递物品、收件人和寄件人信息。对未出示有效身份证件的，要重点查验，确认安全后方可收寄。
                </p>
                <p>
                    按照有关规定，南京青奥会期间，未经南京青奥会组委会专门许可，寄递企业不得进入运动员村、总部酒店、比赛场馆、媒体中心等涉奥场所从事寄递服务。对发往涉奥场所的邮件、快件，寄递企业应交由邮政管理、公安、国家安全等部门指定的地点统一签收分发。
                </p>
                <p>
                    《通告》要求各级邮政管理部门加大对寄递市场的监管力度，依法查处无证经营、超范围经营和不执行收寄验视制度等违反《邮政法》的行为；各级公安、国家安全机关要严厉打击利用寄递渠道从事危害国家安全、公共安全和社会政治稳定的违法犯罪行为。
                </p>
            </div>
            <nav>
                <ul class="pager">
                    <li class="previous">
                        <a href="javascript:void(0);">上一篇：没有了</a>
                    </li>
                    <li class="next">
                        <a href="news-detail2.html">下一篇：快递集团恭祝全国人民佳节愉快</a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</div>

<footer>
    <div class="container">
        <ul class="foot-nav clearfix">
            <li><a href="index.html">网站首页</a></li>
            <li><a href="about.html">关于我们</a></li>
            <li><a href="online.html">在线下单</a></li>
            <li><a href="service.html">业务范围</a></li>
            <li><a href="news.html">新闻资讯</a></li>
            <li><a href="contact.html">联系我们</a></li>
        </ul>
        <p class="cpr">
            Copyright © 2009-2011,All rights reserved 更多模板：<a href="http://www.mycodes.net/" target="_blank">源码之家</a>
        </p>
    </div>
</footer>
<div class="fl">
    <ul>
        <li><a href="tel:15995656015">电话咨询</a></li>
        <li><a href="index.html">网站首页</a></li>
        <li><a href="">在线留言</a></li>
    </ul>
</div>
<script src="static/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="static/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<script src="static/js/main.js" type="text/javascript" charset="utf-8"></script>
</body>

</html>
