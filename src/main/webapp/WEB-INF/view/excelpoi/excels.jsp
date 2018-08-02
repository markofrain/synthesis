<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cgq_r
  Date: 2018/8/2
  Time: 8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Excel导入导出</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/jBox-0.4.9/Source/jBox.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/jBox-0.4.9/Source/plugins/Notice/jBox.Notice.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/jBox-0.4.9/Source/themes/NoticeFancy.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/jBox-0.4.9/Source/jBox.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/jBox-0.4.9/Source/plugins/Notice/jBox.Notice.min.js"></script>
</head>
<body>

<div id="import" class="target-click">导入</div>

<div id="importshow" style="display: none">
    <form action="import" method="post" enctype="multipart/form-data">
        <input type="file" name="file"/><br/>
        <input type="submit" value="提交"/><br/>
    </form><br/>
    <button id="template">模板下载</button><br/>
    <span style="text-align: right">禁止大小超过5MB</span>
</div>

<script type="text/javascript">
    $(function(){
        new jBox('Modal', {
            attach: '#import',
            width: 350,
            height: 200,
            blockScroll: false,
            animation: 'zoomIn',
            draggable: 'title',
            closeButton: true,
            content: $("#importshow"),
            title: '移动弹框',
            overlay: false,
            reposition: false,
            repositionOnOpen: false
        });

        var colors = ['red', 'green', 'blue', 'yellow'], index = 0;
        var getColor = function () {
            (index >= colors.length) && (index = 0);
            return colors[index++];
        };

        $("#template").click(function(){
            $.get("export",function () {
                var box = new jBox('Notice', {
                    attributes: {
                        x: 'right',
                        y: 'bottom'
                    },
                    stack: false,
                    animation: {
                        open: 'tada',
                        close: 'zoomIn'
                    },
                    autoClose: Math.random() * 2000 + 1000,
                    color: getColor(),
                    title: '下载完成',
                    content: '模板存放在C:\\template下',
                    delayOnHover: true,
                    showCountdown: true,
                    closeButton: true
                });
                box.open();
            });
        });
    });
</script>
</body>
</html>
