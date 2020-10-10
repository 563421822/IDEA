<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>修改密码页面</title>
</head>
<body>
<form action="ModifyPwdServlet" method="post">
    <table>
        <tr>
            <td>请输入原密码:</td>
            <td><input type="password" name="origin"/></td>
        </tr>
        <tr>
            <td>请输入新密码:</td>
            <td><input type="password" name="newPwd"/></td>

        </tr>
        <tr>
            <td>请确认新密码:</td>
            <td><input type="password" name="RePwd"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="提交"><input type="reset" value="重置"/></td>
        </tr>
    </table>
</form>
</body>
</html>
