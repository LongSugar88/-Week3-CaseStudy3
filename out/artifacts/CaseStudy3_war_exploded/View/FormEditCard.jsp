<%--
  Created by IntelliJ IDEA.
  User: Mr Sugar
  Date: 6/9/2020
  Time: 5:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="myCard?action=sdfgdsgdg">Back</a>
<br>
<form method="post">
    <fieldset>
        <legend>Edit card</legend>
        <table>
            <c:if test="${card != null}">
                <input type="hidden" name="id" value="<c:out value='${card.id}' />"/>
            </c:if>
            <tr>
                <td>New name</td>
                <td><input type="text" name = "newName" value = '<c:out value="${card.name}"/>'></td>
            </tr>
            <tr>
                <td>New price</td>
                <td><input type="text" name = "newPrice" value = '<c:out value="${card.price}"/>'></td>
            </tr>
            <tr>
                <td>New quantity</td>
                <td><input type="text" name = "newQuantity" value = '<c:out value="${card.quantity}"/>'></td>
            </tr>
            <tr>
                <td>New image</td>
                <td><input type="text" name = "newImage" value = '<c:out value="${card.image}"/>'></td>
            </tr>
            <tr>
                <td><button>Save Change</button></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
