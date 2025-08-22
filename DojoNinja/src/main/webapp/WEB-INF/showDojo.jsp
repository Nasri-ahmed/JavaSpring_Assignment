<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dojo Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2><c:out value="${dojo.name}"/> Ninjas</h2>
    <table class="table table-striped">
        <thead class="table-dark">
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Age</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="n" items="${dojo.ninjas}">
                <tr>
                    <td><c:out value="${n.firstName}"/></td>
                    <td><c:out value="${n.lastName}"/></td>
                    <td><c:out value="${n.age}"/></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="/ninjas/new" class="btn btn-success">Add New Ninja</a>
    <a href="/dojos/new" class="btn btn-primary">Add New Dojo</a>
</div>
</body>
</html>
