<%--
  Created by IntelliJ IDEA.
  User: cgq_r
  Date: 2018/7/25
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/ctx.jsp"%>
<html>
<head>
    <title>Mustache模板测试</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/mustache.min.js"></script>

    <link href="${ctxStatic}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${ctxStatic}/css/jquery.treetable.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="${ctxStatic}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${ctxStatic}/js/jquery.treetable.js"></script>
    <script type="text/javascript">
        $(function(){
            var tpl = $("#template").html();
            var html = "";
            var data = ${empList};
            for(var i =0;i<data.length;i++){
                var row = data[i];
                html+=Mustache.render(tpl,{
                    emp:row,
                    pid:row.id==1?0:1
                });
            }
            $("#stulist").html(html);
        })
        $("#treeTable").treetable({ expandable: true });
    </script>
</head>
<body>

<table id="treeTable" class="table table-striped table-bordered table-condensed">
    <thead>
        <tr>
            <th>姓名</th>
            <th>性别</th>
            <th>地址</th>
            <th>薪资</th>
        </tr>
    </thead>
    <tbody id="stulist">

    </tbody>
</table>


<script id="template" type="x-tmpl-mustache">
    <tr id="{{emp.id}}" pid={{pid}}>
        <td>{{emp.name}}</td>
        <td>{{emp.sex}}</td>
        <td>{{emp.address}}</td>
        <td>{{emp.salary}}</td>
    </tr>
</script>


</body>
</html>
