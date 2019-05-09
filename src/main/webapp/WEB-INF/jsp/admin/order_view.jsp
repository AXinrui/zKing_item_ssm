<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/6
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../../common/head.jsp" %>
<!DOCTYPE html>
<html class="x-admin-sm">

<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.2</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="${ctx}/css/font.css">
    <link rel="stylesheet" href="${ctx}/css/xadmin.css">
    <script type="text/javascript" src="${ctx}/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${ctx}/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row" style="text-align: left;margin-left: 50px;">
        <c:if test="${status =='1'}" >
            <div class="layui-form-item">
                <label> 取件人姓名：${express.consignee}</label>
            </div>
            <div class="layui-form-item">
                <label> 取件人地址：${express.consigneeaddress}</label>
            </div>
            <div class="layui-form-item">
                <c:if test="${express.consigneetime == '' }">
                    <label> 取件时间：<fmt:formatDate value="${express.consigneetime}" pattern="yyyy-MM-dd HH:mm:ss" /></label>
                </c:if>
                <c:if test="${express.consigneetime != '' }" >
                    <label> 取件时间：未取件</label>
                </c:if>
            </div>
            <div class="layui-form-item">
                <label> 取件人联系电话：${express.consigneephone}</label>
            </div>
        </c:if>
        <c:if test="${status =='2'}" >
            <div class="layui-form-item">
                <label> 发件人姓名：${express.shipper}</label>
            </div>
            <div class="layui-form-item">
                <label> 发件人地址：${express.shipperaddress}</label>
            </div>
            <div class="layui-form-item">
                <label> 发件人时间：<fmt:formatDate value="${express.shippertime}" pattern="yyyy-MM-dd HH:mm:ss" /></label>
            </div>
            <div class="layui-form-item">
                <label> 发件人联系电话：${express.shipperphone}</label>
            </div>
        </c:if>
        <div class="layui-form-item">
            <button class="layui-btn" lay-filter="close" style="width: 150px;text-align: center;" lay-submit="">关闭</button>
        </div>
    </div>
</div>
<script>
    layui.use(['form', 'layer', 'jquery'],
    function () {
        $ = layui.jquery;
        var form = layui.form;

        //监听提交
        form.on('submit(close)',
            function () {
                //关闭当前frame
                xadmin.close();

                // // 可以对父窗口进行刷新
                //  xadmin.father_reload();
            });
    });
</script>
</body>

</html>