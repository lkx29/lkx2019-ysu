<%--
  Created by IntelliJ IDEA.
  User: 70776
  Date: 2019/8/7
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>添加用户</h1>
<form action="" method="post">
    <input type="hidden" name="id" value="${userInfo.id}"><br/>
    用户名<input type="text" name="username" value="${userInfo.username}"><br/>
    密码<input type="password" name="password" value="${userInfo.password}"><br/>
    邮箱<input type="email" name="email" value="${userInfo.email}"><br/>
    电话<input type="number" name="phone" value="${userInfo.phone}"><br/>
    问题<input type="text" name="question" value="${userInfo.question}"><br/>
    答案<input type="text" name="answer" value="${userInfo.answer}"><br/>
    权限<input type="number" name="role" value="${userInfo.role}"><br/>
    <input type="submit" value="修改"><br/>
</form>
</body>
</html>
