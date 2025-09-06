<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/4/2025
  Time: 7:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Form</title>
</head>
<body>
<h2>Student Course Registration Form</h2>
<form action="registration-form" name="formDangKy" method="GET">

    First Name: <input type="text" name="firstName"/><br/><br/>
    Last Name: <input type="text" name="lastName"/><br/><br/>
    Date of Birth: <input type="date" name="birthDate"/><br/><br/>
    Email: <input type="email" name="email"/><br/><br/>
    Mobile Number: <input type="text" name="mobileNumber"/><br/><br/>

    Gender:
    <input type="radio" name="gender" value="Male"/> Male
    <input type="radio" name="gender" value="Female"/> Female
    <br/><br/>

    Address: <textarea name="address"></textarea><br/><br/>
    City: <input type="text" name="city"/><br/><br/>
    State: <input type="text" name="state"/><br/><br/>
    Country: <input type="text" name="country" value="Vietnam"/><br/><br/>

    Qualification:
    <select name="qualification">
        <option value="Class X">Class X</option>
        <option value="Class XII">Class XII</option>
        <option value="Graduation">Graduation</option>
        <option value="Masters">Masters</option>
    </select><br/><br/>

    Course:
    <input type="radio" name="course" value="BCA"/> BCA
    <input type="radio" name="course" value="B.Com"/> B.Com
    <input type="radio" name="course" value="B.Sc"/> B.Sc
    <br/><br/>

    <input type="submit" value="Submit"/>
    <input type="reset" value="Reset"/>
</form>
</body>
</html>
