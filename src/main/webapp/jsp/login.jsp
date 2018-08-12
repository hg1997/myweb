<%--
  Created by IntelliJ IDEA.
  User: aa
  Date: 2017/8/2
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>login</title>
    <meta charset="utf-8"/>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <!--用户名-->
        用户: <input type="text" name="username" id="uid" value="2015211"/><br/>
        <!--密码-->
        密码:<input type="password" name="password" id="pid" value="666"/><br/>
        <%--登录--%>
        <input type="submit" vlaue="登录">
    </form>
</div>
</body>
</html>
