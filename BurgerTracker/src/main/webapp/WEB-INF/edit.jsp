<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Edit Burger</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow mx-auto" style="max-width: 700px;">
        <div class="card-header bg-warning text-white">Edit Burger</div>
        <div class="card-body">
            <form:form action="/burgers/update/${burger.id}" method="post" modelAttribute="burger" class="row g-3">
                <div class="col-md-12">
                    <label class="form-label">Burger Name</label>
                    <form:input path="name" class="form-control"/>
                    <form:errors path="name" cssClass="text-danger"/>
                </div>
                <div class="col-md-12">
                    <label class="form-label">Restaurant</label>
                    <form:input path="restaurant" class="form-control"/>
                    <form:errors path="restaurant" cssClass="text-danger"/>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Rating (1-5)</label>
                    <form:input path="rating" type="number" min="1" max="5" class="form-control"/>
                    <form:errors path="rating" cssClass="text-danger"/>
                </div>
                <div class="col-md-12">
                    <label class="form-label">Notes</label>
                    <form:textarea path="notes" class="form-control" rows="3"/>
                    <form:errors path="notes" cssClass="text-danger"/>
                </div>
                <div class="col-12 d-flex justify-content-between mt-3">
                    <button type="submit" class="btn btn-warning">Update Burger</button>
                    <a href="/" class="btn btn-secondary">Cancel</a>
                </div>
            </form:form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
