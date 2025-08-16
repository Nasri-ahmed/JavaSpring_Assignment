<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Gold Game</title>
</head>
<body>
<h1>Ninja Gold: ${gold}</h1>

<form action="/process" method="post">
    <input type="hidden" name="place" value="farm"/>
    <button type="submit">Farm</button>
</form>

<form action="/process" method="post">
    <input type="hidden" name="place" value="cave"/>
    <button type="submit">Cave</button>
</form>

<form action="/process" method="post">
    <input type="hidden" name="place" value="house"/>
    <button type="submit">House</button>
</form>

<form action="/process" method="post">
    <input type="hidden" name="place" value="quest"/>
    <button type="submit">Quest</button>
</form>

<form action="/process" method="post">
    <input type="hidden" name="place" value="spa"/>
    <button type="submit">Spa</button>
</form>

<form action="/process" method="post">
    <input type="hidden" name="place" value="reset"/>
    <button type="submit">Reset</button>
</form>

<h2>Activities:</h2>
<ul>
    <c:forEach items="${activities}" var="act">
        <li>${act}</li>
    </c:forEach>
</ul>
</body>
</html>