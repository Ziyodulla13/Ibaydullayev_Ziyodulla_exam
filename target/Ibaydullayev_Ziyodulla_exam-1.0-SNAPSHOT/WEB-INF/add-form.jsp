<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 24.09.2022
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add position</title>
</head>
<body>
<form action="/position" method="post">
    <label for="name">Position Name</label>
    <input name="name" id="name" type="text">
    <br>
    <label for="description">Description</label>
    <input name="description" id="description" type="text">
    <br>
    <button type="submit">Save</button>
</form>
</body>
</html>
