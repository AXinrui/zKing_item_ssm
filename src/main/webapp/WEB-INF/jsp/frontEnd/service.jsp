<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/5/6se'r
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta charset="utf-8" />
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
                <li class="active">
                    <a href="service.html">业务范围</a>
                </li>
                <li>
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
            <p>业务范围</p>
        </div>
        <ul>

            <c:forEach items="${listNotice}" var="n">
                <c:if test="${n.dictItem == '服务介绍'}">
                    <li><a href="${ctx}/notice/loadService?nid=${n.nid}">${n.nname}</a></li>
                </c:if>
            </c:forEach>

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
                ${notice.nname}
                <span>天地物流</span>
            </h1>
        </section>
        <div class="ser-con con-pad">
            ${notice.ncontent}
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

</html><!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta charset="utf-8" />
    <title>苏州安曙达物流有限公司</title>
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
                <li class="active">
                    <a href="service.html">业务范围</a>
                </li>
                <li>
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
            <p>业务范围</p>
        </div>
        <ul>
            <c:forEach items="${listNotice}" var="n">
                <c:if test="${n.dictItem == '服务介绍'}">
                    <li><a href="${ctx}/notice/loadService?nid=${n.nid}">${n.nname}</a></li>
                </c:if>
            </c:forEach>
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
                物流卡航
                <span>LOGISTICS CAR NAVIGATION</span>
            </h1>
        </section>
        <div class="ser-con con-pad">
            <p>物流卡航是某某物流业内首创的极具优势的业务之一，“快速、安全、服务、经济”，能够克服很多城市因缺乏大机型直飞造成货物延误的困难，线路覆盖全国超过2920个城市，为客户提供全国覆盖面最广的专业公路快运服务。</p>
            <h2>时效保证</h2>
            <p>定点、定时发车，可迅速连接华南、华东、西北、西南、东北等国内各大区域，1500公里内可达到空运速度，超过1500公里可达到市场领先的速度，确保速度和稳定性；</p>
            <h2>安全保障</h2>
            <p> 配备VOLVO/SCANIA等全封闭厢式货车，提供在途可视化的信息化管理，配备GPS全球定位，多种形式实现全程货物跟踪，使您随时随地掌握货物在途信息；</p>
            <h2>全面服务</h2>
            <p>可提供门到门、港到港、异地调拨、区域配送、逆向物流、签收单返回等全方位增值服务；贴心客服跟进运作流程，及时反馈给客户，能够快速处理客户各种个性化需求；</p>
            <h2>性价比高</h2>
            <p>汽运的价格，空运的速度，性价比高。</p>
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
