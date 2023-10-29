<%-- 
    Document   : resultadoconsultarporid
    Created on : 26 de mai. de 2023, 18:20:40
    Author     : Gustavo-PC
--%>

<%@page import="model.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado Cosultar por ID</title>
    </head>
    <body>
        <h1>Resultado Consultar por ID</h1>
        <%
            Funcionario f = (Funcionario) request.getAttribute("p");
        %>
        <%if (f.getNome() != null) {%>

        <form name="f1" action="controle_funcionario" method="GET">
            ID..........: <%out.print(f.getId());%> <input type="hidden" name="txtid" value="<%out.print(f.getId());%>"> <BR>
            Nome...: <input type="text" name="txtnome" value="<%out.print(f.getNome());%>">  <BR>
            Data de nascimento.......: <input type="text" name="txtdt_nascimento" value="<%out.print(f.getDt_nascimento());%>">  <BR>
            Cargo.......: <input type="text" name="txtcargo" value="<%out.print(f.getCargo());%>">  <BR>
            <input type="submit" name="op" value="EFETIVAR ATUALIZAÇÃO">
        </form>
        <%} else {%>
        <h2>Funcionário não cadastrado.</h2>
        <%}%>
    </body>
</html>
