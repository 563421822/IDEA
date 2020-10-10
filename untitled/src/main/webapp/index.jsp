<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<c:choose>
    <c:when test="${sessionScope.adminSuccess!=null}">
        <h1>管理员后台首页</h1>
        <h2><a href="modifyPwd.jsp">修改密码</a></h2>
        <h2><a href="ManageServlet">管理学生</a></h2>
        <h2><a href="ExitServlet">注销</a></h2>
    </c:when>
    <c:otherwise>
        <h1>普通用户后台首页</h1>
        <h2><a href="modifyPwd.jsp">修改密码</a></h2>
        <h2><a href="EditServlet">修改用户信息</a></h2>
        <h2><a href="ExitServlet">注销</a></h2>
    </c:otherwise>
</c:choose>
</body>
</html>
