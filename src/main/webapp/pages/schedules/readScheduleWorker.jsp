<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Schedule Worker</title>
    <style>
        .day-cell {
            width: 170px;
            height: 50px;
            text-align: center;
        }
    </style>
</head>
<body>
<form action="/readSchedule" method="post">
    <input type="date" name="calendar">
    <input type="submit" name="inputSearch">
</form>
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
    <tbody class="day-cell">
    <c:forEach var="schedules" items="${schedules}">
        <c:choose>
            <c:when test="${empty schedules.startTime}">
                <td>${schedules.dateWork}<br><br>
                    day-off
                </td>
            </c:when>
            <c:when test="${not empty schedules.startTime}">
                <td>${schedules.dateWork}<br><br>
                        ${fn:substring(schedules.startTime, 0, 5)}-${fn:substring(schedules.endTime, 0, 5)}</td>
            </c:when>
        </c:choose>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
