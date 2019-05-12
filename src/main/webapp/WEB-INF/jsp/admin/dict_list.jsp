<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/11
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../../common/head.jsp" %>
<%@taglib prefix="z" uri="/zking" %>
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
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="${ctx}/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${ctx}/js/xadmin.js"></script>
    <%--<script type="text/javascript" src="${ctx}/js/jquery.js"></script>--%>
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
                <a href="">分类管理</a>
                <a>
                    <cite>分级分类</cite></a>
            </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       onclick="location.reload()" title="刷新">
        <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i>
    </a>
</div>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">
                    <form class="layui-form layui-col-space5">
                        <div class="layui-input-inline layui-show-xs-block">
                            <input class="layui-input" placeholder="分类名" name="cate_name"></div>
                        <div class="layui-input-inline layui-show-xs-block">
                            <button class="layui-btn" onclick="dictitem_add()" lay-submit="" lay-filter="sreach"><i class="layui-icon"></i>增加
                            </button> &nbsp;&nbsp;
                            <button class="layui-btn layui-btn-danger" onclick="delAll();return false;"><i
                                    class="layui-icon"></i>批量删除
                            </button>
                        </div>
                    </form>
                    <%--<hr>--%>
                    <%--<blockquote class="layui-elem-quote">每个tr 上有两个属性 cate-id='1' 当前分类id fid='0' 父级id ,顶级分类为 0，有子分类的前面加收缩图标<i class="layui-icon x-show" status='true'>&#xe623;</i></blockquote>--%>
                </div>
                <div class="layui-card-body ">
                    <table class="layui-table layui-form">
                        <thead>
                        <tr>
                            <th width="20">
                                <input type="checkbox" lay-filter="checkall" name="" lay-skin="primary">
                            </th>
                            <th width="70">ID</th>
                            <th>栏目名</th>
                            <th width="50">排序</th>
                            <th width="80">状态</th>
                            <th width="250">操作</th>
                        </thead>
                        <tbody class="x-cate">
                        <c:forEach var="i" items="${dictList}">
                            <tr cate-id='${i.tid}' id="${i.tid}tr" fid='0'>
                                <td>
                                    <span>
                                    <input type="checkbox" value="${t.tid}" name="" lay-skin="primary">
                                    </span>
                                </td>
                                <td>${i.tid}</td>
                                <td>
                                    <i class="layui-icon x-show" title="${i.dictItem}" id="${i.tid}" status='true'>&#xe623;</i>
                                      <b id="#edit_${i.tid}" > ${i.dictItem}</b>
                                </td>
                                <td><input type="text" class="layui-input x-sort" readonly name="order" value="最高级">
                                </td>
                                <td id="${i.tid}" onclick="oncheck(this.id);">
                                    <input
                                            <c:if test="${i.dictIsEditable == '1' }">
                                                checked=""
                                            </c:if>
                                            type="checkbox" id="${i.tid}check" name="switch" lay-text="开启|停用"
                                            lay-skin="switch"/>
                                </td>
                                <td class="td-manage">
                                    <button id="${i.tid}" class="layui-btn layui-btn layui-btn-xs"
                                            onclick="dict_edit(this,this.id)"><i class="layui-icon">&#xe642;</i>编辑 </button>
                                    <button id="${i.tid}" class="layui-btn layui-btn-warm layui-btn-xs"
                                            onclick="dict_add(this,this.id)"><i class="layui-icon">&#xe642;</i>添加子栏目
                                    </button>
                                    <button id="${i.tid}" class="layui-btn-danger layui-btn layui-btn-xs"
                                            onclick="member_del(this,this.id)" href="javascript:;"><i
                                            class="layui-icon">&#xe640;</i>删除
                                    </button>
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
<div>


</div>
<script>
    layui.use(['form'], function () {
        form = layui.form;

        // 监听全选
        form.on('checkbox(checkall)', function(data){

            if(data.elem.checked){
                $('tbody span input').prop('checked',true);
            }else{
                $('tbody span input').prop('checked',false);
            }
            form.render('checkbox');
        });

    });

    /*用户-删除*/
    function member_del(obj, id) {
        layer.confirm('确认要删除吗？', function () {
            //发异步删除数据
            $.ajax({
                url : "dict/dictDel?id="+id,
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

    // 分类展开收起的分类的逻辑
    //
    $(function () {
        $("tbody.x-cate tr[fid!='0']").hide();
        $('.x-show').click(function () {
            if ($(this).attr('status') == 'true') {
                var id = $(this).attr('id');
                var title = $(this).attr('title');
                if (title != null && "" != title) {
                    $(this).attr("title", "");
                    // 栏目多级显示效果
                    $.ajax({
                        url: "dict/dictItem?tid=" + id,
                        type: "GET",
                        success: function (data) {
                            addtr(data,id);
                        }
                    });
                }
                $(this).html('&#xe625;');
                $(this).attr('status', 'false');
                cateId = $(this).parents('tr').attr('cate-id');
                $("tbody tr[fid=" + cateId + "]").show();
            } else {
                cateIds = [];
                $(this).html('&#xe623;');
                $(this).attr('status', 'true');
                cateId = $(this).parents('tr').attr('cate-id');
                getCateId(cateId);
                for (var i in cateIds) {
                    $("tbody tr[cate-id=" + cateIds[i] + "]").hide().find('.x-show').html('&#xe623;').attr('status', 'true');
                }
            }
        })
    })
    
    function addtr(data,id) {
        if (data != null) {
            for (var i = 0; i < data.length; i++) {
                var check = "";
                if ("1" == data[i].dictIsEditable) {
                    check = 'checked=""';
                }
                var text = ' <tr cate-id=' + data[i].tid + ' fid=' + id + ' ><td><span> <input value="'+data[i].tid+'" type="checkbox" name=""' +
                    ' lay-skin="primary"></span></td><td>' + data[i].tid + '</td><td class="" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;├<span id="edit_'+data[i].tid+'" >'
                    + data[i].dictItem + '<span></td><td><input id="'+data[i].tid +'" type="number" onblur="edit_value(this.id,this.value);" class="layui-input x-sort" name="order" value="'
                    + data[i].dictValue + '"></td><td id="'+ data[i].tid+'" onclick="oncheck(this.id);" ><input type="checkbox" name="switch" id="'+data[i].tid+'check"   ' +
                    'lay-text="开启|停用"  ' + check + ' lay-skin="switch"></td> <td class="td-manage">' +
                    ' <button class="layui-btn layui-btn layui-btn-xs" id="' +
                    data[i].tid + '"  onclick="dict_edit(this,this.id)" ><i class="layui-icon">' +
                    '&#xe642;</i>编辑</button> <button class="layui-btn-danger layui-btn layui-btn-xs" id= "' + data[i].tid +
                    '" onclick="member_del(this,this.id)" href="javascript:;" ><i class="layui-icon">&#xe640;</i>删除</button> </td> </tr>';
                $("#" + id + "tr").after(text);
            }
            form.render();
        }
    }

    var cateIds = [];

    function getCateId(cateId) {
        $("tbody tr[fid=" + cateId + "]").each(function (index, el) {
            id = $(el).attr('cate-id');
            cateIds.push(id);
            getCateId(id);
        });
    }

    /*用户-停用*/
    function oncheck(id) {
        var a = $("#" + id + "check").prop("checked");
        if (!a) {
            $.ajax({
                url: "dict/dictStatus?status=0&id="+id,
                dataType: 'json',
                success: function (data) {
                    if (data == "1") {
                        $("#" + id + "check").attr("checked", false);
                        layer.msg('已停用!', {icon: 1, time: 1000});
                    }
                }
            });
        } else {
            $.ajax({
                url: "dict/dictStatus?status=1&id=" + id,
                dataType: 'json',
                success: function (data) {
                    if (data == "1") {
                        $("#" + id + "check").attr("checked", true);
                        layer.msg('已启用!', {icon: 1, time: 1000});
                    }
                }
            });
        }
    }
    //修改
    function dict_edit(obj,id){
        layer.prompt({
            title:'修改中...',
            btn: ['修改', '关闭']
        },function(val, index){
            // layer.msg('得到了'+val);
            $.ajax({
                url : "dict/updateDict?dictItem="+val+"&tid="+id,
                dataType:'json',
                success : function(data) {
                    if(data="1"){
                        //发异步修改数据
                        $(obj).parents("tr").find('b').html(val);
                        layer.msg('修改成功!',{icon:1,time:1000});
                    }else{
                        layer.msg('修改失败!',{icon:5,time:1000});
                    }
                    layer.close(index);
                }
            });
        });
    }

    function dict_add(obj,id){
        // var id = $(this).attr('id');
        layer.prompt({
                title:'增加中...',

            btn: ['增加', '关闭'],
        },function(val, index){
            // layer.msg('得到了'+val);
            $.ajax({
                url : "dict/addDict?dictItem="+val+"&tid="+id,
                type:"GET",
                success : function(data) {
                    //发异步增加数据
                    alert(data);
                    if(data!=null){
                        addtr(data,id);
                        layer.msg('增加成功!',{icon:1,time:1000});
                    }else{
                        layer.msg('增加失败!',{icon:5,time:1000});
                    }
                    layer.close(index);
                }
            });
        });
    }

    function delAll (argument) {
        var ids = [];

        // 获取选中的id
        $('tbody span input').each(function(index, el) {
            if($(this).prop('checked')){
                ids.push($(this).val())
            }
        });
        if (""!=ids.toString()){
            layer.confirm('确认要全部删除到回收站吗？'+ids.toString(),function(index){
                $.ajax({
                    url : "dict/dictDel?id="+ids.toString(),
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
    
    function edit_value(id,value) {
        $.ajax({
            url : "dict/updateValue?tid="+id+"&dictValue="+value,
            dataType:'json',
            success : function(data) {
                if(data="1"){
                    //捉到所有被选中的，发异步进行删除
                    layer.msg('修改成功', {icon: 1});
                }else{
                    layer.msg('修改失败', {icon: 5});
                }
            }
        });
    }
    function dictitem_add(){
        // var id = $(this).attr('id');
        layer.prompt({
            title:'增加中分类中...',

            btn: ['增加', '关闭'],
        },function(val, index){
            layer.msg('得到了'+val);
            $.ajax({
                url : "dict/addDictType?item="+val,
                type:"GET",
                success : function(data) {
                    //发异步增加数据
                    if(data!=null){
                        layer.msg('增加成功!',{icon:1,time:1000});
                    }else{
                        layer.msg('增加失败!',{icon:5,time:1000});
                    }
                    layer.close(index);
                }
            });
        });
    }

</script>
</body>
</html>

