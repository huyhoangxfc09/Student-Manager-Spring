<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Student</title>
</head>
<style>
    .message{
        color:green;
    }
</style>
<body>
<h1>DELETE STUDENT</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<form method="post">
    <fieldset style="width: 20%">
        <legend>Are you sure?</legend>
        <table>
            <tr>
                <th>Id</th>
                <td>${student.id}</td>
            </tr>
            <tr>
                <th>Name</th>
                <td>${student.name}</td>
            </tr>
            <tr>
                <th>Age</th>
                <td>${student.age}</td>
            </tr>
            <tr>
                <th>Address</th>
                <td>${student.address}</td>
            </tr>
            <tr>
                <th>Classroom</th>
                <td>${student.classroom.name}</td>
            </tr>
            <tr>
                <td colspan="2"><button type="submit">Delete</button> </td>
            </tr>
        </table>
        <a href="/student"><button type="button">Back to list student</button></a>
    </fieldset>
</form>
</body>
</html>
