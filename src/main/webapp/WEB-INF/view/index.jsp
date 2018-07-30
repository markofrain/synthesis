<%--
  Created by IntelliJ IDEA.
  User: cgq_r
  Date: 2018/7/25
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="gbl" uri="/WEB-INF/tlds/stu.tld" %>
<%@ taglib prefix="stu" tagdir="/WEB-INF/tags/stu" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
学生的明名称是:${gbl:getStudentName(0)}
<br/>
学生:${gbl:getStudent(0)}
<br/>
获得学生id:${gbl:getId(student)}
<br/>
<stu:hello id="1"/>

<a href="${pageContext.request.contextPath}/emp/list">Mustache模版测试</a>
</body>
</html>
