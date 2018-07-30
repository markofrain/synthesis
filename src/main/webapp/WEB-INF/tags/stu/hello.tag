<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ attribute name="id" required="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery.min.js"></script>
<p id="hello">你好</p>

<script type="text/javascript">
    $.post("${ctx}/stu/get",{id:${id}},function(data){
        $("#hello").text(data);
    });
</script>

