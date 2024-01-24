<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Schedule Worker</title>
</head>
<body>
<table width="50%" border="1" rules="all">
    <thead>
    <tr>
        <th>Monday</th>
        <th>Tuesday</th>
        <th>Wednesday</th>
        <th>Thursday</th>
        <th>Friday</th>
        <th>Saturday</th>
        <th>Sunday</th>
    </tr>
    </thead>
    <tbody>
    <form action="/addTentativeSchedule" method="post">
        <c:forEach var="day" items="${weekList}">
            <td><input type="submit" name="date" value="${day}"></td>
        </c:forEach>
    </form>
    </tbody>
</table>
</body>
</html>
