<%@ page import="org.springframework.web.servlet.ModelAndView" %>
<%@ page import="javax.xml.transform.Source" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/5
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../../common/head.jsp"%>
<%@taglib prefix="z" uri="/zking" %>
<!DOCTYPE html>
<html class="x-admin-sm">

<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.2</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="${ctx}/css/font.css">
    <link rel="stylesheet" href="${ctx}/css/xadmin.css">
</head>
<body>
<div class="x-nav">
            <span class="layui-breadcrumb">
                <a href="">首页</a>
                <a href="">订单管理</a>
                <a>
                    <cite>快递分配</cite></a>
            </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
        <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i>
    </a>
</div>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">
                    <button id="${uid}" class="layui-btn layui-btn-danger" onclick="courierAll(this.id)">
                        <i class="iconfont">&#xe71d;</i>&nbsp;点击选择分配</button>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <div class="layui-input-inline layui-show-xs-block" >
                        <input type="number" id="sum" placeholder="请输入分配数量" autocomplete="off" class="layui-input" style="width: 150px;" ></div>
                    <button id="${uid}" class="layui-btn layui-btn-normal" onclick="kscourierAll(this.id)">
                        <i class="iconfont">&#xe718;</i>&nbsp;快速分配</button>
                </div>
                <div class="layui-card-body ">
                    <table class="layui-table layui-form">
                        <thead>
                        <tr>
                            <th>
                                <input type="checkbox" lay-filter="checkall" lay-skin="primary">
                            </th>
                            <th>快递单号</th>
                            <th>快递名称</th>
                            <th>收件人名称</th>
                            <th>收件人电话</th>
                            <th>收货地址</th>
                            <th>快递备注</th>
                        </thead>
                        <tbody>
                        <c:forEach var="q" items="${expressLists}">
                        <tr>
                            <td>
                                <input type="checkbox" name="id" value="${q.eid}" lay-skin="primary"></td>
                            <td>${q.orderid}</td>
                            <td>${q.ordername}</td>
                            <td>${q.consignee}</td>
                            <td>${q.consigneephone}</td>
                            <td>${q.consigneeaddress}</td>
                            <td>${q.orderremark}</td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
                <z:pageLayui pageBean="${pageBean}"/>
            </div>
        </div>
    </div>
</body>
<script src="${ctx}/lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/js/xadmin.js"></script>
<script>layui.use(['laydate', 'form'],
    function() {
        var  form = layui.form;

        // 监听全选
        form.on('checkbox(checkall)', function(data){

            if(data.elem.checked){
                $('tbody input').prop('checked',true);
            }else{
                $('tbody input').prop('checked',false);
            }
            form.render('checkbox');
        });
    });

/*快速分配*/
function kscourierAll(uid){

    var id = $("#sum").val();
    layer.confirm('确认要分配给快递员（'+uid+'）的吗？',function(index){
        $.ajax({
            url : "courier/orderCourierAdd?uid="+uid+"&id="+id,
            dataType:'json',
            success : function(data) {
                if(data="1"){
                    //发异步删除数据
                    layer.msg('已分配成功!',{icon:1,time:1000});
                    //关闭当前frame
                    xadmin.close();
                }else if(data=="2"){
                    layer.msg('分配失败，库存不足！',{icon:5,time:1000});
                    //关闭当前frame
                    //xadmin.close();
                }
            }
        });
    });
}

function courierAll (uid) {
    var ids = [];

    // 获取选中的id
    $('tbody input').each(function(index, el) {
        if($(this).prop('checked')){
            ids.push($(this).val())
        }
    });
    if (""!=ids.toString()){
        if (ids.toString().length<=2){
            ids += ",";
        }
        layer.confirm('确认要把所勾选的分配给快递员（'+uid+'）吗？'+ids.toString(),function(){
            $.ajax({
                url : "/courier/orderCourierAdd?id="+ids.toString()+"&uid="+uid,
                dataType:'json',
                success : function(data) {
                    if(data=="1"){
                        //捉到所有被选中的，发异步进行删除
                        layer.msg('分配成功', {icon: 1});
                        $(".layui-form-checked").not('.header').parents('tr').remove();
                    }
                }
            });
        });
    }else{
        layer.msg('请选择!',{icon:5,time:1000});
    }
}
</script>
</html>
