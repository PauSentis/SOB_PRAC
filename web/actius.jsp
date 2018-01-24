<%@page import="java.util.ArrayList"%>
<%@page import="cat.urv.deim.sob.Projecte"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Llistat de tots els TFGs</title>
        <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            text-align: center;
        }
        </style>
    </head>
    <body>
        <table style="width:50%">
            <thead>
                <tr>
                    <th>Títol</th>
                    
                    <th>Estat</th>
                    <th>Grau</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<Projecte> list = (ArrayList<Projecte>) request.getAttribute("actius");
                    out.print("<tr>");
                    for(Projecte projecte : list){
                        out.print("<tr><td>"+projecte.getTitol()+"</td><td>"+projecte.getEstat()+"</td><td>"+projecte.getEstudis()+"</td><tr>");
                }
                %>
            </tbody>
        </table>
    </body>
</html>

