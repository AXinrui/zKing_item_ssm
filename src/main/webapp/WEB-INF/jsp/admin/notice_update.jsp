<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/9
  Time: 19:36
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
    <link href="${ctx}/Content/Layui-KnifeZ/css/layui.css" rel="stylesheet"/>
</head>
<body>
<div class="x-nav">
            <span class="layui-breadcrumb">
                <a href="">首页</a>
                <a href="">文章设置</a>
                <a>
                    <cite>公告修改</cite></a>
            </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       onclick="location.reload()" title="刷新">
        <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i>
    </a>
</div>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <form class="layui-form" action="${ctx}/notice/addNotice" method="post">
            <div class="layui-form-item">
                <label for="username" class="layui-form-label">
                    <span class="x-red">*</span>公告标题</label>
                <div class="layui-input-inline">
                    <input type="text" id="nname" value="${notice.nname}" name="nname" required="" lay-verify="required"
                           autocomplete="off" class="layui-input" style="width: 500px;" /></div>
                <div class="layui-input-inline" style="margin-left: 320px;margin-top: 7px;" >
                    <jsp:useBean id="now" class="java.util.Date" scope="page"/>
                    当前时间:<fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss" />
                </div>
            </div>
            <div class="layui-form-item">
                <label for="username" class="layui-form-label">
                    logo设置
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="nimg" name="nimg" value="${notice.nimg}"  class="layui-input" />
                </div>
                <div class="layui-input-inline layui-show-xs-block" style="margin-left: 50px;"  >
                    <select name="dictItem" required="" lay-verify="required"  autocomplete="off" >
                        <option value="">订单类型</option>
                        <c:forEach items="${dicts}" var="i" >
                            <option value="${i.dictItem}">${i.dictItem}</option>
                        </c:forEach>
                    </select>
                </div>
                <label for="username" class="layui-form-label">
                    公告ID：${notice.nid}
                </label>
                <div class="layui-input-inline">
                    <button class="layui-btn" lay-filter="add" lay-submit="" style="margin-left: 60px;" >修改</button>
                </div>
            </div>
            <div class="layui-form-item" style="background-color: white;" >
                <textarea name="ncontent" id="layeditDemo" required="" lay-verify="required" autocomplete="off" ></textarea>
            </div>
        </form>
    </div>
</div>
</body>
<script src="${ctx}/Content/ace/ace.js" type="text/javascript" ></script>
<script src="${ctx}/Content/Layui-KnifeZ/layui.js" type="text/javascript" ></script>
<script type="text/javascript" src="${ctx}/js/xadmin.js"></script>
<script>
    layui.use(['layedit', 'layer','form', 'jquery'], function () {
        var $ = layui.jquery
            , layer = layui.layer
            , layedit = layui.layedit;
        layedit.set({
            uploadImage: {
                url: 'your url',
                accept: 'image',
                acceptMime: 'image/*',
                exts: 'jpg|png|gif|bmp|jpeg',
                size: 1024 * 10,
                done: function (data) {
                    console.log(data);
                }
            }
            , uploadVideo: {
                url: 'your url',
                accept: 'video',
                acceptMime: 'video/*',
                exts: 'mp4|flv|avi|rm|rmvb',
                size: 1024 * 10 * 2,
                done: function (data) {
                    console.log(data);
                }
            }
            , uploadFiles: {
                url: 'your url',
                accept: 'file',
                acceptMime: 'file/*',
                size: '20480',
                done: function (data) {
                    console.log(data);
                }
            }
            , calldel: {
                url: 'your url',
                done: function (data) {
                    console.log(data);
                }
            }
            , autoSync: true
            , facePath: 'http://www.hunmengwl.com/'
            , devmode: true
            , tool: [
                'html', 'undo', 'redo', 'code', 'strong', 'italic', 'underline', 'del', 'addhr', '|', 'fontFomatt', 'fontfamily','fontSize', 'fontBackColor', 'colorpicker', 'face'
                , '|', 'left', 'center', 'right', '|', 'link', 'unlink', 'images', 'image_alt', 'video','attachment', 'anchors'
                , '|'
                , 'table', 'fullScreen','preview'
            ]
            , height: '80%'
        });
        var ieditor = layedit.build('layeditDemo');
    })
</script>
</html>
