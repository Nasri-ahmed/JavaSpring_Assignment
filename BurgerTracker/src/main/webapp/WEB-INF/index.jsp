<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Burger Tracker</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
    <h1 class="text-center text-primary mb-4">🍔 Burger Tracker</h1>

    <!-- Add Burger Form -->
    <div class="card shadow p-4 mb-4">
        <h4 class="mb-3">Add a New Burger</h4>
        <form:form method="POST" action="/burgers" modelAttribute="burger">
            <div class="mb-3">
                <form:label path="name">Burger Name</form:label>
                <form:input path="name" class="form-control"/>
                <form:errors path="name" class="text-danger"/>
            </div>
            <div class="mb-3">
                <form:label path="restaurant">Restaurant</form:label>
                <form:input path="restaurant" class="form-control"/>
                <form:errors path="restaurant" class="text-danger"/>
            </div>
            <div class="mb-3">
                <form:label path="rating">Rating (1-5)</form:label>
                <form:input path="rating" type="number" min="1" max="5" class="form-control"/>
                <form:errors path="rating" class="text-danger"/>
            </div>
            <div class="mb-3">
                <form:label path="notes">Notes</form:label>
                <form:textarea path="notes" class="form-control"/>
            </div>
            <button class="btn btn-success">Add Burger</button>
        </form:form>
    </div>

    <!-- Burger List -->
    <div class="card shadow p-4">
        <h4 class="mb-3">All Burgers</h4>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Burger</th>
                    <th>Restaurant</th>
                    <th>Rating</th>
                    <th>Notes</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="burger" items="${burgers}">
                    <tr>
                        <td>${burger.name}</td>
                        <td>${burger.restaurant}</td>
                        <td>${burger.rating}</td>
                        <td>${burger.notes}</td>
                        <td>
                            <a href="/burgers/edit/${burger.id}" class="btn btn-primary btn-sm">Edit</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
