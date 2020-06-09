<%--
  Created by IntelliJ IDEA.
  User: Mr Sugar
  Date: 6/4/2020
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        th{
            text-align: center;
        }
        tr{
            border: 1px solid;
        }
    </style>
</head>
<body>
<h1 style="color: deeppink">Long đẹp trai</h1>

<a href="?action=creat">Add New Card</a>
<br>
<a href="?action=find">Find Card By Name</a>
<br>
<table border ="1" cellpadding="5" style="border-collapse: collapse">
    <th>ID</th>
    <th>Name</th>
    <th>Price</th>
    <th>Quantity</th>
    <th colspan="2">Option</th>
    <c:forEach items="${myCardList}" var= "mycard">
        <tr>
            <td>${mycard.id}</td>
            <td>${mycard.name}</td>
            <td>${mycard.price}</td>
            <td>${mycard.quantity}</td>
            <td><a href="?action=edit&id=${mycard.id}">Edit</a></td>
            <td><a href="?action=delete&id=${mycard.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
