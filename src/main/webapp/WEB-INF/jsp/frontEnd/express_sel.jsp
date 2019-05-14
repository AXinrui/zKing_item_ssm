<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/13
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta charset="utf-8" />
    <title>天地物流有限公司 - 联系我们</title>
    <%@include file="/common/head.jsp"%>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/main.css" />
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=VSGsIrmPywwMEGMHufAAnbmHBShaYQcz"></script>
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
            <p>联系我们</p>
        </div>
        <ul>
            <li><a href="${ctx}/contactUs">联系我们</a></li>
            <li><a href="${ctx}/solution">在线留言</a></li>
        </ul>
        <div class="tit-ol">
            <p>在线下单</p>
        </div>
        <ul>
            <li>
                <a href="${ctx}/express/toOrderOnline">
                    立即下单
                </a>
            </li>
            <li>
                <a href="${ctx}/notice/listProblem">
                    常见问题
                </a>
            </li>
        </ul>
    </div>
    <div class="col-sm-9 introduce">
        <section class="title">
            <h1>
                运单查询
                <span>Waybill query</span>
            </h1>
        </section>
        <div class="contact con-pad">
            <div id="message" class="row">
                <form>
                    <div class="col-sm-push-4" style="white-space:nowrap;margin-top: -50px;" >
                        <input style="width: 700px;" type="text" placeholder="请输入快递单号或者电话号码" id="content"  />
                            <input type="button" onclick="selectContent()" value="立即查询" />
                    </div>
                </form>
                <div><span id="address" ></span></div>
            </div>
            <div id="allmap" style="width: 100%;height: 500px;margin-top: 10px;margin-left: -12px;" ></div>
        </div>
    </div>
</div>

<script>
    //查询
    function selectContent() {
        var content =   document.getElementById("content").value;
        if(""!=content&&null!=content){
            $.ajax({
                url : "express/expressSelect?orderid="+content,
                type :"GET",
                success : function(data) {
                    if(data!=null){
                        doditu(data);
                    }
                }
            });
        }else{
            alert("请输入内容！");
        }
    }
    
    function doditu(data) {

        // 百度地图API功能
        var map = new BMap.Map("allmap");
        map.centerAndZoom(new BMap.Point(113.135488, 29.363177), 11)

        var   expressSites  = data[0].expressSites;

        var sitesAry  = new Array();

        if(data!=null){
            for(var i = 0;i<expressSites.length;i++){
                sitesAry.push(new BMap.Point(expressSites[i].x,expressSites[i].y));
            }
        }

        map.enableScrollWheelZoom(true);
        // var p1 = new BMap.Point(112.94547,28.23489);getAddress
        var p1 = getAddress(data[0].shipperaddress);
        var p2 =getAddress(data[0].consigneeaddress);

        map.centerAndZoom(sitesAry[sitesAry.length-1], 5);
        var marker = new BMap.Marker(sitesAry[sitesAry.length-1]);  // 创建标注
        map.addOverlay(marker);               // 将标注添加到地图中
        marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
        var driving = new BMap.DrivingRoute(map, {renderOptions:{map: map, autoViewport: true}});
        driving.search(p1, p2,{waypoints:sitesAry});//waypoints表示途经点

         document.getElementById("address").innerText="订单状态："+ data[0].expressStatus.esname+"订单当前位置："+data[0].express.orderaddress;

    }

    function getAddress(address) {
        var dd = null;
        if(address != null){
            //alert(shipperaddress);
            var json = {
                "address" : address
            };
            // Jquery Ajax请求
            $.ajax({
                url : "express/getLongitudeAndLatitude",
                type : "POST",
                async : false,
                data : json,
                dataType : 'json',
                /*xhrFields: {
                    withCredentials: true // 设置运行跨域操作
                },*/
                success : function(data) {
                    var longitudeAndLatitudes = eval(data);
                    shipperaddressLng = longitudeAndLatitudes.result.location.lng;
                    shipperaddressLat = longitudeAndLatitudes.result.location.lat;
                    //newaddress = address;
                    // isDistance();
                    dd =  new BMap.Point(shipperaddressLng,shipperaddressLat);
                }
            });
        }
        return dd;
    }

</script>

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
