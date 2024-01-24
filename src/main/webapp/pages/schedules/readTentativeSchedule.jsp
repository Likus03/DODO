<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Tentative schedule</title>
    <style>
        .day-cell {
            width: 170px;
            height: 50px;
            text-align: center;
        }
    </style>
</head>
<body>
<form action="/readTentativeSchedule" method="post">
    <input type="date" name="calendar">
    <input type="submit" name="inputSearch">
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
    <c:forEach var="tentativeSchedules" items="${tentativeSchedules}">
        <c:choose>
            <c:when test="${empty tentativeSchedules.startTime}">
                <td>${tentativeSchedules.dateWork}<br><br>
                    day-off
                </td>
            </c:when>
            <c:when test="${not empty tentativeSchedules.startTime}">
                <td style="font-weight: bold">${tentativeSchedules.dateWork}<br><br>
                        ${fn:substring(tentativeSchedules.startTime, 0, 5)}-${fn:substring(tentativeSchedules.endTime, 0, 5)}</td>
            </c:when>
        </c:choose>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
