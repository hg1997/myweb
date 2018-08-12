<%--
  Created by IntelliJ IDEA.
  User: aa
  Date: 2017/8/2
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>login</title>
    <meta charset="utf-8"/>
    <!--导入外部的style-->
    <link href="${pageContext.request.contextPath}/jsp/css/login.css" rel="stylesheet" type="text/css"/>

</head>
<body>
<!--logo-->
<!-- ===================一条华丽的分割线======================== -->
<div id="logo">
    <strong class="L">L</strong>
    <strong class="O">o</strong>
    <strong class="G">g</strong>
    <strong class="I">i</strong>
    <strong class="N">n</strong>
</div>
<br/>
<br/>
<!-- ===================一条华丽的分割线======================== -->

<div id="login">
    <form action="${pageContext.request.contextPath}/login" method="post">
        <div id="welcome">Welcome</div>
        <!--用户名-->
        <div id="user">
            <span>用户:</span>&nbsp;
            <input type="text" name="username" id="uid" value="2015211"/>&nbsp;&nbsp;
        </div>
        <!--密码-->
        <div id="password">
            <span>密码:</span>&nbsp;
            <input type="password" name="password" id="pid" value="666"/>&nbsp;&nbsp;
        </div>
        <!--验证码-->
        <%--<div id="verifycode">
            <span>验证码:</span>&nbsp;
            <input type="text" name="verifycode" id="vid"/>&nbsp;&nbsp;
            <img src="${pageContext.request.contextPath}/verifyCode.action"  id="img">
        </div>--%>
        <!--登录-->
        <input type="submit" id="go" value="登录"/>&nbsp;&nbsp;
        <a href="#">忘记密码？</a>|
        <a href="#">立即注册</a>
    </form>
    ${msg}
</div>
<!--导入外部 js-->
<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/js/login.js"></script>
</body>
</html>
