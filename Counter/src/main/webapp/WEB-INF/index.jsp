<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   
   <h1>Welcome!</h1>
<p>You have visited this page <c:out value="${count}"/> times.</p>

<a href="/counter">Go to Counter Page</a>
<br>
<a href="/double">Visit & Add 2 (Ninja Bonus)</a>
<br>
<a href="/reset">Reset Counter</a>

</body>
</html>