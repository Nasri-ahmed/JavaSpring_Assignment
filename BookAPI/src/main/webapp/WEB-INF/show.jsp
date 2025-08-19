<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Show Book</title>
</head>
<body>
    <h1>Book Information</h1>
    <p>Title: ${book.title}</p>
    <p>Description: ${book.description}</p>
    <p>Language: ${book.language}</p>
    <p>Number of Pages: ${book.numberOfPages}</p>
</body>
</html>
