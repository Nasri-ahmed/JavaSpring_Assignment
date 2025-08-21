<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Edit Expense</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow mx-auto" style="max-width: 700px;">
        <div class="card-header bg-warning text-white">
            Edit Expense
        </div>
        <div class="card-body">
            <form:form action="/expenses/${expense.id}" method="post" modelAttribute="expense">
                <div class="mb-3">
                    <label class="form-label">Expense Name</label>
                    <form:input path="name" class="form-control"/>
                    <form:errors path="name" cssClass="text-danger"/>
                </div>
                <div class="mb-3">
                    <label class="form-label">Vendor</label>
                    <form:input path="vendor" class="form-control"/>
                    <form:errors path="vendor" cssClass="text-danger"/>
                </div>
                <div class="mb-3">
                    <label class="form-label">Amount</label>
                    <form:input path="amount" type="number" class="form-control"/>
                    <form:errors path="amount" cssClass="text-danger"/>
                </div>
                <div class="mb-3">
                    <label class="form-label">Description</label>
                    <form:textarea path="description" class="form-control"/>
                </div>
                <button type="submit" class="btn btn-warning">Update Expense</button>
                <a href="/" class="btn btn-secondary">Cancel</a>
            </form:form>
        </div>
    </div>
</div>

</body>
</html>
