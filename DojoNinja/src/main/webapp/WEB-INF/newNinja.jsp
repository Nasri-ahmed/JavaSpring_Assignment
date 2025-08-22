<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>New Ninja</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5" style="max-width: 500px;">
    <h2>New Ninja</h2>
    <form:form method="POST" modelAttribute="ninja" action="/ninjas">
        <div class="mb-3">
            <label>Dojo:</label>
            <form:select path="dojo" cssClass="form-control">
                <c:forEach var="d" items="${dojos}">
                    <form:option value="${d.id}">${d.name}</form:option>
                </c:forEach>
            </form:select>
        </div>
        <div class="mb-3">
            <label>First Name:</label>
            <form:input path="firstName" cssClass="form-control"/>
            <form:errors path="firstName" cssClass="text-danger"/>
        </div>
        <div class="mb-3">
            <label>Last Name:</label>
            <form:input path="lastName" cssClass="form-control"/>
            <form:errors path="lastName" cssClass="text-danger"/>
        </div>
        <div class="mb-3">
            <label>Age:</label>
            <form:input path="age" cssClass="form-control"/>
            <form:errors path="age" cssClass="text-danger"/>
        </div>
        <input type="submit" value="Create" class="btn btn-primary"/>
    </form:form>
</div>
</body>
</html>
