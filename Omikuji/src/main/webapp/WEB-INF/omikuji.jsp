<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji Form</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
  <link rel="stylesheet" href="<c:url value='/css/style.css'/>">

</head>
<body>
<h1>Omikuji Fortune Teller</h1>
    <form action="<c:url value='/omikuji/process'/>" method="post">
    <div class="mb-3">
        <label>Pick any number from 5 to 25:</label>
        <input type="number" name="number" min="5" max="25" class="form-control" required>
    </div>

    <div class="mb-3">
        <label>Enter the name of any city:</label>
        <input type="text" name="city" class="form-control" required>
    </div>

    <div class="mb-3">
        <label>Enter the name of any real person:</label>
        <input type="text" name="name" class="form-control" required>
    </div>

    <div class="mb-3">
        <label>Enter professional endeavor or hobby:</label>
        <input type="text" name="profession" class="form-control" required>
    </div>

    <div class="mb-3">
        <label>Enter any type of living thing:</label>
        <input type="text" name="thing" class="form-control" required>
    </div>

    <div class="mb-3">
        <label>Say something nice to someone:</label>
        <textarea name="niceMessage" class="form-control" required></textarea>
    </div>

    <button type="submit" class="btn btn-primary">Send and show a friend</button>
</form>

</body>
</html>