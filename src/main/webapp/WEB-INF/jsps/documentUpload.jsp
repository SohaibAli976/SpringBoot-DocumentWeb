<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>
        Document Upload
    </title>
</head>
<body>
<form action="upload" method="post" enctype="multipart/form-data">
    <pre>Id: <input type="text" name="id"/>
    Document: <input type="file" name="document"/>
<input type="submit" name="submit" value="Upload">
        </pre>
</form>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>link</th>
    </tr>

        <c:forEach items="${documents}" var="document">
            <tr>
                <td>${document.id}</td>
                <td>${document.name}</td>
                <td><a href="download?id=${document.id}">download</a> </td>
            </tr>
        </c:forEach>


</table>
</body>