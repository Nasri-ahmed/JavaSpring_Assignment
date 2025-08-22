<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>New Dojo</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5" style="max-width: 500px;">
    <h2>New Dojo</h2>
    <form:form method="POST" modelAttribute="dojo" action="/dojos">
        <div class="mb-3">
            <label>Name:</label>
            <form:input path="name" cssClass="form-control"/>
            <form:errors path="name" cssClass="text-danger"/>
        </div>
        <input type="submit" value="Create" class="btn btn-primary"/>
    </form:form>
</div>
</body>
</html>
