<%-- 
    Document   : editar
    Created on : 4 jun. de 2024, 16:36:04
    Author     : NASH
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" rel="stylesheet">

    </head>
    <body>
        <div class="container">
        <h1>FORMULARIO ESTUDIANTES</h1>
        <form action="MainController" method="post"> 

                <input type="hidden" name="id" value="${estudiante.id}">
                <div class="mb-3">
                    <label for="disabledTextInput" class="form-label">NOMBRE</label>
                    <input type="text" name="nombre" id="disabledTextInput" class="form-control" value="${estudiante.nombre}" placeholder="Ingrese nombre">
                </div>
                <div class="mb-3">
                    <label for="disabledSelect" class="form-label">APELLIDOS</label>
                    <input type="text" name="apellidos" id="disabledTextInput" class="form-control" value="${estudiante.apellidos}" placeholder="Ingrese apellidos">
               
                </div>
                <div class="mb-3">
                    <label for="disabledSelect" class="form-label">EMAIL</label>
                    <input type="text" name="email" id="disabledTextInput" class="form-control" value="${estudiante.email}" placeholder="Ingrese email">
               
                </div>
                <div class="mb-3">
    <label for="disabledSelect" class="form-label">FECHA DE NACIMIENTO</label>
    <input type="text" name="fechaNacimiento" id="disabledTextInput" class="form-control" value="<fmt:formatDate value="${estudiante.fechaNacimiento}" pattern="yyyy-MM-dd" />" placeholder="Ingrese fecha de nacimiento YYYY-MM-DD">
</div>

                
                <button type="submit" class="btn btn-primary">Enviar</button>
            </fieldset>
        </form>
        </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

    </body>
</html>
