<%--
  Created by IntelliJ IDEA.
  User: 70776
  Date: 2019/8/7
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d" %>
<html>
<head>
    <title>用户</title>
    <table>
        <thead>
        <th>类别ID</th>
        <th>用户名</th>
        <th>密码</th>
        <th>邮箱</th>
        <th>电话</th>
        <th>密保问题</th>
        <th>答案</th>
        <th>权限</th>
        <th>创建时间</th>
        <th>修改时间</th>
        <th>操作</th>
        </thead>
        <d:forEach items="${userInfolist}" var="userInfo">

            <tr>

                <th>${userInfo.id}</th>
                <th>${userInfo.username}</th>
                <th>${userInfo.password}</th>
                <th>${userInfo.email}</th>
                <th>${userInfo.phone}</th>
                <th>${userInfo.question}</th>
                <th>${userInfo.answer}</th>
                <th>${userInfo.role}</th>
                <th>${userInfo.createTime}</th>
                <th>${userInfo.updateTime}</th>
                <th><a href="update/${userInfo.id}">修改</a> <a href="delete/${userInfo.id}">删除</a></th>
            </tr>

        </d:forEach>

    </table>

</head>
<body>
<button type="submit" value="添加"><a href="add" >添加</a></button>
</body>
</html>
