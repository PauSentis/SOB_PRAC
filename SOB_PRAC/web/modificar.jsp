<%@page import="cat.urv.deim.sob.Professor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cat.urv.deim.sob.Projecte"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Llistat de tots els TFGs</title>
        
        <style>
            body {margin:0;background-color:#F2FBEF;}

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
  <li><a href="TFGactius.do">Projectes Actius</a></li>
  <li><a href="TFGanteriors.do">Projectes Anteriors</a></li>
  <li><a class="active" href="TFGtots.do">Tots els projectes</a></li>
  <li style="float:right"><a href="login.jsp">Iniciar Sessió</a></li>
</ul>

<div style="padding:20px;margin-top:60px;margin-left:10px;height:1500px;">

        <table border="1" align="center">
            <tr>

              <td> Nombre</td>
              <td><input name="nombre" type="text" size="35" maxlength="35">
            </tr>
            <tr>

                <td> Apellido Paterno</td>
                <td><input name="apellidoP" type="text" size="35" maxlength="35">

            </tr>
            <tr>
                <td> Apellido Materno</td>
                <td><input name="apellidoM" type="text" size="35" maxlength="35">

            </tr>
            <tr>
                <td> E-mail</td>
                <td><input name="email" type="text" size="35" maxlength="35">

            </tr>
            <tr>
                <td> Edad </td>
                <td><input name="edad" type="text" size="2" maxlength="2">
            </tr>
            <tr >
                <td> Sexo </td>
                <td>
                <input  type="radio" name="rd">Masculino
                <input type="radio" name="rd">Femenino
            <input type="button" name="enviar" title="enviar" value="Enviar">
           </td>
    
    </tr>
</table>

</div>

</body>
</html>