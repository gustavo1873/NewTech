<%-- 
    Document   : resultado
    Created on : 26 de mai. de 2023, 12:32:34
    Author     : Gustavo-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Resultado</title>
    </head>
    <body>
        <%
           String msg = (String) request.getAttribute("message");
        %>        
        <h1><%out.println(msg);%> realizado com sucesso.</h1>
    </body>
</html>
