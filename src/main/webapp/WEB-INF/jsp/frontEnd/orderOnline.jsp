<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/5/7
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta charset="utf-8" />
    <title>天地物流有限公司 - 在线下单</title>
    <%@include file="/common/head.jsp"%>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/main.css" />
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=VSGsIrmPywwMEGMHufAAnbmHBShaYQcz"></script>
    <script type="text/javascript">

        var shipperaddressLng;
        var shipperaddressLat;

        var consigneeAddressLng;
        var consigneeAddressLat;

        var newaddress;

        function getLongitudeAndLatitudeShipperaddress(shipperaddress) {
            if(shipperaddress != null){
                //alert(shipperaddress);
                var json = {
                    "address" : shipperaddress
                };

                // Jquery Ajax请求
                $.ajax({
                    url : "express/getLongitudeAndLatitude",
                    type : "POST",
                    async : true,
                    data : json,
                    dataType : 'json',
                    /*xhrFields: {
                        withCredentials: true // 设置运行跨域操作
                    },*/
                    success : function(data) {
                        var longitudeAndLatitudes = eval(data);
                        shipperaddressLng = longitudeAndLatitudes.result.location.lng;
                        shipperaddressLat = longitudeAndLatitudes.result.location.lat;
                        newaddress = shipperaddress;
                        //alert("shipperaddressLng:"+shipperaddressLng);
                        //alert("shipperaddressLat:"+shipperaddressLat);
                        isDistance();
                    }
                });
            }

        }

        function getLongitudeAndLatitudeConsigneeAddress(consigneeAddress) {
            if(consigneeAddress != null){
                //alert(consigneeAddress);
                var json = {
                    "address" : consigneeAddress
                };

                // Jquery Ajax请求
                $.ajax({
                    url : "express/getLongitudeAndLatitude",
                    type : "POST",
                    async : true,
                    data : json,
                    dataType : 'json',
                    /*xhrFields: {
                        withCredentials: true // 设置运行跨域操作
                    },*/
                    success : function(data) {
                        var longitudeAndLatitudes = eval(data);
                        consigneeAddressLng = longitudeAndLatitudes.result.location.lng;
                        consigneeAddressLat = longitudeAndLatitudes.result.location.lat;
                        //alert("consigneeAddressLng:"+consigneeAddressLng);
                        //alert("consigneeAddressLat:"+consigneeAddressLat);
                        isDistance();
                    }
                });
            }

        }

        function appendShipperaddress() {
            var address = "";

            var provinceID = $("#input_province").val();
            var cityID = $("#input_city").val();
            var areaID = $("#input_area").val();

            var province = $("#shipperaddress"+provinceID).html();
            var city = $("#shipperaddress"+cityID).html();
            var area = $("#shipperaddress"+areaID).html();

            //alert("province:"+province+"city:"+city+"area:"+area);

            if (province == "北京市" || province == "天津市" || province == "上海市" || province == "重庆市"){
                address = province + area;
            } else if (province == "香港特别行政区" || province == "澳门特别行政区" || province == "台湾省"){
                address = province;
            } else {
                address = province + city + area;
            }

            //alert(address);
            document.getElementById("shipperaddress").value = address;
            getLongitudeAndLatitudeShipperaddress(address);
            alert("shipperaddress:"+ document.getElementById("shipperaddress").value);
        }

        function appendConsigneeAddress() {
            var address = "";

            var provinceID = $("#input_province1").val();
            var cityID = $("#input_city1").val();
            var areaID = $("#input_area1").val();

            var province = $("#consigneeAddress"+provinceID).html();
            var city = $("#consigneeAddress"+cityID).html();
            var area = $("#consigneeAddress"+areaID).html();

            //alert("province:"+province+"city:"+city+"area:"+area);

            if (province == "北京市" || province == "天津市" || province == "上海市" || province == "重庆市"){
                address = province + area;
            } else if (province == "香港特别行政区" || province == "澳门特别行政区" || province == "台湾省"){
                address = province;
            } else {
                address = province + city + area;
            }

            //alert(address);
            document.getElementById("consigneeAddress").value = address;
            getLongitudeAndLatitudeConsigneeAddress(address);
            alert("consigneeAddress:"+ document.getElementById("consigneeAddress").value);
        }

        function isDistance() {
            //alert("进来判断距离了A");
            if(shipperaddressLng != null && shipperaddressLat != null && consigneeAddressLng != null && consigneeAddressLat != null){
                //alert("进来判断距离了B");
                var map = new BMap.Map("allmap");
                map.centerAndZoom(newaddress,10);  //初始化地图,设置城市和地图级别
                var pointShipperaddress = new BMap.Point(shipperaddressLng,shipperaddressLat);  // 创建发货点坐标
                var pointConsigneeAddress = new BMap.Point(consigneeAddressLng,consigneeAddressLat);  // 创建收货点坐标
                var distance = (map.getDistance(pointShipperaddress,pointConsigneeAddress)).toFixed(2);
                alert("俩地相隔："+distance+"米");  //获取两点距离,保留小数点后两位
                var polyline = new BMap.Polyline([pointShipperaddress,pointConsigneeAddress], {strokeColor:"blue", strokeWeight:6, strokeOpacity:0.5});  //定义折线
                map.addOverlay(polyline); //添加折线到地图上

                document.getElementById("distance").value = distance/1000;
                document.getElementById("freight").value = distance/1000*100;

            } else{
                //alert("进来判断距离了C");
                return;
            }
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
            <p>在线下单</p>
        </div>
        <ul>
            <li><a href="online.html">在线下单</a></li>
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
        <div class="tit-co">
            <p>联系我们</p>
        </div>
        <ul>
            <li><a href="${ctx}/solution">在线留言</a></li>
        </ul>
    </div>
    <div class="col-sm-9 introduce">
        <section class="title">
            <h1>
                在线下单
                <span>ORDER ONLINE</span>
            </h1>
        </section>

        <form action="${ctx}/express/orderOnline" method="post">

        <div class="onlinepg con-pad">
            <div>
                <p>发货人信息</p>
                <ul class="row">
                    <li class="col-sm-6 col-xs-12">
                        <p><i>*</i>发货人：</p>
                        <input type="text" name="shipper"/>
                    </li>
                    <li class="col-sm-6 col-xs-12">
                        <p><i>*</i>手机</p>
                        <input type="text" name="shipperphone"/>
                    </li>
                    <li class="col-sm-6 col-xs-12">
                        <div class="form-group">
                            <p><i>*</i>发货地址</p>
                            <%--<label class="col-sm-2 control-label"><i>*</i>所在地址</label>--%>
                            <input type="hidden" name="shipperaddress" id="shipperaddress" />
                            <div class="col-sm-3">
                                <select name="input_province" id="input_province" class="form-control" style="width: 98px;" >
                                    <option value="">--请选择--</option>
                                </select>
                            </div>
                            <div class="col-sm-3">
                                <select name="input_city" id="input_city" class="form-control" style="width: 98px;">
                                    <option value=""></option>
                                </select>
                            </div>
                            <div class="col-sm-3">
                                <select name="input_area" id="input_area" class="form-control" style="width: 98px;" onchange="appendShipperaddress()">
                                    <option value=""></option>
                                </select>
                            </div>
                        </div>

                    </li>
                </ul>
            </div>
            <div>
                <p>收货人信息</p>
                <ul class="row">
                    <li class="col-sm-6 col-xs-12">
                        <p><i>*</i>收货人：</p>
                        <input type="text" name="consignee"/>
                    </li>
                    <li class="col-sm-6 col-xs-12">
                        <p><i>*</i>手机</p>
                        <input type="text" name="consigneephone"/>
                    </li>
                    <li class="col-sm-6 col-xs-12">
                        <div class="form-group">
                            <p><i>*</i>收货地址</p>
                            <%--<label class="col-sm-2 control-label"><i>*</i>所在地址</label>--%>
                            <input type="hidden" name="consigneeaddress" id="consigneeAddress" />
                            <div class="col-sm-3">
                                <select name="input_province1" id="input_province1" class="form-control" style="width: 98px;" >
                                    <option value="">--请选择--</option>
                                </select>
                            </div>
                            <div class="col-sm-3">
                                <select name="input_city1" id="input_city1" class="form-control" style="width: 98px;">
                                    <option value=""></option>
                                </select>
                            </div>
                            <div class="col-sm-3">
                                <select name="input_area1" id="input_area1" class="form-control" style="width: 98px;" onchange="appendConsigneeAddress()">
                                    <option value=""></option>
                                </select>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
            <div>
                <p>货物信息</p>
                <ul class="row">
                    <li class="col-sm-6 col-xs-12">
                        <p><i>*</i>货物名称：</p>
                        <input type="text" name="ordername"/>
                    </li>
                    <li class="col-sm-6 col-xs-12">
                        <p>货物重量：</p>
                        <input type="text" name="orderweight"/>
                    </li>
                    <li class="col-sm-6 col-xs-12">
                        <p>货物体积：</p>
                        <input type="text" name="ordervolume"/>
                    </li>
                    <li class="sm">
                        <p>注：我们的工作人员会在接货时重新称重，此估算仅供参考。</p>
                    </li>
                </ul>
            </div>
            <div>
                <p>运费信息</p>
                <ul class="row">
                    <li class="col-sm-6 col-xs-12">
                        <p><i>*</i>距离(公里)：</p>
                        <input type="text" name="" id="distance"/>
                    </li>
                    <li class="col-sm-6 col-xs-12">
                        <p>预算费用：</p>
                        <input type="text" name="orderprice" id="freight"/>
                    </li>
                    <li class="sm">
                        <p>注：我们的工作人员会在接货时重新预测，此估算仅供参考。</p>
                    </li>
                </ul>
            </div>
            <div>
                <p>地图</p>
                <div id="allmap" style="width: 500px;height: 300px;"></div>
            </div>
            <div>
                <p>备注信息</p>
                <textarea name="orderremark"></textarea>
            </div>
            <p class="mes">注：我们的工作人员在收到发货请求会主动联系，请注意接听电话。</p>
            <input type="submit" value="提交订单" style="background-color: blue; font-size: 12px; color: #fff; width: 86px; height: 37px; border: none; cursor: pointer; border: 0px;text-align: center;" />
        </div>
        </form>


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
<!-- 三级联动 begin -->
<script type="text/javascript" src="${ctx}/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/js/address.js"></script>
<script>
    $(function () {
        var html = "";
        $("#input_city").append(html);
        $("#input_area").append(html);
        $.each(pdata,function(idx,item){
            if (parseInt(item.level) == 0) {
                html += "<option value="+item.code+" id=shipperaddress"+item.code+" >"+ item.names +"</option> ";
            }
        });
        $("#input_province").append(html);

        $("#input_province").change(function(){
            if ($(this).val() == "") return;
            $("#input_city option").remove();
            $("#input_area option").remove();
            //var code = $(this).find("option:selected").attr("exid");
            var code = $(this).find("option:selected").val();
            code = code.substring(0,2);
            var html = "<option value=''>--请选择--</option>";
            $("#input_area option").append(html);
            $.each(pdata,function(idx,item){
                if (parseInt(item.level) == 1 && code == item.code.substring(0,2)) {
                    html +="<option value="+item.code+" id=shipperaddress"+item.code+" >"+ item.names +"</option> ";
                }
            });
            $("#input_city ").append(html);
        });

        $("#input_city").change(function(){
            if ($(this).val() == "") return;
            $("#input_area option").remove();
            var code = $(this).find("option:selected").val();
            code = code.substring(0,4);
            var html = "<option value=''>--请选择--</option>";
            $.each(pdata,function(idx,item){
                if (parseInt(item.level) == 2 && code == item.code.substring(0,4)) {
                    html +="<option value="+item.code+" id=shipperaddress"+item.code+" >"+ item.names +"</option> ";
                }
            });
            $("#input_area ").append(html);
        });



        var html = "";
        $("#input_city1").append(html);
        $("#input_area1").append(html);
        $.each(pdata,function(idx,item){
            if (parseInt(item.level) == 0) {
                html += "<option value="+item.code+" id=consigneeAddress"+item.code+" >"+ item.names +"</option> ";
            }
        });
        $("#input_province1").append(html);

        $("#input_province1").change(function(){
            if ($(this).val() == "") return;
            $("#input_city1 option").remove();
            $("#input_area1 option").remove();
            //var code = $(this).find("option:selected").attr("exid");
            var code = $(this).find("option:selected").val();
            code = code.substring(0,2);
            var html = "<option value=''>--请选择--</option>";
            $("#input_area1 option").append(html);
            $.each(pdata,function(idx,item){
                if (parseInt(item.level) == 1 && code == item.code.substring(0,2)) {
                    html +="<option value="+item.code+" id=consigneeAddress"+item.code+" >"+ item.names +"</option> ";
                }
            });
            $("#input_city1 ").append(html);
        });

        $("#input_city1").change(function(){
            if ($(this).val() == "") return;
            $("#input_area1 option").remove();
            var code = $(this).find("option:selected").val();
            code = code.substring(0,4);
            var html = "<option value=''>--请选择--</option>";
            $.each(pdata,function(idx,item){
                if (parseInt(item.level) == 2 && code == item.code.substring(0,4)) {
                    html +="<option value="+item.code+" id=consigneeAddress"+item.code+" >"+ item.names +"</option> ";
                }
            });
            $("#input_area1 ").append(html);
        });
    });
</script>
<!-- 三级联动 end -->
</body>

</html>
