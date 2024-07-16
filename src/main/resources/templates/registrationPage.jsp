<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Registro</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Registro</h1>
    <form action="/usuarios/registration" method="POST">
        <div class="mb-3">
            <label for="username" class="form-label">Nombre de usuario:</label>
            <input type="text" id="username" name="username" class="form-control" />
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Contraseña:</label>
            <input type="password" id="password" name="password" class="form-control" />
        </div>
        <div class="mb-3">
            <label for="passwordConfirmation" class="form-label">Confirmación de contraseña:</label>
            <input type="password" id="passwordConfirmation" name="passwordConfirmation" class="form-control" />
        </div>
        <input type="submit" value="Registrar" class="btn btn-primary" />
        <a class="btn btn-secondary" href="/usuarios/login" role="button">Login</a>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>