<%@ page import="demos.LoginUserVo" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>修改密码页面</title>
    <link rel="stylesheet" href="css/commonCSS.css"/>
    <script type="text/javascript" src="js/modifyPwdJs.js"></script>
</head>
<body>
<form method="post" action="ModifyPwdServlet" onsubmit="return checkAll()">
    <table border="1">
        <thead>
        <th colspan="2">修改密码页面</th>
        <th><label for="oldPwd"></label><input type="hidden" id="oldPwd"
                                               value="<%=((LoginUserVo) session.getAttribute("loginKey")).getPassword()%>"/>
        </th>
        </thead>
        <tbody>
        <tr>
            <td>原密码：</td>
            <td><label for="inputOldPwd"></label><input type="text" placeholder="请输入原密码" id="inputOldPwd"
                                                        onblur="isOldPwd()"></td>
            <td id="ckOldPwd"></td>
        </tr>
        <tr>
            <td>新密码：</td>
            <td><label for="inputNewPwd"></label><input type="password" placeholder="请输入新密码" id="inputNewPwd"
                                                        name="newPwd"></td>
            <td></td>
        </tr>
        <tr>
            <td>确认新密码：</td>
            <td><label for="inputRePwd"></label><input type="password" placeholder="请输入密码" id="inputRePwd"></td>
            <td id="ckReNewPwd"></td>
        </tr>
        </tbody>
        <tfoot>
        <tr>
            <td></td>
            <td><input type="submit" value="提交" id="commit"/>
                <input type="reset" value="重置"/></td>
            <td></td>
        </tr>
        </tfoot>
    </table>
</form>
</body>
</html>