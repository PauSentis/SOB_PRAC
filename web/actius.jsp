<%@page import="java.util.ArrayList"%>
<%@page import="cat.urv.deim.sob.Projecte"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Llistat dels TFGs actius</title>
        
        <style>
            table, th, td {
                    border: 1px solid black;
                    border-collapse: collapse;
                    text-align: center;
                }

            body {margin:0;}

            ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
                overflow: hidden;
                background-color: #333;
                position: fixed;
                top: 0;
                width: 100%;
            }

            li {
                border-right: 1px solid #bbb;
                float: left;
            }

            li a {
                display: block;
                color: white;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
            }

            li a:hover:not(.active) {
                background-color: #111;
            }

            .active {
                background-color: #4CAF50;
            }
        </style>
</head>
<body>

<ul>
  <li><a class="active" href="TFGactius.do">Projectes Actius</a></li>
  <li><a href="TFGanteriors.do">Projectes Anteriors</a></li>
  <li><a href="TFGtots.do">Tots els projectes</a></li>
  <li style="float:right"><a href="login.do">Iniciar Sessió</a></li>
</ul>

<div style="padding:20px;margin-top:30px;background-color:#1abc9c;height:1500px;">

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

</div>

</body>
</html>