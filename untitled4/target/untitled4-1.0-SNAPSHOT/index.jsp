<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="LoginServlet" method="post">
    <table>
        <caption>登录页面</caption>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="提交"/><input type="reset" value="重置"/></td>
        </tr>

    </table>
</form>
</body>
</html>
