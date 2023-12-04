<html>
<head>Create new Manager</head>
<body>
<table>
    <thead>
    <tr>
        <th>firstname</th>
        <th>family</th>
        <th>phoneNumber</th>
    </tr>
    </thead>
    <tbody>
    <form action="/managers/create" method="post">
        <tr>
            <td><input type="text" name="firstname" placeholder="put your firstname"></td>
            <td><input type="text" name="surname" placeholder="put your surname"></td>
            <td><input type="text" name="phoneNumber" placeholder="put your phone number"></td>
            <td><input type="submit" name="buttonCreate" value="create"></td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>
