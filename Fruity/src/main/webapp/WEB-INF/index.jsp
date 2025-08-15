<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fruit Store</title>
<link rel="stylesheet" href="/css/style.css">
<script src="/js/app.js"></script>
</head>
<body>
<h1>Fruit Store</h1>

<table>
    <thead>
        <tr>
            <th>Fruit</th>
            <th>Price ($)</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="fruit" items="${fruits}">
            <tr>
                <td><c:out value="${fruit.name}" /></td>
                <td><c:out value="${fruit.price}" /></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
