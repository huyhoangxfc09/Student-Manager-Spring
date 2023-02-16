<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Student</title>
</head>
<style>
    .message{
        color:green;
    }
</style>
<body>
<h3>Update Student</h3>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<form method="post">
    <fieldset>
        <legend style="width: 20%">Student Information</legend>
        <table>
            <tr>
                <th>NAME</th>
                <td><input type="text" name="name" value="${student.name}"></td>
            </tr>
            <tr>
                <th>AGE</th>
                <td><input type="number" name="age" value="${student.age}"></td>
            </tr>
            <tr>
                <th>ADDRESS</th>
                <td><input type="text" name="address" value="${student.address}"></td>
            </tr>
            <tr>
                <th>CLASSROOM</th>
                <td>
                    <select name="classroom" id ="classroom">
                        <c:forEach items="${classroom}" var="element">
                            <option value="${element.id}">${element.name}</option>
                        </c:forEach>
                    </select>
                </td>
            <tr>
                <td colspan="2"><button type="submit">Update</button></td>
            </tr>
        </table>
        <a href="/student"><button type="button">Back to list classroom</button></a>
    </fieldset>
</form>
</body>
</html>
