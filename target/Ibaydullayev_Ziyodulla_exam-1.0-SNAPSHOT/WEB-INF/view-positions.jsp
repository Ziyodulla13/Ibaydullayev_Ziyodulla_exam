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
    <title>Position list</title>
</head>
<body>
<table>

    <a href="/position/get-form">Add new position</a>
    <c:forEach items="${position}" var="position" varStatus="loop">
        <h1>${position.name}</h1>
        <p>${position.description}</p>
        <a href="/position/edit/${position.id}">Edit</a>
        <a href="/position/delete/${position.id}">Delete</a>

    </c:forEach>
</table>
</body>
</html>
