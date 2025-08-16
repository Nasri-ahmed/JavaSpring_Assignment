<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Omikuji Fortune</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
  <link rel="stylesheet" href="<c:url value='/css/style.css'/>">

</head>
<body>
  <h1>Here's Your Omikuji!</h1>
<div class="p-4" style="background-color: #add8e6;">
    In <span>${number}</span> years, you will live in <span>${city}</span> with <span>${name}</span> as your roommate, <span>${profession}</span> for a living. 
    The next time you see a <span>${thing}</span>, you will have good luck. 
    Also, <span>${niceMessage}</span>
</div>
<a href="<c:url value='/omikuji'/>">Go Back</a>

</body>
</html>