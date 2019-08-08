<%--
  Created by IntelliJ IDEA.
  User: 70776
  Date: 2019/8/7
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>增加商品</h1>
<form action="" method="post">
    <input type="hidden" name="id" value="${product.id}"><br/>
    商品种类<input type="number" name="categoryId" value="${product.categoryId}"><br/>
    商品名称<input type="text" name="name" value="${product.name}"><br/>
    商品副标题<input type="text" name="subtitle" value="${product.subtitle}"><br/>
    主图片地址<input type="email" name="mainImage" value="${product.mainImage}"><br/>
    图片地址<input type="number" name="subImages" value="${product.subImages}"><br/>
    商品详情<input type="text" name="detail" value="${product.detail}"><br/>
    商品价格<input type="text" name="price" value="${product.price}"><br/>
    商品库存<input type="number" name="stock" value="${product.stock}"><br/>
    商品情况<input type="number" name="status" value="${product.status}"><br/>
    <input type="submit" value="修改"><br/>
</form>
</body>
</html>
