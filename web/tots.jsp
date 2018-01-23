<%-- 
    Document   : listAll
    Created on : 23-ene-2018, 10:35:04
    Author     : Toni Ciordia
--%>

<%@page import="cat.urv.deim.sob.Projecte"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Llistat de tots els TFGs</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Títol</th>
                    <th>Professor</th>
                    <th>Estat</th>
                    <th>Grau</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Projecte> list = (List<Projecte>) request.getAttribute(""); //ficar al getAttribute el q volem demanar
                    out.print("<tr>");
                    for(Projecte projecte : list){
                        out.print("<tr><td>"+projecte.getTitol()+"</td><td>"+/* falta el getProfessor*/"</td><td>"+projecte.getEstat()+"</td><td>"+projecte.getEstudis()+"</td><tr>");
                }
                %>
            </tbody>
        </table>
    </body>
</html>
