<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
    <script type="text/javascript" src="js/loginJs.js"></script>
    <link rel="stylesheet" href="css/commonCSS.css"/>
</head>
<body>
<%
    String name = "";
    String password = "";
    Cookie[] cs = request.getCookies();
    if (cs != null) {
        for (Cookie c : cs) {
            if (c.getName().equals("name")) {
                name = URLDecoder.decode(c.getValue(), StandardCharsets.UTF_8);
            } else if (c.getName().equals("password")) {
                password = c.getValue();
            }
        }
    }
    Object error = request.getAttribute("error");
    if (error != null) {
%>
<script>alert("<%=request.getAttribute("error")%>");</script>
<%
    }
%>
<form method="post" action="LoginServlet" id="login">
    <table>
        <th colspan="3"><h3>登陆页面</h3></th>
        <tr>
            <td>用户名:</td>
            <td><label>
                <input type="text" name="name" value="<%=name%>"/>
            </label></td>
            <td></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><label>
                <input type="password" name="password" value="<%=password%>"/>
            </label></td>
            <td></td>
        </tr>
        <tr>
            <td>登录身份:</td>
            <td><label>
                <input type="radio" name="role" value="student" checked="checked"/>
            </label>学生<label>
                <input type="radio" name="role"
                       value="teacher"/>
            </label>老师
            </td>
            <td></td>
        </tr>
        <tr>
            <td>验证码:</td>
            <td><label for="code"></label><input type="text" id="code" onblur="isCode()" name="code"/></td>
            <td><a href="javascript:void(0)" onclick="cannotSee()"><img src="CheckCodeServlet" id="ckCode"
                                                                        alt="" title="证明你不是一个机器人"/></a></td>
        </tr>
        <tr>
            <td></td>
            <td><label>
                <input type="checkbox" name="rememberMe"/>
            </label>记住我
            </td>
            <td><a href="forgetPassword.html">忘记密码？</a></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="登录"><input type="reset" value="重置"></td>
            <td></td>
        </tr>
    </table>
</form>
</body>
</html>