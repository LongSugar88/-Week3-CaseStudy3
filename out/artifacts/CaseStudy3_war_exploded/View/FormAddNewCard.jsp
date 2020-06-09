<%--
  Created by IntelliJ IDEA.
  User: Mr Sugar
  Date: 6/9/2020
  Time: 10:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="myCard?action=sdfgdsgdg">Back</a>
<form method="post">
    <fieldset>
        <legend>Add new card</legend>
        <table>
            <tr>
                <td>ID</td>
                <td><input type="text" name = "newID" placeholder="ID"></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name = "newName" placeholder="ID"></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><input type="text" name = "newPrice" placeholder="ID"></td>
            </tr>
            <tr>
                <td>Quantity</td>
                <td><input type="text" name = "newQuantity" placeholder="ID"></td>
            </tr>
            <tr>
                <td>
                    <button>Add</button>
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
