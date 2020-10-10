<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="js/trainJS.js"></script>
</head>
<body>
<table border="1">
    <tr>
        <td><a href="#" onclick="delete(e)">删除</a></td>
        <td>车次</td>
        <td>发车--到达</td>
        <td>发时--到时</td>
        <td>车型</td>
        <td>运行时间(小时)</td>
        <td>里程(公里)</td>
    </tr>
    <c:forEach var="t" items="${requestScope.info}">
        <tr>
            <td><input type="checkbox"/></td>
            <td><a href="DetailServlet?trainNo=${t.trainNo}">${t.trainNo}</a></td>
            <td>${t.startStation}--${t.arrivalStation}</td>
            <td>${t.startTime}--${t.arrivalTime}</td>
            <td>${t.type}</td>
            <td>${t.runtime}</td>
            <td>${t.mile}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
