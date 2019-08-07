<%--
  Created by IntelliJ IDEA.
  User: 70776
  Date: 2019/8/7
  Time: 8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理</title>
</head>
<body>
<title>Title</title>
<table>
    <thead>
    <th>用户ID</th>
    <th>用户名称</th>
    <th>用户密码</th>
    <th>用户邮箱</th>
    <th>用户电话</th>
    <th>密保问题</th>
    <th>密码答案</th>
    <th>用户权限</th>
    <th>创建时间</th>
    <th>修改时间</th>
    </thead>
    <c:forEach items="${managerlist}" var="userinfo">
        <tr>
            <th>${userinfo.id}</th>
            <th>${userinfo.username}</th>
            <th>${userinfo.password}</th>
            <th>${userinfo.email}</th>
            <th>${userinfo.phone}</th>
            <th>${userinfo.question}</th>

            <th>${userinfo.answer}</th>

            <th>${userinfo.role}</th>

            <th>${userinfo.createTime}</th>

            <th>${userinfo.updateTime}</th>
            <th><a href="update/${userinfo.id}">修改</a> <a href="">删除</a></th>
        </tr>

    </c:forEach>


</table>
</body>
</html>
