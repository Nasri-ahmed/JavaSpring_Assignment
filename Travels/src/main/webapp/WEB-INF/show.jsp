<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Expense Details</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="d-flex justify-content-between align-items-center mb-2">
        <h2 class="text-primary">Expense Details</h2>
        <a href="/" class="btn btn-primary">Go Back</a>
    </div>
    <hr> 
    
    <div class="card shadow mx-auto" style="max-width: 700px;">
        <div class="card-body">
            <p><strong>Expense Name:</strong> ${expense.name}</p>
            <p><strong>Description:</strong> ${expense.description}</p>
            <p><strong>Vendor:</strong> ${expense.vendor}</p>
            <p><strong>Amount:</strong> $${expense.amount}</p>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
