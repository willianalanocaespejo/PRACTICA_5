<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body>
        <h1>

            <c:if test="${blg.id == 0}" >Nuevo</c:if>
            <c:if test="${blg.id != 0}" >Editar</c:if>

                Registro
            </h1>

            <form action="Inicio" method="post">
                
                
            
            <input type="hidden" name="id" value="${blg.id}"/>
            <br>
            
            <label>Fecha:</label>
            <input type="date" name="fecha" value="${blg.fecha}" required/>
            <br>
            
            <label>Titulo:</label>
            <input type="text" name="titulo" value="${blg.titulo}"required/>
            <br>
            
            <label>Contenido:</label>
            <textarea name="contenido" rows="4" cols="50">${blg.contenido}</textarea>
            <br>
            <input type="submit" value="Enviar"/>

        </form>


    </body>


</html>
