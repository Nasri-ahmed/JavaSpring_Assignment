<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title><c:out value="${book.title}"/></title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container py-4">
  <div class="d-flex justify-content-between mb-3">
    <h2 class="m-0"><c:out value="${book.title}"/></h2>
    <a href="/books">back to the shelves</a>
  </div>

  <p class="mb-1">
    <strong><c:out value="${book.poster.name}"/></strong> read 
    <span class="text-primary"><c:out value="${book.title}"/></span> by 
    <span class="text-success"><c:out value="${book.author}"/></span>.
  </p>

  <div class="card shadow-sm my-3">
    <div class="card-body">
      <h6 class="text-muted mb-2">Here are <c:out value="${book.poster.id == uid ? 'your' : book.poster.name + \"'s\"}"/> thoughts:</h6>
      <p style="white-space:pre-wrap"><c:out value="${book.thoughts}"/></p>
    </div>
  </div>

  <c:if test="${book.poster.id == uid}">
    <div class="d-flex gap-2">
      <a class="btn btn-outline-secondary" href="/books/${book.id}/edit">edit</a>
      <a class="btn btn-outline-danger" href="/books/${book.id}/delete"
         onclick="return confirm('Delete this book?');">delete</a>
    </div>
  </c:if>
</div>
</body>
</html>
