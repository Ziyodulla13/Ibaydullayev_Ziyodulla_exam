
<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 24.09.2022
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit employee</title>
</head>
<body>
<form action="/employee" method="post">
    <input name="id" type="number" hidden value="${employee.id}">
    <label for="fullName">Employee Name</label>
    <input name="fullName" id="fullname" type="text" value="${employee.fullName}">
    <br>
    <label for="positionId">Position</label>
    <select name="positionId" id="positionId">
        <c:forEach items="${position}" var="position" varStatus="loop">
            <option value="${position.id}">${position.name}</option>
        </c:forEach>
    </select>
    <br>
    <label for="positionId">Department</label>
    <select name="departmentId" id="departmentId">
        <c:forEach items="${department}" var="department" varStatus="loop">
            <option value="${department.id}">${department.name}</option>
        </c:forEach>
    </select>
    <button type="submit">Save</button>
</form>
</body>
</html>
