<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 24.09.2022
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Department list</title>
</head>
<body>
<table>

    <a href="/department/get-form">Add new department</a>
    <c:forEach items="${department}" var="department" varStatus="loop">
        <h1>${department.name}</h1>
        <p>${department.description}</p>
        <a href="/department/edit/${department.id}">Edit</a><br>
        <a href="/department/delete/${department.id}">Delete</a>

    </c:forEach>
</table>
</body>
</html>
