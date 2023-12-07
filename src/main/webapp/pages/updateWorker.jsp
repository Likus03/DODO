<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<title>Update Courier</title>
<head>Update Courier</head>
<body>
<table>
    <thead>
    <tr>
        <th>firstname</th>
        <th>family</th>
        <th>phoneNumber</th>
        <th>deliveryType</th>
    </tr>
    </thead>
    <tbody>
    <form action="/read" method="post">
        <tr>

            <td><input type="text" name="firstname" value="${courier.firstname}"></td>
            <td><input type="text" name="surname" value="${courier.surname}"></td>
            <td><input type="text" name="phoneNumber" value="${courier.phoneNumber}"></td>
            <td><input type="submit" name="buttonCreate" value="update"></td>
            <td><input type="hidden" name="id" value="${courier.id}" ></td>
            <td><input type="hidden" name="login" value="${courier.login}"></td>
            <td><input type="hidden" name="password" value="${courier.password}"></td>
            <td><input type="hidden" name="role" value="${courier.userType}"></td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>
