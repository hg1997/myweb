<%@ page import="edu.cqupt.domain.Stu" isELIgnored="false" %><%--
  Created by IntelliJ IDEA.
  User: aa
  Date: 2017/7/14
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>信息展示页面</title>
</head>
<body bgcolor="#f5f5dc">

<h1 align="center">信息展示页面</h1>
<table  align="center" border="1" cellspacing="0" width="50%">
    <tr>
        <th>学生姓名</th>
        <th>年龄</th>
        <th>地址</th>
        <th>老师</th>
    </tr>

    <c:forEach items="${map.stu}" var="student">
    <tr  align="center">
        <td>${student.sname}</td>
        <td>${student.age}</td>
        <td>${student.addr}</td>
        <td>${student.tid}</td>
    </tr>
    </c:forEach>
</table>
<br/><br/>
<center style="color: red"><============================一条华丽的分割线=================================></center>
<br/><br/>
<table  align="center" border="1" cellspacing="0" width="50%">
    <tr>
        <th>编号</th>
        <th>老师姓名</th>
        <th>年龄</th>
        <th>课程</th>
    </tr>

    <c:forEach items="${map.teacher}" var="teacher">
        <tr  align="center">
            <td>${teacher.tid}</td>
            <td>${teacher.tname}</td>
            <td>${teacher.age}</td>
            <td>${teacher.course}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
