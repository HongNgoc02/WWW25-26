<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 15/09/2025
  Time: 2:02 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User List</title>
    <style>
        body { font-family: Arial, sans-serif; display: flex; flex-direction: column; align-items: center; padding-top: 50px; }
        table { border-collapse: collapse; width: 80%; max-width: 800px; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }
        th { background-color: #f2f2f2; }
        tr:nth-child(even) { background-color: #f9f9f9; }
        tr:hover { background-color: #f1f1f1; }
        a { color: #007bff; text-decoration: none; margin-top: 20px; }
        a:hover { text-decoration: underline; }
    </style>
</head>
<body>
<h1>Registered Users</h1>
<table border="1">
    <thead>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="register">Back to Registration Form</a>

</body>
</html>
