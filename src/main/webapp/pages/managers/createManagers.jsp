<html>
<head>Create new Manager</head>
<body>
<table>
    <thead>
    <tr>
        <th>firstname</th>
        <th>family</th>
        <th>phoneNumber</th>
        <th>login</th>
        <th>password</th>
        <th>role</th>
    </tr>
    </thead>
    <tbody>
    <form action="/managers/create" method="post">
        <tr>
            <td><input type="text" name="firstname" placeholder="put your firstname"></td>
            <td><input type="text" name="surname" placeholder="put your surname"></td>
            <td><input type="text" name="phoneNumber" placeholder="put your phone number"></td>
            <td><input type="text" name="login" placeholder="put your login"></td>
            <td><input type="text" name="password" placeholder="put your password"></td>
            <td><input type="text" name="role" placeholder="put your role"></td>
            <td><input type="submit" name="buttonCreate" value="create"></td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>
