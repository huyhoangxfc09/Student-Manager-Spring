<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Classroom</title>
</head>
<style>
    .message{
        color:green;
    }
</style>
<body>
<h3>Update Classroom</h3>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<form method="post">
    <fieldset>
        <legend style="width: 20%">Classroom Information</legend>
        <table>
            <tr>
                <th>NAME</th>
                <td><input type="text" name="name" value="${classroom.name}"></td>
            </tr>
            <tr>
                <td colspan="2"><button type="submit">Update</button></td>
            </tr>
        </table>
        <a href="/classroom"><button type="button">Back to list classroom</button></a>
    </fieldset>
</form>
</body>
</html>
