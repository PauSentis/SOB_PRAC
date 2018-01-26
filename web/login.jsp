<%-- 
    Document   : login
    Created on : 23-ene-2018, 18:37:22
    Author     : Pau
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="cat.urv.deim.sob.Projecte"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        
        <style>
           
            body {margin:0;background-color: #F2FBEF}

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
  <li><a href="TFGtots.do">Tots els projectes</a></li>
  <li class="active" style="float:right"><a href="login.jsp">Iniciar Sessió</a></li>
</ul>
    
<div style="padding:20px;margin-top:60px;margin-left:60px;background-color:#F2FBEF;margin:200px 300px;border:5px solid black;">
     <form action="login.do" method="post">
        <div align="center"
             <legend>Login</legend><br><br>
      <label>Nom d'usuari</label>
      <input type="text" name="usuari"/><br>
      <br><label>Contrasenya</label>
      <input type="password" name="pass" /><br><br>
        <input align="center" type="submit" value="Iniciar Sesion"/></div>
        <% if(request.getAttribute("error")!=null ){ %>
            <p class="errorMessage"> Usuari o contrasenya incorrecte </p>
        <% } %>
    </form>

</div>

</body>
</html>