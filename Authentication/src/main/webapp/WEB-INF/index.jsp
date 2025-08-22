<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login & Registration</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f0f2f5;
        }
        .card {
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.15);
            margin-bottom: 30px;
        }
        .form-title {
            font-weight: 600;
            font-size: 1.5rem;
            margin-bottom: 20px;
        }
        .btn-primary {
            width: 100%;
        }
        .form-container {
            margin-top: 50px;
            margin-bottom: 50px;
        }
    </style>
</head>
<body>

<div class="container form-container">
    <div class="row justify-content-center">
        <!-- Register Card -->
        <div class="col-md-5">
            <div class="card p-4">
                <div class="form-title text-center">Register</div>
                <form:form action="/register" method="post" modelAttribute="newUser">
                    <div class="mb-3">
                        <label class="form-label">Username</label>
                        <form:input class="form-control" path="username"/>
                        <form:errors path="username" class="text-danger"/>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Email</label>
                        <form:input class="form-control" path="email"/>
                        <form:errors path="email" class="text-danger"/>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Password</label>
                        <form:password class="form-control" path="password"/>
                        <form:errors path="password" class="text-danger"/>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Confirm Password</label>
                        <form:password class="form-control" path="confirm"/>
                        <form:errors path="confirm" class="text-danger"/>
                    </div>
                    <button type="submit" class="btn btn-primary">Register</button>
                </form:form>
            </div>
        </div>

        <!-- Login Card -->
        <div class="col-md-5">
            <div class="card p-4">
                <div class="form-title text-center">Login</div>
                <form:form action="/login" method="post" modelAttribute="newLogin">
                    <div class="mb-3">
                        <label class="form-label">Email</label>
                        <form:input class="form-control" path="email"/>
                        <form:errors path="email" class="text-danger"/>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Password</label>
                        <form:password class="form-control" path="password"/>
                        <form:errors path="password" class="text-danger"/>
                    </div>
                    <button type="submit" class="btn btn-primary">Login</button>
                </form:form>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
