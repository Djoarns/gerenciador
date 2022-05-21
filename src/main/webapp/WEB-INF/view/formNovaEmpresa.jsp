<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form action="${linkEntradaServlet}" method="post">
        Nome: <input type="text" name="nome"/>
        Data Abertura: <input type="text" name="data"/>
        <input type="submit"/>
        <input type="hidden" name="acao" value="NovaEmpresa">
    </form>
</body>
</html>