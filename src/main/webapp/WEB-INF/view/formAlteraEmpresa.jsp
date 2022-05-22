<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url value="/entrada" var="linkControllerServlet"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <c:import url="logout-parcial.jsp"/>
    <form action="${linkControllerServlet}" method="post">
        Nome: <input type="text" name="nome" value="${empresa.nome}"/>
        Data Abertura: <input type="text" name="data" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>"/>
        <input type="hidden" name="id" value="${empresa.id}">
        <input type="hidden" name="acao" value="AlteraEmpresa">
        <input type="submit"/>
    </form>
</body>
</html>