<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkControllerServlet"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form action="${linkControllerServlet}" method="post">
        Nome: <input type="text" name="nome"/>
        Data Abertura: <input type="text" name="data"/>
        <input type="hidden" name="acao" value="NovaEmpresa">
        <input type="submit"/>
    </form>
</body>
</html>