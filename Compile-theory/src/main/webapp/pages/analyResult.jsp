<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/5/18
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="utf-8">
    <title>词法分析系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../css/my.css">
</head>
<script>

</script>
<body>
<div class="box">
    <h2>词法分析结果</h2>
    <h5>如下表所示:</h5>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>行数</th>
            <th>种别编码</th>
            <th>符号</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${worksList}" var="wo" varStatus="c">
            <tr>
                <th>${c.count}</th>
                <th>${wo.typeCode}</th>
                <th>${wo.word}</th>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>
</html>
