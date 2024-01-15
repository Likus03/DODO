<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>to Update</title>

    <style type="text/css">
        th {
            color: lightblue;
            font-family: Arial
        }
    </style>

</head>
<body>
<h3 style="text-align: center">Choose to update</h3>
<table width="50%" border="1" rules="all">
    <thead>
    <tr>
        <th>name</th>
        <th>family</th>
        <th>phone Number</th>
        <th>role</th>
    </tr>
    </thead>
    <tbody>
    <form action="/updateAction" method="post">
        <c:forEach var="workers" items="${workers}">
        <tr>
            <td>${workers.firstname}</td>
            <td>${workers.surname}</td>
            <td>${workers.phoneNumber}</td>
            <td>${workers.workerType}</td>
            <td><input type="radio" name="id" value="${workers.idWorker}"></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<input type="submit" name="updateWorker" value="update">
<button><a href="/pages/admin/admin.jsp">Back</a></button>
<form action="/logOut" method="get">
    <input style="font-size: 20px" type="submit" value="LogOut">
</form>
</body>
</html>
