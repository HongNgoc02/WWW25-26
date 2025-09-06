<%@ page import="fit.se.bai2.Account" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 06/09/2025
  Time: 4:45 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách tài khoản</title>
</head>
<body>
    <h1>Danh sách tài khoản đã đăng ký</h1>
    <table>
        <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Birthday</th>
            <th>Gender</th>
        </tr>
        </thead>
        <tbody>
        <% List<Account> accounts = (List<Account>) request.getAttribute("accounts"); %>
        <% if (accounts != null) { %>
        <% for (Account account : accounts) { %>
        <tr>
            <td><%= account.getFirstName() %></td>
            <td><%= account.getLastName() %></td>
            <td><%= account.getEmail() %></td>
            <td><%= account.getBirthday() %></td>
            <td><%= account.getGender() %></td>
        </tr>
        <% } %>
        <% } %>
        </tbody>
    </table>
</body>
</html>
