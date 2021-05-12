<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    HttpSession se = request.getSession(false);
    String usuario = (String) se.getAttribute("usuario");
    if(usuario.equals("")){
        response.sendRedirect("index.jsp");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body>
        <div style="margin:30px;">
            
            <h2 align="right"><%= usuario %>&nbsp;&nbsp;&nbsp; | <a href="Log">Salir</a> </h2>
            
            <h1 align="center">Blog de Salud</h1>
            <p> <a href="Inicio?action=add">Nueva Entrada</a>


                <c:forEach var="item" items="${blog}">


                <h4>${item.fecha}</h4>

                <h2>${item.titulo}</h2>

                <h4>${item.contenido}</h4>
                <br>
                
                <h4 style="float: left">
                     Autor: <%= usuario%>
               </h4>
                   
                       
                 <h5 align="right">
                    <a href="Inicio?action=edit&id=${item.id}">Editar</a>
                    <a href="Inicio?action=delete&id=${item.id}">Eliminar</a>
                
                </h5>

                <hr>

            </c:forEach>




        </div>
    </body>

</html>
