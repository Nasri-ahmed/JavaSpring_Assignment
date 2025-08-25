<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Add Book</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container py-4">
  <div class="d-flex justify-content-between mb-3">
    <h3>Add a Book to Your Shelf!</h3>
    <a href="/books">back to the shelves</a>
  </div>

  <div class="card shadow-sm">
    <div class="card-body">
      <form:form method="post" action="/books/create" modelAttribute="book" class="row g-3">
        <div class="col-12">
          <label class="form-label">Title</label>
          <form:input path="title" cssClass="form-control"/>
          <form:errors path="title" cssClass="text-danger small"/>
        </div>
        <div class="col-12">
          <label class="form-label">Author</label>
          <form:input path="author" cssClass="form-control"/>
          <form:errors path="author" cssClass="text-danger small"/>
        </div>
        <div class="col-12">
          <label class="form-label">My thoughts</label>
          <form:textarea path="thoughts" rows="5" cssClass="form-control"/>
          <form:errors path="thoughts" cssClass="text-danger small"/>
        </div>
        <div class="col-12">
          <button class="btn btn-primary">Submit</button>
        </div>
      </form:form>
    </div>
  </div>
</div>
</body>
</html>
