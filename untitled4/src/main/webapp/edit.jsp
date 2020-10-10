<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>

<table border="1">
    <c:choose>
    <c:when test="${requestScope.edit eq '编辑'}">
    <form action="EditServlet" method="post">
        <caption>编辑联系人页面</caption>
        </c:when>
        <c:otherwise>
        <form action="AddServlet" method="post">
            <caption>添加联系人页面</caption>
            </c:otherwise>
            </c:choose>
            <tr>
                <td>姓名</td>
                <c:choose>
                    <c:when test="${requestScope.edit eq '编辑'}">
                        <td><input type="text" value="${requestScope.list[0].name}" readonly="readonly" name="name"/>
                        </td>
                    </c:when>
                    <c:otherwise>
                        <td><input type="text" name="name"/></td>
                    </c:otherwise>
                </c:choose>
            </tr>
            <c:if test="${empty requestScope.edit}">
            <tr>
                <td>密码</td>
                <td><input type="password" name="password"/></td>
            </tr>
            </c:if>
            <tr>
                <td>电话</td>
                <td><input type="text" value="${requestScope.list[0].phone}" name="phone"/></td>
            </tr>
            <td>地址</td>
            <td><input type="text" value="${requestScope.list[0].address}" name="address"/></td>
            <tr>
                <td></td>
                <td><input type="submit" value="提交"/><input type="reset" value="重置"/></td>
            </tr>
</table>
</form>
</body>
</html>
