<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 15/09/2025
  Time: 2:01 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Registration</title>
    <style>
        body { font-family: Arial, sans-serif; display: flex; justify-content: center; align-items: center; min-height: 100vh; background-color: #f0f2f5; margin: 0; }
        .container { width: 400px; background-color: #fff; padding: 30px; border-radius: 8px; box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); }
        h2 { text-align: center; color: #444; margin-bottom: 25px; }
        .input-group { margin-bottom: 15px; display: flex; flex-wrap: wrap; gap: 10px; }
        .input-group.full-width { flex-direction: column; }
        .input-group input, .input-group select { flex: 1; padding: 10px; border: 1px solid #ccc; border-radius: 4px; font-size: 14px; }
        .input-group input::placeholder { color: #aaa; }
        .input-group input:focus, .input-group select:focus { outline: none; border-color: #007bff; }
        .birthday-label { display: block; color: #666; font-size: 14px; margin-bottom: 5px; }
        .radio-group { display: flex; align-items: center; gap: 20px; margin-top: 5px; }
        .radio-group label { display: flex; align-items: center; font-size: 14px; color: #666; }
        .radio-group input { margin-right: 5px; }
        .btn-submit { width: 100%; padding: 12px; border: none; background-color: #007bff; color: white; border-radius: 4px; font-size: 16px; cursor: pointer; margin-top: 20px; }
        .btn-submit:hover { background-color: #0056b3; }
        .error-message { color: red; font-size: 14px; margin-bottom: 15px; text-align: center;}
    </style>
</head>
<body>
<div class="container">
    <h2>User Registration Form</h2>

    <c:if test="${not empty errors}">
        <div class="error-message">
            <c:forEach var="error" items="${errors}">
                <p>${error}</p>
            </c:forEach>
        </div>
    </c:if>

    <form action="register" method="post">
        <div class="input-group">
            <input type="text" name="firstName" placeholder="First Name" value="${user.firstName}">
            <input type="text" name="lastName" placeholder="Last Name" value="${user.lastName}">
        </div>
        <div class="input-group full-width">
            <input type="email" name="email" placeholder="Your Email" value="${user.email}">
        </div>
        <div class="input-group full-width">
            <input type="email" name="reEmail" placeholder="Re-enter Email">
        </div>
        <div class="input-group full-width">
            <input type="password" name="password" placeholder="New Password">
        </div>
        <label class="birthday-label">Birthday</label>
        <div class="input-group">
            <select name="month">
                <option value="">Month</option>
                <c:forEach begin="1" end="12" var="i">
                    <option value="${i}" ${user.birthday.monthValue == i ? 'selected' : ''}>${i}</option>
                </c:forEach>
            </select>
            <select name="day">
                <option value="">Day</option>
                <c:forEach begin="1" end="31" var="i">
                    <option value="${i}" ${user.birthday.dayOfMonth == i ? 'selected' : ''}>${i}</option>
                </c:forEach>
            </select>
            <select name="year">
                <option value="">Year</option>
                <c:forEach begin="1900" end="2024" var="i">
                    <option value="${i}" ${user.birthday.year == i ? 'selected' : ''}>${i}</option>
                </c:forEach>
            </select>
        </div>
        <div class="radio-group">
            <label>
                <input type="radio" name="gender" value="Female" ${user.gender == 'Female' ? 'checked' : ''}> Female
            </label>
            <label>
                <input type="radio" name="gender" value="Male" ${user.gender == 'Male' ? 'checked' : ''}> Male
            </label>
        </div>
        <button type="submit" class="btn-submit">Sign Up</button>
    </form>
</div>
</body>
</html>
