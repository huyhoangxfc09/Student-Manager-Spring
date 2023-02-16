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
<a href="/classroom/create"><button>Create Classroom</button></a>
<a href="/student"><button>List Student</button></a>
<table>
    <tr>
        <th>STT</th>
        <th>NAME</th>
        <th colspan="2">ACTION</th>
    </tr>
    <c:forEach items="${classroom}" var="element" varStatus="stt"  >
        <tr>
            <td>${stt.index+1}</td>
            <td>${element.name}</td>
            <td><a href="/classroom/update?id=${element.id}"><button type="button">Update</button></a></td>
            <td><a href="/classroom/delete?id=${element.id}"><button type="button">Delete</button></a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
