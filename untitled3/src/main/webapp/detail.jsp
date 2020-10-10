<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title></title></head>
<body>
<table border="1">
    <caption>火车车次详情</caption>
    <tr>
        <td>车次</td>
        <td>${requestScope.detail[0].trainNo}</td>
    </tr>
    <tr>
        <td>发车--到达</td>
        <td>${requestScope.detail[0].startStation}--${requestScope.detail[0].arrivalStation}</td>
    </tr>
    <tr>
        <td>发时--到时</td>
        <td>${requestScope.detail[0].startTime}--${requestScope.detail[0].arrivalTime}</td>

    </tr>
    <tr>
        <td>车型</td>
        <td>${requestScope.detail[0].type}</td>

    </tr>
    <tr>
        <td>运行时间(小时)</td>
        <td>${requestScope.detail[0].runtime}</td>

    </tr>
    <tr>
        <td>里程(公里)</td>
        <td>${requestScope.detail[0].mile}</td>
    </tr>
</table>

</body>
</html>

