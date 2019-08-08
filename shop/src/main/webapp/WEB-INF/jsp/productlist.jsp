<%--
  Created by IntelliJ IDEA.
  User: 70776
  Date: 2019/8/7
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d" %>
<html>
<head>
    <title>商品列表</title>
    <table>
        <thead>
        <th>商品ID</th>
        <th>商品类型</th>
        <th>商品名</th>
        <th>商品副标题</th>
        <th>主图</th>
        <th>图片</th>
        <th>商品详情</th>
        <th>商品单价</th>
        <th>商品库存</th>
        <th>商品状态</th>
        <th>创建时间</th>
        <th>修改时间</th>
        <th>操作</th>
        </thead>
        <d:forEach items="${products}" var="product">

            <tr>

                <th>${product.id}</th>
                <th>${product.categoryId}</th>
                <th>${product.name}</th>
                <th>${product.subtitle}</th>
                <th>${product.mainImage}</th>
                <th>${product.subImages}</th>
                <th>${product.detail}</th>
                <th>${product.price}</th>
                <th>${product.stock}</th>
                <th>${product.status}</th>
                <th>${product.createTime}</th>
                <th>${product.updateTime}</th>
                <th><a href="update/${product.id}">修改</a> <a href="delete/${product.id}">删除</a></th>
            </tr>

        </d:forEach>

    </table>
</head>
<body>
<button type="submit" value="添加"><a href="add" >添加</a></button>
</body>
</html>
