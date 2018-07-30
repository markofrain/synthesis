<%--
  Created by IntelliJ IDEA.
  User: cgq_r
  Date: 2018/7/26
  Time: 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/ctx.jsp"%>
<%@ taglib prefix="gbl" uri="/WEB-INF/tlds/stu.tld" %>
<html>
<head>
    <title>Title</title>
    <link href="${ctxStatic}/css/bootstrap.min.css" rel="stylesheet" type="text/css">

    <script type="text/javascript" src="${ctxStatic}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${ctxStatic}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${ctxStatic}/js/mustache.min.js"></script>

    <script type="text/javascript" src="${ctxStatic}/treeTable/jquery.treeTable.min.js"></script>
    <link href="${ctxStatic}/treeTable/themes/vsStyle/treeTable.min.css" rel="stylesheet" type="text/css">


    <script type="text/javascript">
        $(document).ready(function(){
            var tpl = $("#template").html();
            var data = ${areaList};
            addRow("#treeTableList",tpl,data,0);
            $("#treeTable").treeTable({ expandable: true ,expandLevel : 5});
        });

        function addRow(list,tpl,data,pid) {
            for (var i=0;i<data.length;i++){
                var row = data[i];
                if(row.parentId==pid){
                    $(list).append(Mustache.render(tpl,{area:row,areatype:row.type,pid:pid}));
                    addRow(list,tpl,data,row.id);
                }

            }
        }
    </script>

</head>

    <table id="treeTable" class="table table-striped table-bordered table-condensed">
        <thead>
            <tr>
                <th>区域名称</th>
                <th>区域类型</th>
                <th>备注</th>
            </tr>
        </thead>
        <tbody id="treeTableList">

        </tbody>
    </table>


    <script id="template" type="x-tmpl-mustache">
        <tr id="{{area.id}}" pid={{pid}}>
            <td>{{area.name}}</td>
            <td>{{areatype}}</td>
            <td>{{area.description}}</td>
        </tr>
    </script>
</body>
</html>
