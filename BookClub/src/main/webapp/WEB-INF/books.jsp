<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Books</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container py-4">
  <div class="d-flex justify-content-between align-items-center mb-3">
    <h3 class="m-0">Welcome, <span class="text-primary"><c:out value="${me.name}"/></span></h3>
    <div class="d-flex gap-3">
      <a href="/books/new" class="text-decoration-none">+ Add a book to my shelf!</a>
      <a href="/logout">logout</a>
    </div>
  </div>

  <div class="card shadow-sm">
    <div class="card-body">
      <h5 class="mb-3">Books from everyone's shelves:</h5>
      <div class="table-responsive">
        <table class="table table-striped align-middle">
          <thead>
            <tr>
              <th>#</th>
              <th>Title</th>
              <th>Author Name</th>
              <th>Posted By</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="b" items="${books}" varStatus="s">
              <tr>
                <td>${s.index + 1}</td>
                <td><a href="/books/${b.id}"><c:out value="${b.title}"/></a></td>
                <td><c:out value="${b.author}"/></td>
                <td><c:out value="${b.poster.name}"/></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>
</body>
</html>
