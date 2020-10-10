<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title></title>
</head>
<body>

<c:choose>
<c:when test="${sessionScope.adminSuccess!=null||sessionScope.normalSuccess!=null}">
<form action="EditServlet" method="post">
    <table>
        <caption>修改用户信息</caption>
        <tr>
            <td>用户名:</td>
            <td colspan="2"><input type="text" name="username" disabled="disabled"/></td>
        </tr>
        </c:when>
        <c:otherwise>
        <form action="EditServlet" method="post">
            <table>
                <caption>注册页面</caption>
                <tr>
                    <td>用户名:</td>
                    <td colspan="2"><input type="text" name="username"/></td>
                </tr>
                </c:otherwise>
                </c:choose>
                <tr>
                    <td>性别:</td>
                    <td colspan="2"><input type="radio" name="gender" value="male" checked="checked"/>男
                        <input type="radio" name="gender" value="female"/>女
                    </td>
                </tr>
                <tr>
                    <td>生日:</td>
                    <td colspan="2"><input type="date" name="birthday"/></td>
                </tr>
                <tr>
                    <td>爱好:</td>
                    <td colspan="2">
                        <input type="checkbox" name="hobby" value="typeCode"/>敲代码
                        <input type="checkbox" name="hobby" value="writeBug"/>写BUG
                        <input type="checkbox" name="hobby" value="debug"/>改Bug
                        <input type="checkbox" name="hobby" value="sleep"/>睡觉
                    </td>
                </tr>
                <tr>
                    <td>出生城市:</td>
                    <td colspan="2">
                        <select name="city">
                            <option value="Beijing">北京</option>
                            <option value="Shanghai">上海</option>
                            <option value="Guangzhou">广州</option>
                            <option value="Shenzhen">深圳</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td colspan="2"><input type="submit" value="注册"/><input type="reset" value="重置"/></td>

                </tr>
            </table>
        </form>
</body>
</html>