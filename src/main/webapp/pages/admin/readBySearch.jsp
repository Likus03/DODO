<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Search</title>
</head>
<body>
<form action="/readBySearch" method="post">
    <input type="text" name="inputSearch" placeholder="put your parameter">
    <input type="submit" name="buttonSearch" value="search">
</form>
<br>
<br>
<table width="50%" border="1" rules="all">
    <thead>
    <tr>
        <th>NAME</th>
        <th>FAMILY</th>
        <th>phoneNumber</th>
        <th>ROLE</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="workers" items="${workers}">
        <tr>
            <td>${workers.firstname}</td>
            <td>${workers.surname}</td>
            <td>${workers.phoneNumber}</td>
            <td>${workers.workerType}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
