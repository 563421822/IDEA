<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>

<table border="1">
    <tr>
        <td>姓名</td>
        <td>密码</td>
        <td>性别</td>
        <td>生日</td>
        <td>爱好</td>
        <td>出生城市</td>
        <td>操作</td>
    </tr>
    <%--    索引:${status.index }-当前遍历的元素的值:${指代当前遍历元素 }--%>
    <c:forEach var="l" items="${requestScope.list}" varStatus="status">
        <tr>
            <td>${status.index}-${l.username}</td>
            <td>${l.password}</td>
            <td>${l.gender}</td>
            <td>${l.birthday}</td>
            <td>${l.hobby}</td>
            <td>${l.city}</td>
            <td><a href="EditServlet?name=${l.username}">编辑</a>|<a href="DeleteServlet?name=${l.username}">删除</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td><a href="ManageServlet?curr=1">首页</a></td>
        <%--        如果当前页大于1,才出现上一页--%>
        <c:if test="${requestScope.page.currentPage gt 1}">
            <td><a href="ManageServlet?curr=${requestScope.page.currentPage-1}">上一页</a></td>
        </c:if>
        <%--            如果当前页小于于总页数,才出现下一页--%>
        <c:if test="${requestScope.page.currentPage lt requestScope.page.totalPage}">
            <td><a href="ManageServlet?curr=${requestScope.page.currentPage+1}">下一页</a></td>
        </c:if>
        <td><a href="ManageServlet?curr=${requestScope.page.totalPage}">尾页</a></td>
        <td>当前第${requestScope.page.currentPage}页</td>
        <td colspan="2">总共${requestScope.page.totalPage}页</td>
    </tr>
</table>

</body>
</html>
