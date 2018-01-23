<%-- 
    Document   : login
    Created on : 23-ene-2018, 18:37:22
    Author     : Pau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>
      Login
    </title>
  </head>
  <body>
    <h1>Login</h1>
  <form action="login.do" method="post">
      <label>Nom</label>
      <input type="text" name="usuari" /><br>
      <label>Contrasenya</label>
      <input type="password" name="pass" /><br>
      <input type="submit" value="Iniciar Sesion"/>
  </form>
  </body>
</html>
