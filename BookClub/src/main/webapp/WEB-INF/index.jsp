<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
  <title>Book Club | Login & Register</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container py-5">
  <h1 class="mb-1 text-primary fw-bold">Book Club</h1>
  <p class="text-muted mb-4">A place for friends to share thoughts on books.</p>

  <div class="row g-4">
    <!-- Register -->
    <div class="col-md-6">
      <div class="card shadow-sm">
        <div class="card-body">
          <h4 class="mb-3">Register</h4>
          <form:form method="post" action="/register" modelAttribute="newUser" class="row g-3">
            <div class="col-12">
              <label class="form-label">Name</label>
              <form:input path="name" cssClass="form-control"/>
              <form:errors path="name" cssClass="text-danger small"/>
            </div>
            <div class="col-12">
              <label class="form-label">Email</label>
              <form:input path="email" cssClass="form-control"/>
              <form:errors path="email" cssClass="text-danger small"/>
            </div>
            <div class="col-12">
              <label class="form-label">Password</label>
              <form:password path="password" cssClass="form-control"/>
              <form:errors path="password" cssClass="text-danger small"/>
            </div>
            <div class="col-12">
              <label class="form-label">Confirm PW</label>
              <form:password path="confirmPassword" cssClass="form-control"/>
              <form:errors path="confirmPassword" cssClass="text-danger small"/>
            </div>
            <div class="col-12">
              <button class="btn btn-primary">Submit</button>
            </div>
          </form:form>
        </div>
      </div>
    </div>

    <!-- Login -->
    <div class="col-md-6">
      <div class="card shadow-sm">
        <div class="card-body">
          <h4 class="mb-3">Log in</h4>
          <form:form method="post" action="/login" modelAttribute="newLogin" class="row g-3">
            <div class="col-12">
              <label class="form-label">Email</label>
              <form:input path="email" cssClass="form-control"/>
              <form:errors path="email" cssClass="text-danger small"/>
            </div>
            <div class="col-12">
              <label class="form-label">Password</label>
              <form:password path="password" cssClass="form-control"/>
              <form:errors path="password" cssClass="text-danger small"/>
            </div>
            <div class="col-12">
              <button class="btn btn-dark">Submit</button>
            </div>
          </form:form>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
