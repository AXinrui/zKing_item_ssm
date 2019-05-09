<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/5
  Time: 18:07
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
    <script type="text/javascript" src="${ctx}/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${ctx}/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">用户管理</a>
        <a>
          <cite>用户删除</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
        <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
</div>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">
                    <form class="layui-form layui-col-space5" action="/user/userListDel" method="post" >
                        <div class="layui-inline layui-show-xs-block">
                            <input type="text" name="uname"  placeholder="请输入用户名" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                        </div>
                    </form>
                </div>
                <div class="layui-card-header">
                    <button class="layui-btn layui-btn-safe" onclick="recoverAll()"><i class="layui-icon"></i>批量恢复</button>
                    <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
                </div>
                <div class="layui-card-body ">
                    <table class="layui-table layui-form">
                        <thead>
                        <tr>
                            <th>
                                <input type="checkbox" lay-filter="checkall" name="" lay-skin="primary">
                            </th>
                            <th>ID</th>
                            <th>用户名</th>
                            <th>手机</th>
                            <th>邮箱</th>
                            <th>资金</th>
                            <th>加入时间</th>
                            <th>状态</th>
                            <th>操作</th></tr>
                        </thead>
                        <tbody>
                        <c:forEach var="i" items="${userList}" >
                        <tr>
                            <td>
                                <input type="checkbox" name="id" value="${i.uid}" lay-skin="primary">
                            </td>
                            <td>${i.uid}</td>
                            <td>${i.uname}</td>
                            <td>${i.uphone}</td>
                            <td>${i.pid}</td>
                            <td>${i.uaddress}</td>
                            <td>2017-01-01 11:11:42</td>
                            <td class="td-status">
                                <span class="layui-btn layui-btn-danger layui-btn-mini">
                                                  已删除
                               </span>
                            </td>
                            <td class="td-manage">
                                <a title="恢复" id="${i.uid}" onclick="member_recover(this,this.id)" href="javascript:;">
                                    <i class="layui-icon">&#xe669;</i>
                                </a>
                                <a title="删除" id="${i.uid}" onclick="member_del(this,this.id)" href="javascript:;">
                                    <i class="layui-icon">&#xe640;</i>
                                </a>
                            </td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <z:pageLayui pageBean="${pageBean}"/>
            </div>
        </div>
    </div>
</div>
<script>
    layui.use(['laydate','form'], function(){
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

    /*用户-huifu*/
    function member_recover(obj,id){
        layer.confirm('确认要恢复吗？',function(index){
            $.ajax({
                url : "user/recoverUser?id="+id,
                dataType:'json',
                success : function(data) {
                    if(data="1"){
                        //发异步删除数据
                        $(obj).parents("tr").remove();
                        layer.msg('已恢复!',{icon:1,time:1000});
                    }
                }
            });
        });
    }

    /*用户-删除*/
    function member_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
            $.ajax({
                url : "user/userDel?id="+id,
                dataType:'json',
                success : function(data) {
                    if(data="1"){
                        //发异步删除数据
                        $(obj).parents("tr").remove();
                        layer.msg('已恢复!',{icon:1,time:1000});
                    }
                }
            });
        });
    }

    function recoverAll (argument) {
        var ids = [];

        // 获取选中的id
        $('tbody input').each(function(index, el) {
            if($(this).prop('checked')){
                ids.push($(this).val())
            }
        });
        if (""!=ids.toString()){
            layer.confirm('确认要把所勾选的恢复吗？'+ids.toString(),function(index){
                $.ajax({
                    url : "user/recoverUser?id="+ids.toString(),
                    dataType:'json',
                    success : function(data) {
                        if(data="1"){
                            //捉到所有被选中的，发异步进行删除
                            layer.msg('恢复成功', {icon: 1});
                            $(".layui-form-checked").not('.header').parents('tr').remove();
                        }
                    }
                });
            });
        }else{
            layer.msg('请选择!',{icon:5,time:1000});
        }
    }
    function delAll (argument) {
        var ids = [];

        // 获取选中的id
        $('tbody input').each(function(index, el) {
            if($(this).prop('checked')){
                ids.push($(this).val())
            }
        });
        if (""!=ids.toString()){
            layer.confirm('确认要把所勾选的删除吗？'+ids.toString(),function(index){
                $.ajax({
                    url : "user/delUser?id="+ids.toString(),
                    dataType:'json',
                    success : function(data) {
                        if(data="1"){
                            //捉到所有被选中的，发异步进行删除
                            layer.msg('删除成功', {icon: 1});
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
</body>

</html>
