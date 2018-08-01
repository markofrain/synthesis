<%--
  Created by IntelliJ IDEA.
  User: cgq_r
  Date: 2018/7/31
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>异步子节点</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/statics/zTree_v3/css/zTreeStyle/zTreeStyle.css"/>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/statics/zTree_v3/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/statics/zTree_v3/js/jquery.ztree.core.js"></script>
    <script type="text/javascript">



        var setting = {
            data: {
                key: {
                    name: "name",
                },
                simpleData: {
                    enable: true,
                    idKey: "id",
                    pIdKey: "pid",
                    rootPId: 0
                }
            },
            async:{
                enable:true,
                autoParam:["id"],
                type:"post",
                url:"${pageContext.request.contextPath}/treedata/get",
                dataFilter:function (treeId,parentNode,childNodes) {

                    return childNodes;
                }
            }
        };
        




        <%--var zNodes= ${data};--%>

        $(function(){
            $.fn.zTree.init($("#treedata"),setting);
        });
    </script>
</head>
<body>
<div>
    <ul id="treedata" class="ztree"></ul>
</div>
</body>
</html>
