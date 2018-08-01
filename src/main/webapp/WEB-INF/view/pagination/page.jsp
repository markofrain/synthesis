<%--
  Created by IntelliJ IDEA.
  User: cgq_r
  Date: 2018/8/1
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>twbs分页插件使用</title>

    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery.min.js"></script>


</head>
<body>
    <table>
        <c:forEach var="area" items="${pageInfo.list}">
            <tr>
                <td>${area.id}</td>
                <td>${area.name}</td>
                <td>${area.pid}</td>
            </tr>
        </c:forEach>
    </table>
<ul>
    <a href="/pagination/list?pageNum=1">首页</a>
    <a href="/pagination/list?pageNum=${pageInfo.prePage<1?1:pageInfo.prePage}">上一页</a>
    <span>${pageInfo.pageNum}</span>
    <a href="/pagination/list?pageNum=${pageInfo.nextPage>pageInfo.pages?pageInfo.pages:pageInfo.nextPage}">下一页</a>
    <a href="/pagination/list?pageNum=${pageInfo.pages}">尾页</a>
</ul>

</body>
</html>
