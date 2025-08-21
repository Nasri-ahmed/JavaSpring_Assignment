<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Save Travels</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <h1 class="text-center text-primary mb-4"> Save Travels</h1>

    <!-- Expense List -->
    <div class="card shadow p-4">
       
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Expense</th>
                    <th>Vendor</th>
                    <th>Amount</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="expense" items="${expenses}">
                    <tr>
                        <td><a href="/expenses/${expense.id}">${expense.name}</a></td>
                        <td>${expense.vendor}</td>
                        <td>${expense.amount}</td>
                        <td>
                            <a href="/expenses/${expense.id}/edit" class="btn btn-primary btn-sm">Edit</a>
                            <form action="/expenses/${expense.id}/delete" method="post" style="display:inline;">
                                <button type="submit" class="btn btn-danger btn-sm">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
       <!-- Add Expense Form -->
    <div class="card shadow p-4 mb-4">
        <h4 class="mb-3">Add On Expense</h4>
        <form:form method="POST" action="/expenses" modelAttribute="expense">
            <div class="mb-3">
                <form:label path="name">Expense Name</form:label>
                <form:input path="name" class="form-control"/>
                <form:errors path="name" class="text-danger"/>
            </div>
            <div class="mb-3">
                <form:label path="vendor">Vendor</form:label>
                <form:input path="vendor" class="form-control"/>
                <form:errors path="vendor" class="text-danger"/>
            </div>
            <div class="mb-3">
                <form:label path="amount">Amount</form:label>
                <form:input path="amount" type="number" class="form-control"/>
                <form:errors path="amount" class="text-danger"/>
            </div>
            <div class="mb-3">
                <form:label path="description">Description</form:label>
                <form:textarea path="description" class="form-control"/>
            </div>
            <button class="btn btn-success">Add Expense</button>
        </form:form>
    </div>
</div>

</body>
</html>
