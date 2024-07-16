<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home::</title>
</head>
<body>
    <h1>Bienvenido al sistema</h1>

    <form id="logoutForm" method="POST" th:action="@{/logout}">
        <input type="submit" value="Logout!" />
    </form>
</body>
</html>