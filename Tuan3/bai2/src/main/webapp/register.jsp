<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 06/09/2025
  Time: 4:44 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng ký tài khoản</title>
</head>
<body>
<h1>Đăng ký tài khoản</h1>
<form action="register" method="post">
    First Name: <input type="text" name="firstName" required>
    Last Name: <input type="text" name="lastName" required><br><br>

    Your Email: <input type="email" name="yourEmail" required><br><br>
    Re-enter Email: <input type="email" name="re_email" required><br><br>

    New Password: <input type="password" name="newPassword" required><br><br>

    Birthday:
    <select name="month">
        <option value="">Month</option>
    </select>
    <select name="day">
        <option value="">Day</option>
    </select>
    <select name="year">
        <option value="">Year</option>
    </select><br><br>

    <input type="radio" name="gender" value="male"> Male
    <input type="radio" name="gender" value="female"> Female<br><br>

    <input type="submit" value="Sign Up">
</form>
</body>
</html>
