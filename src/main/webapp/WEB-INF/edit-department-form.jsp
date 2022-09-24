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
    <title>Edit department</title>
</head>
<body>
<form action="/department/edit" method="post">
    <input name="id" type="number" hidden value="${department.id}">
    <label for="name">Department Name</label>
    <input name="name" id="name" type="text" value="${department.name}">
    <br>
    <label for="description">Description</label>
    <input name="description" id="description" type="text" value="${department.description}">
    <br>
    <button type="submit">Save</button>
</form>
</body>
</html>
