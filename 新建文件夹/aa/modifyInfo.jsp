<%@ page import="demos.LoginUserVo" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>修改用户信息页面</title>
    <link rel="stylesheet" href="css/commonCSS.css">
    <script type="text/javascript" src="js/registerScript.js"></script>
</head>
<body>
<%
    LoginUserVo luv = (LoginUserVo) request.getAttribute("key");
%>
<form method="post" action="ModifyInfo" onsubmit="return checkAll()">
    <table border="0">
        <thead>
        <th colspan="3">修改用户信息页面</th>
        </thead>
        <tbody>
        <tr>
            <td>用户名：</td>
            <td><label>
                <input type="text" readonly="readonly" value="<%=luv.getName()%>" name="name"/>
            </label></td>
            <td></td>
        </tr>
        <tr>
            <td>性别：</td>
            <%
                if ("male".equals(luv.getSex())) {
            %>
            <td>
                🚹
                <label>
                    <input type="radio" checked="checked" value="male" name="gender"/>
                </label>
                &nbsp;&nbsp;🚺
                <label>
                    <input type="radio" value="female" name="gender"/>
                </label></td>
            <%
            } else {
            %>
            <td>
                🚹
                <label>
                    <input type="radio" value="male" name="gender"/>
                </label>
                &nbsp;&nbsp;🚺
                <label>
                    <input type="radio" checked="checked" value="female" name="gender"/>
                </label>
            </td>
            <%
                }
            %>
            <td></td>
        </tr>
        <tr>
            <td>出生城市：</td>
            <td><label>
                <select name="city">
                    <optgroup label="---请选择---">
                        <option value="Beijing" <%if ("Beijing".equals(luv.getCity())){%>selected="selected"<%}%>>北京
                        </option>
                        <option value="Shanghai" <%if ("Shanghai".equals(luv.getCity())){%>selected="selected"<%}%>>上海
                        </option>
                        <option value="Guangzhou" <%if ("Guangzhou".equals(luv.getCity())){%>selected="selected"<%}%>>广州
                        </option>
                        <option value="Shenzhen" <%if ("Shenzhen".equals(luv.getCity())){%>selected="selected"<%}%>>深圳
                        </option>
                    </optgroup>
                </select>
            </label></td>
            <td></td>
        </tr>
        <tr>
            <td>邮箱：</td>
            <td><label for="email"></label><input type="text" placeholder="请输入邮箱" value="<%=luv.getEmail()%>" id="email"
                                                  name="email"/></td>
            <td id="warnEmail"></td>
        </tr>
        <tr>
            <td>爱好：</td>
            <td><label>
                <input type="checkbox" value="dine" name="hobby"
                       <%if(luv.getHobby().contains("dine")){%>checked=checked<%}%>/>
            </label>
                吃饭
                <label>
                    <input type="checkbox" value="sleep" name="hobby"
                           <%if(luv.getHobby().contains("sleep")){%>checked=checked<%}%>/>
                </label>
                睡觉
                <label>
                    <input type="checkbox" value="playPhone" name="hobby"
                           <%if (luv.getHobby().contains("playPhone")){%>checked=checked<%}%>/>
                </label>
                玩手机
                <label>
                    <input type="checkbox" value="typeCodes" name="hobby"
                           <%if (luv.getHobby().contains("typeCodes")){%>checked=checked<%}%>/>
                </label>
                敲代码
                <label>
                    <input type="checkbox" value="playGames" name="hobby"
                           <%if (luv.getHobby().contains("playGames")){%>checked=checked<%}%>/>
                </label>
                玩游戏
            </td>
            <td></td>
        </tr>
        </tbody>
        <tfoot>
        <tr>
            <td></td>
            <td><input type="submit" value="修改"/>
                <input type="reset" value="重置"/></td>
            <td></td>
        </tr>
        </tfoot>
    </table>
</form>
</body>
</html>