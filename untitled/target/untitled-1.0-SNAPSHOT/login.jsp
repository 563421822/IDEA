<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<h1>${requestScope.failed}</h1>
<form action="login" method="post">
    <table>
        <tr>
            <td>用户名:</td>
            <td colspan="2"><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td colspan="2"><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td>登录身份:</td>
            <td colspan="2"><select name="role">
                <option value="normal">普通用户</option>
                <option value="admin">管理员</option>
            </select></td>
        </tr>
        <tr>
            <td>验证码:</td>
            <td><input type="text" name="verified"/></td>
            <td><a href="javascript:void(0)"><img alt="验证码加载失败" src="VerificationCode"/></a></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="checkbox" name="remember"/>记住我</td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td colspan="2"><input type="submit" value="登录"/><input type="reset" value="重置"/></td>
        </tr>
    </table>
</form>
</body>
</html>
