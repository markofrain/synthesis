<%--
  Created by IntelliJ IDEA.
  User: cgq_r
  Date: 2018/7/26
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/jeDate/jedate.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/jeDate/jedate.css" type="text/css">

    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/jqueryvalidate/jquery.validate.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/jqueryvalidate/messages_zh.js"></script>

    <script type="text/javascript">
        /*$.validator.setDefaults({
            //使用其他方式代替默认的submit

        });*/


        jQuery.validator.addMethod("checkPhone", function(value, element) {
            var tel = /^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\d{8}$/;
            return this.optional(element) || (tel.test(value));
        }, "请正确填写您的手机号");

        $(function(){
            $("#deptForm").validate({
                submitHandler: function(form) {
                    alert("提交事件!");
                    form.submit();
                },
                rules:{
                    //name:"required",
                    address:"required",
                    phone:{
                        required:true,
                        maxlength:11
                    },
                    area:{
                        required:true,
                        digits:true
                    },
                    establishDate:"required"
                },
                remote:{
                    url:"dept/remote",
                    type:"post",
                    dataType:"json",
                    data:{
                        name:"name"
                    }
                }
            });
        })
    </script>
    <style type="text/css">
        .error{
            color: #34ce57;
        }
    </style>
</head>
<body>
    <%--<form:form id="deptForm" action="${pageContext.request.contextPath}/dept/save" method="post" modelAttribute="dept">
        <form:label path="name">部门名称</form:label><form:input path="name" class="required"></form:input><br/>
        <form:label path="area">部门面积</form:label><form:input path="area" class="required"></form:input><br/>
        <form:label path="address">部门地址</form:label><form:input path="address" class="required"></form:input><br/>
        <form:label path="phone">部门电话</form:label><form:input path="phone" class="required" digits="true" range="[5,10]"></form:input><br/>
        <form:label path="establishDate">成立日期</form:label>
        <input type="text" name="establishDate" value="<fmt:formatDate value="${dept.establishDate}"/>" class="jeinput" id="enYMD" placeholder="YYYY-MM-DD"/><br/>
        <input type="submit" value="提交">
    </form:form>--%>

    <form id="deptForm" action="${pageContext.request.contextPath}/dept/save" method="post">
        <label>部门名称</label><input name="name" value="${dept.name}"></input><br/>
        <label>部门面积</label><input name="area" value="${dept.area}"></input><br/>
        <label>部门地址</label><input name="address" value="${dept.address}"></input><br/>
        <label>部门电话</label><input name="phone" value="${dept.phone}" class="checkPhone"></input><br/>
        <label>成立日期</label><div class="jeinpbox"><input type="text" name="establishDate" value="<fmt:formatDate value="${dept.establishDate}"/>" class="jeinput" id="enYMD" placeholder="YYYY-MM-DD"></div>
        <input type="submit" value="提交">
    </form>

<br/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/jeDate/test.js"></script>
</body>
</html>
