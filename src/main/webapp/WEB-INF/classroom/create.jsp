<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Form</title>
</head>
<style>
    .message{
        color:green;
    }
</style>
<body>
<h3>Create Classroom</h3>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<form action="/classroom/create" method="post">
    <table>
        <tr>
            <th>ID</th>
            <td><input type="number" name="id"></td>
        </tr>
        <tr>
            <th>NAME</th>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td colspan="2"><button type="submit">Create</button></td>
        </tr>
    </table>
    <a href="/classroom"><button type="button">Back to list classroom</button></a>
</form>
</body>
</html>
