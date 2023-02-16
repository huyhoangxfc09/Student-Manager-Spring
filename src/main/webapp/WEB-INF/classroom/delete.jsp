<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Delete Classroom</title>
</head>
<style>
  .message{
    color:green;
  }
</style>
<body>
<h1>DELETE CLASSROOM</h1>
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
        <td>${classroom.id}</td>
      </tr>
      <tr>
        <th>Name</th>
        <td>${classroom.name}</td>
      </tr>
      <tr>
        <td colspan="2"><button type="submit">Delete</button> </td>
      </tr>
    </table>
    <a href="/classroom"><button type="button">Back to list classroom</button></a>
  </fieldset>
</form>
</body>
</html>
