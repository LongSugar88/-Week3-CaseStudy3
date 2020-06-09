<%--
  Created by IntelliJ IDEA.
  User: Mr Sugar
  Date: 6/9/2020
  Time: 11:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method = post>
    <fieldset>
        <legend>Find card</legend>
        <table>
            <tr>
                <td>Name card</td>
                <td><input type="text" name = "cardName"></td>
            </tr>
            <tr><button>Find</button></tr>
            <c:forEach items="${listCard}" var="mycard">
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
    </fieldset>
</form>
</body>
</html>
