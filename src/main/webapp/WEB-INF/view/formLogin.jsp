<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/entrada" var="linkControllerServlet"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Login</title>
</head>
<body>
    <form action="${linkControllerServlet}" method="post">
        Login: <input type="text" name="login"/>
        Senha: <input type="password" name="senha"/>
        <input type="hidden" name="acao" value="Login">
        <input type="submit"/>
    </form>
</body>
</html>
