<%-- 
    Document   : resultadoconsultartodos
    Created on : 25 de mai. de 2023, 23:59:23
    Author     : Gustavo-PC
--%>

<%@page import="java.util.List"%>
<%@page import="model.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado Consultar Todos</title>
    </head>
    <body>
        <h1>Funcionários</h1>
        <%
            List<Funcionario> listfunc = (List<Funcionario>) request.getAttribute("listfunc");
        %>


        <table border="1">
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Salario</th>
                <th>Remover</th>
                <th>Editar</th>
            </tr>

            <%for (Funcionario f : listfunc) {%>
            <tr>                
                <td><%out.print(f.getId());%></td>
                <td><%out.print(f.getNome());%></td>
                <td><%out.print(f.getSalario());%></td>
                <td align="center"><a href="http://localhost:8080/NewTech/controle_funcionario?op=DELETAR&txtid=<%out.print(f.getId());%>"><img src="images/lixeira01.png" width="25" height="25"></a></td>
                <td align="center"><a href="http://localhost:8080/NewTech/controle_funcionario?txtid=<%out.print(f.getId());%>&txtnome=<%out.print(f.getNome());%>&txtsalario=<%out.print(f.getSalario());%>&op=ATUALIZAR" ><img src="images/editar01.png" width="25" height="25"></a></td>
            </tr>
            <%}%>

        </table>
    </body>
</html>
