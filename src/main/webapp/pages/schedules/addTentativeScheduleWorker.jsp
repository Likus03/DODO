<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>Indicate the time when you can work:</h4>
<form action="/addActionTentativeSchedule" method="post">
    <label>Date: ${date}<input type="hidden" name="dateWork" value="${date}"/></label><br>
    <input type="time" name="startTime">
    <input type="time" name="endTime">
    <input type="submit" value="add">
</form>
</body>
</html>
