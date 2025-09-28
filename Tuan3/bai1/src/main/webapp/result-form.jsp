<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/4/2025
  Time: 7:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h2>Student Registration Result</h2>

<jsp:useBean id="student" type="fit.se.bai1.model.Student" scope="request"/>
<p>First Name: <jsp:getProperty name="student" property="firstName"/></p>
<p>Last Name: <jsp:getProperty name="student" property="lastName"/></p>
<p>Date of Birth: <jsp:getProperty name="student" property="dob"/></p>
<p>Email: <jsp:getProperty name="student" property="email"/></p>
<p>Mobile Number: <jsp:getProperty name="student" property="mobileNumber"/></p>
<p>Gender: <jsp:getProperty name="student" property="gender"/></p>
<p>Address: <jsp:getProperty name="student" property="address"/></p>
<p>City: <jsp:getProperty name="student" property="city"/></p>
<p>State: <jsp:getProperty name="student" property="state"/></p>
<p>Country: <jsp:getProperty name="student" property="country"/></p>
<p>Qualification: <jsp:getProperty name="student" property="qualification"/></p>
<p>Course: <jsp:getProperty name="student" property="course"/></p>
</body>
</html>
