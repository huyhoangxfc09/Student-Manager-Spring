<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Classroom</title>
</head>
<style>
    table {
        border-collapse: collapse;
    }
    table, th, td {
        border: 1px solid black;
    }
</style>
<body>
<h1>LIST CLASSROOM</h1>
<a href="/student/create"><button>Create Student</button></a>
<a href="/classroom"><button type="button">List Classroom</button></a>
<table>
    <tr>
        <th>STT</th>
        <th>NAME</th>
        <th>AGE</th>
        <th>ADDRESS</th>
        <th>CLASSROOM</th>
        <th colspan="2">ACTION</th>
    </tr>
    <c:forEach items="${student}" var="element" varStatus="stt"  >
        <tr>
            <td>${stt.index+1}</td>
            <td>${element.name}</td>
            <td>${element.age}</td>
            <td>${element.address}</td>
            <td>${element.classroom.name}</td>
            <td><a href="/student/update?id=${element.id}"><button type="button">Update</button></a></td>
            <td><a href="/student/delete?id=${element.id}"><button type="button">Delete</button></a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
