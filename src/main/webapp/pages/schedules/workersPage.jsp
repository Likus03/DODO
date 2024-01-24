<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Welcome!</h2>
<form action="/readSchedule" method="get">
    <input type="submit" value="read schedule">
</form>
<form action="/readTentativeSchedule" method="get">
    <input type="submit" value="read tentative schedule">
</form>
<form action="/addActionTentativeSchedule" method="get">
    <input type="submit" value="add tentative schedule">
</form>
</body>
</html>
