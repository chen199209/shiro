<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 引入Shiro标签 -->
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${ctx}/resources/js/jquery/jquery-3.3.1.min.js"></script>
    <script>
        $(function () {
            $('#btn').click(function () {
                alert('点击了')
            })
        })
    </script>
</head>
<body>
<shiro:hasPermission name="user:add">
    <button id="btn">点击</button>
</shiro:hasPermission>
</body>
</html>
