<%--
  Created by IntelliJ IDEA.
  User: Mr Sugar
  Date: 6/10/2020
  Time: 11:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <fieldset>
        <legend>Administrator option</legend>
        <form method="post" action="/myCard?action=add">
            <tr>
                <td><a href="http://localhost:8080/myCard?action=add">Thêm card </a></td>
            </tr>
        </form>
        <form method="post" action="/myCard?action=update">
            <tr>
                <td><a href="http://localhost:8080/myCard?action=update">Sửa card </a></td>
            </tr>
        </form>
        <form method="post" action="/myCard?action=delete">
            <tr>
                <td><a href="http://localhost:8080/myCard?action=delete">Xóa card </a></td>
            </tr>
        </form>
    </fieldset>
</body>
</html>
