<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach var="item" items="${list}">
    <tr>
        <td>${item.userNo}</td>
        <td>${item.userId}</td>
        <td>${item.userName}</td>
        <td>${item.userPassword}</td>
    </tr>
</c:forEach>
</body>
</html>