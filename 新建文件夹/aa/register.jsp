<%@ page import="java.time.LocalDateTime" %>
<%@ page import="demos.LoginUserVo" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>注册页面</title>
    <link rel="stylesheet" href="css/commonCSS.css">
    <script type="text/javascript" src="js/registerScript.js"></script>
</head>
<body>
<%
    LoginUserVo u = (LoginUserVo) session.getAttribute("loginKey");
    if (u == null || !"teacher".equals(u.getRole())) {
%>
<form method="post" action="RegisterServlet" onsubmit="return checkAll()">
    <table border="0">
        <thead>
        <th colspan="2">新用户注册表单</th>
        </thead>
            <%
        }else {
        %>
        <form method="post" action="RegisterServlet" onsubmit="return checkAll()">
            <table border="0">
                <thead>
                <th colspan="2">添加学生页面</th>
                </thead>
                <%
                    }
                %>
                <tbody>
                <tr>
                    <td>用户名：</td>
                    <td><label for="name"></label><input onblur="checkName()" type="text" placeholder="请输入用户名" id="name"
                                                         minlength="2"
                                                         maxlength="5"
                                                         name="name"></td>
                    <td id="warnName"></td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td><label for="password"></label><input onblur="checkPwd()" type="password" placeholder="请输入密码"
                                                             id="password" maxlength="6"
                                                             name="password"></td>
                    <td id="warnPwd"></td>
                </tr>
                <tr>
                    <td>确认密码：</td>
                    <td><label for="rePassword"></label><input onblur="checkRePwd()" type="password" placeholder="请输入密码"
                                                               id="rePassword"></td>
                    <td id="warnRePwd"></td>
                </tr>
                <tr>
                    <td>性别：</td>
                    <td>🚹
                        <label>
                            <input type="radio" checked="checked" value="male" name="gender"/>
                        </label>
                        &nbsp;&nbsp;🚺
                        <label>
                            <input type="radio" value="female" name="gender"/>
                        </label></td>
                    <td></td>
                </tr>
                <tr>
                    <td>出生日期：</td>
                    <td><label>
                        <input type="date" name="birthday"/>
                    </label></td>
                    <td></td>
                </tr>
                <tr>
                    <td>出生城市：</td>
                    <td><label>
                        <select name="city">
                            <optgroup label="---请选择---">
                                <option value="Beijing">北京</option>
                                <option value="Shanghai">上海</option>
                                <option value="Guangzhou">广州</option>
                                <option value="Shenzhen">深圳</option>
                            </optgroup>
                        </select>
                    </label></td>
                    <td></td>
                </tr>
                <tr>
                    <td>邮箱：</td>
                    <td><label for="email"></label><input onblur="checkEmail()" type="email" placeholder="请输入邮箱"
                                                          id="email" name="email"/></td>
                    <td id="warnEmail"></td>
                </tr>
                <tr>
                    <td>验证码：</td>
                    <td><label for="inputCode"></label><input type="number" id="inputCode"/>
                        <input type="button" onclick="getCode()" value="获取验证码" id="showTime"/>
                    </td>
                    <td><input type="hidden" id="realCode" onblur="checkCode()"/></td>
                </tr>
                <tr>
                    <td>爱好：</td>
                    <td><label>
                        <input type="checkbox" value=" dine" name="hobby"/>
                    </label>
                        吃饭
                        <label>
                            <input type="checkbox" value="sleep" name="hobby"/>
                        </label>
                        睡觉
                        <label>
                            <input type="checkbox" value="playPhone" name="hobby"/>
                        </label>
                        玩手机
                        <label>
                            <input type="checkbox" value="typeCodes" name="hobby"/>
                        </label>
                        敲代码
                        <label>
                            <input type="checkbox" value="playGames" name="hobby"/>
                        </label>
                        玩游戏
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td>最喜欢的颜色：</td>
                    <td><label>
                        <input type="color"/>
                    </label></td>
                    <td></td>
                </tr>
                <tr>
                    <td>头像：</td>
                    <td><input type="file"/></td>
                    <td></td>
                </tr>
                <tr>
                    <td>手机号码：</td>
                    <td><label>
                        <input type="tel"/>
                    </label></td>
                    <td></td>
                </tr>
                <tr>
                    <td>验证码：</td>
                    <td><label>
                        <input type="number"/>
                    </label><input type="button" value="获取验证码" disabled="disabled"/>
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td>注册身份：</td>
                    <td><label>
                        <input type="radio" checked="checked" name="role"/>
                    </label>学生&nbsp;<label>
                        <input type="radio" name="role"
                               disabled="disabled"/>
                    </label>老师
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td>所在地：</td>
                    <td>
                        <div>
                            <iframe width="325" height="280" frameborder="0"
                                    src="https://cn.bing.com/maps/embed?h=280&w=325&cp=22.63178054164227~113.8318361870363&lvl=14&typ=d&sty=r&src=SHELL&FORM=MBEDV8"
                                    scrolling="no">
                            </iframe>
                        </div>
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td>离我有多远：</td>
                    <td><label>
                        <input type="range"/> 米
                    </label>
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td>请阅读以下协议：</td>
                    <td><label>
    <textarea rows="10">
        协议，网络协议的简称，网络协议是通信计算机双方必须共同遵从的一组约定。如怎么样建立连接、怎么样互相识别等。只有遵守这个约定，计算机之间才能相互通信交流。它的三要素是：语法、语义、时序。
        为了使数据在网络上从源到达目的，网络通信的参与方必须遵循相同的规则，这套规则称为协议（protocol），它最终体现为在网络上传输的数据包的格式。
        协议往往分成几个层次进行定义，分层定义是为了使某一层协议的改变不影响其他层次的协议。
    </textarea>
                    </label>
                        <label for="agree"></label><input type="checkbox" id="agree" onclick="checkAgree()"/>
                        同意
                    </td>
                    <td id="warnAgree"></td>
                </tr>
                </tbody>
                <tfoot>
                <tr>
                    <td></td>
                    <td><input type="submit" value="提交" disabled="disabled" id="commit"/>
                        <input type="reset" value="重置"/></td>
                    <td></td>
                </tr>
                </tfoot>
            </table>
        </form>
</body>
</html>