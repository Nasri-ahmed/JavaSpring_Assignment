<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Dojos</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1>All Dojos</h1>
    <a href="/dojos/new" class="btn btn-primary mb-3">Create New Dojo</a>

    <table class="table table-striped">
        <thead class="table-dark">
            <tr>
                <th>Dojo Name</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="dojo" items="${dojos}">
                <tr>
                    <td><c:out value="${dojo.name}"/></td>
                    <td>
                        <a href="/dojos/${dojo.id}" class="btn btn-success">View</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
