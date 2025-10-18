<%@ page language="java" contentType="text/html; UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>
    <style>
        body { font-family: sans-serif; }
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        .action-links a { margin-right: 5px; }
        .header { display: flex; justify-content: space-between; align-items: center; margin-bottom: 20px; }
        .btn { padding: 8px 12px; background-color: #007bff; color: white; text-decoration: none; border-radius: 4px; border: none; cursor: pointer; }
        .search-form { display: flex; }
        .search-form input[type="text"] { padding: 8px; }
        .search-form input[type="submit"] { padding: 8px 12px; background-color: #f0f0f0; border: 1px solid #ccc; cursor: pointer; }
    </style>
</head>
<body>
<%--<a href="${pageContext.request.contextPath}/show-form">Add</a>--%>
<%--<table>--%>
<%--    <tr>--%>
<%--        <td>Id</td>--%>
<%--        <td>First Name</td>--%>
<%--        <td>Last Name</td>--%>
<%--        <td>Action</td>--%>
<%--    </tr>--%>
<%--    <c:forEach var="employee" items="${employees}">--%>
<%--        <tr>--%>
<%--            <td>${employee.id}</td>--%>
<%--            <td>${employee.firstName}</td>--%>
<%--            <td>${employee.lastName}</td>--%>
<%--            <td><a href="${pageContext.request.contextPath}/update?employeeId=${employee.id}">Edit</a></td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--</table>--%>
<h1>EMPLOYEE LIST</h1>

<div class="header">
    <form action="${pageContext.request.contextPath}/" method="get" class="search-form">
        <input type="text" name="keyword" value="${keyword}" placeholder="Search..."/>
        <input type="submit" value="Search"/>
    </form>
    <a href="${pageContext.request.contextPath}/show-form" class="btn">Add Employee</a>
</div>

<table>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Gender</th>
        <th>Date of birth</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Action</th>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.firstName}</td>
            <td>${employee.lastName}</td>
            <td>${employee.gender}</td>
            <td>${employee.dateOfBirth}</td>
            <td>${employee.email}</td>
            <td>${employee.phone}</td>
            <td class="action-links">
                <a href="${pageContext.request.contextPath}/update?employeeId=${employee.id}">Update</a> |
                <a href="${pageContext.request.contextPath}/delete?employeeId=${employee.id}"
                   onclick="return confirm('Are you sure you want to delete this employee?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>