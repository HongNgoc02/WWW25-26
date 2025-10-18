<%@ page language="java" contentType="text/html; UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Employee</title>
    <style>
        body { font-family: sans-serif; display: flex; justify-content: center; align-items: center; background-color: #f4f4f4; }
        .container { width: 400px; padding: 20px; background-color: white; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
        h1 { text-align: center; }
        .form-table { width: 100%; }
        .form-table td { padding: 8px 0; }
        .form-table input[type="text"], .form-table input[type="email"], .form-table input[type="date"] { width: 95%; padding: 8px; border: 1px solid #ccc; border-radius: 4px; }
        .error { color: red; font-size: 0.9em; }
        .btn-group { display: flex; justify-content: space-between; margin-top: 20px; }
        .btn { padding: 10px 20px; border: none; border-radius: 4px; cursor: pointer; text-decoration: none; }
        .btn-primary { background-color: #007bff; color: white; }
        .btn-secondary { background-color: #6c757d; color: white; }
    </style>
</head>
<body>
<%--@elvariable id="employee" type="java"--%>
<%--<form:form action="${pageContext.request.contextPath}/save" method="post" modelAttribute="employee">
    <table>
        <tr>
            <td>First Name:</td>
            <td>
                <form:hidden path="id"/>
                <form:input path="firstName"/>
                <form:errors path="firstName" cssStyle="color: red"/>
            </td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td>
                <form:input path="lastName"/>
                <form:errors path="lastName"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Save Changes"/>
            </td>
        </tr>
    </table>
</form:form>--%>
<div class="container">
    <h1>REGISTRATION EMPLOYEE</h1>

    <%--@elvariable id="employee" type="iuh.fit.se.entities.Employee"--%>
    <form:form action="${pageContext.request.contextPath}/save" method="post" modelAttribute="employee">
        <form:hidden path="id"/>
        <table class="form-table">
            <tr>
                <td>First Name</td>
                <td>
                    <form:input path="firstName" placeholder="First Name"/>
                    <form:errors path="firstName" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td>
                    <form:input path="lastName" placeholder="Last Name"/>
                    <form:errors path="lastName" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>Email</td>
                <td>
                    <form:input path="email" type="email" placeholder="Email"/>
                    <form:errors path="email" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>Date of Birth</td>
                <td>
                    <form:input path="dateOfBirth" type="date"/>
                    <form:errors path="dateOfBirth" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>Phone number</td>
                <td>
                    <form:input path="phone" placeholder="Phone number"/>
                    <form:errors path="phone" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>Gender</td>
                <td>
                    <form:radiobutton path="gender" value="Male"/> Male
                    <form:radiobutton path="gender" value="Female"/> Female
                    <form:errors path="gender" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>Address</td>
                <td>
                    <form:input path="address" placeholder="Address"/>
                    <form:errors path="address" cssClass="error"/>
                </td>
            </tr>
        </table>

        <div class="btn-group">
            <a href="${pageContext.request.contextPath}/" class="btn btn-secondary">Back</a>
            <input type="submit" value="Register" class="btn btn-primary"/>
        </div>
    </form:form>
</div>
</body>
</html>