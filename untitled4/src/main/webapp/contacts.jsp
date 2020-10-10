<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<table border="1">
    <caption>联系人列表</caption>
    <tr>
        <td>姓名</td>
        <td>电话</td>
        <td>地址</td>
        <td>操作</td>
    </tr>
    <c:forEach var="l" items="${requestScope.list}">
        <tr>
            <td>${l.name}</td>
            <td>${l.phone}</td>
            <td>${l.address}</td>
            <td><a href="DetailServlet?name=${l.name}">编辑</a>|<a href="DeleteServlet?name=${l.name}">删除</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="2">
            <c:if test="${requestScope.page.currentPage gt 1}">
                <a href="ContactsServlet?curr=1">首页</a>|
            </c:if>
            <c:if test="${requestScope.page.currentPage gt 1}">
                <a href="ContactsServlet?curr=${requestScope.page.currentPage-1}">上一页</a>|
            </c:if>
            <c:if test="${requestScope.page.currentPage lt requestScope.page.totalPage}">
                <a href="ContactsServlet?curr=${requestScope.page.currentPage+1}">下一页</a>|
            </c:if>
            <c:if test="${requestScope.page.currentPage lt requestScope.page.totalPage}">
                <a href="ContactsServlet?curr=${requestScope.page.totalPage}">尾页</a>
            </c:if>
        </td>
        <td colspan="2"></td>
    </tr>
    <tr>
        <td colspan="2"></td>
        <td colspan="2">
            每页显示${requestScope.page.pageSize}条,当前为第${requestScope.page.currentPage}/${requestScope.page.totalPage}页,共${requestScope.page.totalCount}条数据
        </td>
    </tr>
    <tr>
        <td colspan="4"><a href="edit.jsp">新增联系人</a></td>
    </tr>
</table>
</body>
</html>
