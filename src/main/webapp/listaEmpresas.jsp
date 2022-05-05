<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Java Standard Taglib</title>
</head>
<body>
    Lista de Empresas: <br />
    <ul>
        <c:forEach items="${empresas}" var="empresa">
            <li>
                ${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
                <a href="/gerenciador/mostraEmpresa?id=${empresa.id}">editar</a>
                <a href="/gerenciador/removeEmpresa?id=${empresa.id}">remover</a>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
