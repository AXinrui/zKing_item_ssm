<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/10
  Time: 10:45
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
    <script src="${ctx}/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${ctx}/js/xadmin.js"></script>
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="x-nav">
          <span class="layui-breadcrumb">
            <a href="">首页</a>
            <a href="">留言管理</a>
            <a>
              <cite>留言处理</cite></a>
          </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
        <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
</div>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">
                    <form class="layui-form layui-col-space5">
                        <div class="layui-inline layui-show-xs-block" action="/message/messageList" method="post" >
                            <input type="text" name="mname" value="${mname}"  placeholder="请输入用户名" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                        </div>
                    </form>
                </div>
                <div class="layui-card-header">
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
                            <th>姓名</th>
                            <th>联系方式</th>
                            <th>留言内容</th>
                            <th>状态</th>
                            <th>操作</th></tr>
                        </thead>
                        <tbody>
                        <c:forEach var="i" items="${messageLists}" >
                            <tr>
                                <td>
                                    <input type="checkbox" name="id" value="${i.mid}"   lay-skin="primary">
                                </td>
                                <td>${i.mid}</td>
                                <td class="td_mname">${i.mname}</td>
                                <td class="td-phone" >${i.mphone}</td>
                                <td>${i.mcontent}</td>
                                <c:if test="${i.mstatus==0}" >
                                <td class="td-status">
                                    <span class="layui-btn layui-btn-normal layui-btn-mini layui-btn-disabled">已回复</span></td>
                                <td class="td-manage">
                                    </c:if>
                                    <c:if test="${i.mstatus==1}" >
                                <td class="td-status">
                                    <span class="layui-btn layui-btn-normal layui-btn-mini">未回复</span></td>
                                <td class="td-manage">
                                    </c:if>
                                    <a id="${i.mid}" onclick="to_message(this,this.id)" title="回复消息" href="javascript:;">
                                        <i class="layui-icon">&#xe631;</i>
                                    </a>
                                    <a id="${i.mid}" title="删除" onclick="member_del(this,this.id)" href="javascript:;">
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
</body>
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

    //默认prompt
    function to_message(obj,id){
        var  name =  $(obj).parents("tr").find(".td_mname").html();
        layer.prompt({
            title:'回复'+name,
            btn: ['发送', '关闭']
        },function(val, index){
            // layer.msg('得到了'+val);
            var a =  $(obj).parents("tr").find(".td-phone").html();
            $.ajax({
                url : "message/messageReply?mcontent="+val+"&mid="+id+"&mphone="+a,
                dataType:'json',
                success : function(data) {
                    if(data="1"){
                        //发异步删除数据
                        $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已回复');
                        layer.msg('回复成功!',{icon:1,time:1000});
                    }else{
                        layer.msg('回复失败!',{icon:5,time:1000});
                    }
                    layer.close(index);
                }
            });
        });
    }

    /*留言-删除*/
    function member_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
            $.ajax({
                url : "message/messageDel?id="+id,
                dataType:'json',
                success : function(data) {
                    if(data="1"){
                        //发异步删除数据
                        $(obj).parents("tr").remove();
                        layer.msg('已移除!',{icon:1,time:1000});
                    }
                }
            });
        });
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
            layer.confirm('确认要全部删除吗？'+ids.toString(),function(index){
                $.ajax({
                    url : "message/messageDel?id="+ids.toString(),
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
</html>
