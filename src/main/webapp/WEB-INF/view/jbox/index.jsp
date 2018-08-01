<%--
  Created by IntelliJ IDEA.
  User: cgq_r
  Date: 2018/8/1
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jbox</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/jBox-0.4.9/Source/jBox.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/jBox-0.4.9/Source/jBox.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/demo-jbox.js"></script>
</head>
<body>
<%--基本提示弹框--%>
<div id="baseShow" class="target-click">Click me</div>

<%--移动弹框设置--%>
<div id="show" class="target-click">Click me</div>
<div id="showBox" style="display: none">
    <form action="/jbox/save" type="post">
        <input type="text" name="id" value=""/>
        <input type="text" name="name" value=""/>
        <input type="submit" value="提交"/>
    </form>
</div>

<%--ajax弹框--%>
<div id="showAjax" class="target-click">Click me</div>

<%--鼠标悬停显示内容--%>
<span id="hover" class="target"> hover me</span>
</body>
</html>
