<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/9
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../../common/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0052)http://api.map.baidu.com/lbsapi/createmap/index.html -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="generator" content="HTML Tidy for Windows (vers 14 February 2006), see www.w3.org">

    <meta name="generator" content="MediaWiki 1.16.1">
    <meta http-equiv="x-ua-compatible" content="ie=7">
    <title>地图-百度地图</title>
    <meta name="keywords" content="地图生成器">
    <link rel="search" type="application/opensearchdescription+xml" href="http://api.map.baidu.com/wiki/map/opensearch_desc.php" title="地图开放平台 (zh-hans)">
    <link rel="alternate" type="application/atom+xml" title="地图开放平台的Atom订阅" href="http://api.map.baidu.com/wiki/map/index.php?title=%E7%89%B9%E6%AE%8A:%E6%9C%80%E8%BF%91%E6%9B%B4%E6%94%B9&amp;feed=atom">
    <link rel="stylesheet" href="${ctx}/static/map/files/style.css" type="text/css">
    <link rel="shortcut icon" href="http://lbsyun.baidu.com/skins/MySkin/resources/img/icon/lbsyunlogo_icon.ico">
</head>

<body style="background-color:#fff;" >
<!--头部区域-->

<!--头部区域 end-->

<!--主体部分-->
<div class="draw_map l" style="float:none;padding-left:100px;" >
    <div class="nav l" >
        <ul>
            <li>
                <div class="list-item current">&nbsp;1. 定位中心点</div>
                <div id="set_center" class="l mt-10 show">
                    <div id="setCity" style="height:26px;">
                        <div class="show">当前城市：
                            <span id="current_city">北京市</span>
                            <span style="color:#2f83c7; cursor:pointer;" id="change_city" onclick="setCity()"> 切换</span>
                        </div>
                        <div class="hidden">
                            <input id="input_city" type="text" placeholder="请输入城市名称" style="width: 115px" onclick="this.value" onkeyup="citynameKeyUp()">
                            <span class="btn_blue" onclick="confirmCity()">确定</span>
                            <span class="btn_blue" onclick="exitSetCity()">取消</span>
                        </div>
                    </div>

                    <input id="input_site" type="text"  placeholder="输入地名、大厦快速定位" onclick="this.value" onkeyup="siteKeyUp()" style="width:165px">
                    <span class="btn_blue" onclick="searchLocation()">查找</span>
                    <p>当前地图中心点经纬度：</p>
                    <div style="margin-bottom:10px;">
                        <label class="l" style="line-height:22px">X：</label>
                        <div id="input_x" style="line-height:20px; width: 110px;display:block; margin-left:30px">116.302114</div>
                    </div>
                    <div style="margin-bottom:10px;">
                        <label class="l" style="line-height:22px">Y：</label>
                        <div id="input_y" style="line-height:20px; width: 110px;margin-left: 30px;">39.758427</div>
                    </div>
                    <div>
                        <label class="l" style="line-height:22px">当前地图级别：</label>
                        <div id="input_zoom" style="line-height:20px; width: 20px;border:solid 1px #626262;background:#eee;margin-left: 90px;">11</div>
                    </div>
                </div>

            </li>

        </ul>
    </div>
    <div id = "map_container" class = "map l" style = "margin-bottom: 10px">
    </div>
</div>


<script type="text/javascript" src="${ctx}/static/map/files/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${ctx}/static/map/files/api" ></script>
<script type="text/javascript" src="${ctx}/static/map/files/getscript"></script>
<script type="text/javascript" src="${ctx}/static/map/files/mapConfig.js"></script>
<script type="text/javascript" src="${ctx}/static/map/files/main.js"></script>
<script type="text/javascript" src="${ctx}/static/map/files/mapSettings.js"></script>
<script type="text/javascript" src="${ctx}/static/map/files/getCode.js"></script>
<script type="text/javascript" src="${ctx}/static/map/files/ZeroClipboard.js"></script></body></html>
