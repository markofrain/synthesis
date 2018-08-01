<%--
  Created by IntelliJ IDEA.
  User: cgq_r
  Date: 2018/7/31
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>简单json(非标准json)</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/zTree_v3/css/zTreeStyle/zTreeStyle.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/zTree_v3/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/zTree_v3/js/jquery.ztree.core.js"></script>
    <script type="text/javascript">
        var zNodes=${data};
        var setting={
            data:{
                simpleData:{
                    enable:true,
                    idKey:"id",
                    pIdKey:"pid",
                    rootPId:""
                }
            },
            callback:{
                onClick:function (event,treeId,treeNode,clickFlag) {
                    alert(treeNode.id);
                }
            }
        }
        $(function(){
            $.fn.zTree.init($("#treedata"),setting,zNodes);
        });
    </script>

</head>
<body>

<div>
    <ul id="treedata" class="ztree"></ul>
</div>

</body>
</html>
