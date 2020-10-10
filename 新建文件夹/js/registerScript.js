function checkName() {
    const obj = document.getElementById("name").value;
    const regExp = /^[a-zA-Z0-9_\u4e00-\u9fa5]{2,5}$/;
    if (obj === "" || !regExp.test(obj)) {
        document.getElementById("warnName").style.color = "red";
        document.getElementById("warnName").innerHTML = "用户名不能为空或输入不符合规范!";
        return false;
    } else {
        document.getElementById("warnName").style.color = "lightblue";
        document.getElementById("warnName").innerHTML = "√"
        return true;
    }
}

function checkPwd() {
    checkRePwd();
    const obj = document.getElementById("password").value;
    if (obj === "" || obj.length < 6) {
        document.getElementById("warnPwd").style.color = "red";
        document.getElementById("warnPwd").innerHTML = "密码不能为空或密码长度有误!";
        return false;
    } else {
        document.getElementById("warnPwd").style.color = "lightblue";
        document.getElementById("warnPwd").innerHTML = "√";
        return true;
    }
}

function checkRePwd() {
    const obj = document.getElementById("rePassword").value;
    if (document.getElementById("password").value === "" || document.getElementById("password").value.length < 6) {
        document.getElementById("warnRePwd").style.color = "red";
        document.getElementById("warnRePwd").innerHTML = "原密码不能为空或原密码长度有误!";
        return false;
    } else if (obj === "" || obj !== document.getElementById("password").value) {
        document.getElementById("warnRePwd").style.color = "red";
        document.getElementById("warnRePwd").innerHTML = "重复密码不能为空或两次密码不一致!";
        return false;
    } else {
        document.getElementById("warnRePwd").style.color = "lightblue";
        document.getElementById("warnRePwd").innerHTML = "√";
        return true;
    }
}

function checkEmail() {
    const obj = document.getElementById("email").value;
    const regExp = /\w+([-+.]\w+)*@\w+([-.]\w+)*.\w+([-.]\w+)*/;
    if (obj === "" || !regExp.test(obj)) {
        document.getElementById("warnEmail").style.color = "red";
        document.getElementById("warnEmail").innerHTML = "邮箱不能为空或输入不规范!";
        return false;
    } else {
        document.getElementById("warnEmail").style.color = "lightblue";
        document.getElementById("warnEmail").innerHTML = "√";
        return true;
    }
}

function getCode() {
    if (checkEmail()) {
        let random = "";
        for (let i = 0; i < 5; i++) {
            random += Math.floor(Math.random() * 10);
        }
        document.getElementById("realCode").value = random;
        const email = document.getElementById("email").value;
        let ajaxObject;
        if (window.XMLHttpRequest) {
            ajaxObject = new XMLHttpRequest();
        }
        ajaxObject.open("post", "EmailHelper", true);
        ajaxObject.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        ajaxObject.send("method=EmailHelper&email=" + email + "&random=" + random);
        ajaxObject.onreadystatechange = function () {
            if (ajaxObject.status === 200) {
                let second = 60;
                const countDown = window.setInterval(function () {
                    second -= 1;
                    document.getElementById("showTime").value = second + "秒后重新获取";
                    document.getElementById("showTime").disabled = true;
                    if (second < 0) {
                        window.clearInterval(countDown);
                        document.getElementById("showTime").disabled = false;
                        document.getElementById("showTime").value = "重新获取验证码";
                    }
                }, 1000);
            }
        }
    }
}

function checkCode() {
    const random = document.getElementById("realCode").value;
    const input = document.getElementById("inputCode").value;
    if (random !== "" && random === input) {
        return true;
    } else {
        alert("请先获取验证码或验证码输入错误！");
        return false;
    }
}

function checkAgree() {
    const obj = document.getElementById("agree").checked;
    if (obj) {
        document.getElementById("commit").disabled = false;
        document.getElementById("warnAgree").style.color = "lightblue";
        document.getElementById("warnAgree").innerHTML = "√";
    } else {
        document.getElementById("commit").disabled = true;
        document.getElementById("warnAgree").style.color = "red";
        document.getElementById("warnAgree").innerHTML = "请同意协议!";
    }
}

function checkAll() {
    const nameResult = checkName();
    const PwdResult = checkPwd();
    const rePwdResult = checkRePwd();
    const emailResult = checkEmail();
    const codeResult = checkCode();
    const hobbyResult = function () {
        let count = 0;
        const obj = document.getElementsByName("hobby");
        for (let i = 0; i < obj.length; i++) {
            if (obj[i].checked) {
                count++;
            }
        }
        if (count < 2) {
            alert("爱好至少选择两个!");
            return false;
        } else {
            return true;
        }
    }
    return nameResult && PwdResult && rePwdResult && emailResult && codeResult && hobbyResult();
}
