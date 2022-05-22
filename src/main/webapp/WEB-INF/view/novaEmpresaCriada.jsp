<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Nova Empresa Criada</title>
</head>
    <c:import url="logout-parcial.jsp"/>
    <body>
        <c:if test="${not empty empresa}">
              Empresa ${empresa} cadastrada com sucesso!
        </c:if>

        <c:if test="${empty empresa}">
            Nenhuma empresa cadastrada!
        </c:if>
    </body>
</html>