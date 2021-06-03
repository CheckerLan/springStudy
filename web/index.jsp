<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/3
  Time: 0:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<body>

<h1>乱码测试</h1>
<form action="testCharset">
    <input type="number" name="did">
    <input type="text" name="dname">
    <input type="submit">
</form>

<H1>RESTTest</H1>

<a href="restTest/book/1">getBook</a>

<form action="restTest/book/2" method="post">
    <input type="submit">
</form>

<form action="restTest/book/3" method="post">
    <input type="text" name="_method" value="delete">
    <input type="submit">
</form>

<form action="restTest/book" method="post">
    <input type="text" name="_method" value="put">
    <input type="submit">
</form>

<hr/>

<h1>TestParam</h1>

<a href="testParam?value=1">testParam_value</a>
<br>
<%--配置了RequestParam后，会导致原本的按名字匹配失效--%>
<a href="testParam?val=2">testParam_val</a>
<br>
<a href="testParam">testParam_null</a>

</body>
</html>
