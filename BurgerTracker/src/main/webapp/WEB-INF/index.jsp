<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Burger</title>
</head>
<body>
<h1>Burger Tracker</h1>

<table border="1">
    <thead>
        <tr>
            <th>Burger Name</th>
            <th>Restaurant Name</th>
            <th>Rating</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="b" items="${burgers}">
            <tr>
                <td>${b.name}</td>
                <td>${b.restaurant}</td>
                <td>${b.rating}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<h2>Add a Burger:</h2>
<form:form action="/burgers" method="post" modelAttribute="burger">
    <p>
        <form:label path="name">Burger Name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="restaurant">Restaurant Name</form:label>
        <form:errors path="restaurant"/>
        <form:input path="restaurant"/>
    </p>
    <p>
        <form:label path="rating">Rating</form:label>
        <form:errors path="rating"/>
        <form:input type="number" path="rating"/>
    </p>
    <p>
        <form:label path="notes">Notes</form:label>
        <form:errors path="notes"/>
        <form:textarea path="notes"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>