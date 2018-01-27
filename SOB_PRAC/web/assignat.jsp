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
    <% Projecte p = (Projecte) request.getAttribute("projecgteM");%>
    <form action="fermodificacio.do" method="post">
        <table border="1" align="center">
            <tr>

              <td> Títol</td>
              <td>
                  <%if(p==null){
                      out.print("<input name=nombre type=text size=100 maxlength=100>");
                  }else{
                      out.print("<input name=nombre type=text value='"+p.getTitol()+"' size=100 maxlength=100>");
                  }%>
            </tr>
            <tr>

                <td> Professors</td>
                <td>
                    <%if(p==null){
                      out.print("<input name=nombre type=text size=100 maxlength=100>");
                  }else{
                      out.print("<input name=nombre type=text value='"+p.getProfessors().toString()+"' size=100 maxlength=100>");
                  }%>

            </tr>
            <tr>
                <td> Estudis</td>
                <td>
                    <%if(p==null){
                      out.print("<input name=nombre type=text size=100 maxlength=100>");
                  }else{
                      out.print("<input name=nombre type=text value='"+p.getEstudis()+"' size=100 maxlength=100>");
                  }%>
            </tr>
            <tr>
                <td> Descripció</td>
                <td>
                    <%if(p==null){
                      out.print("<input name=nombre type=text size=100 maxlength=100>");
                  }else{
                      out.print("<input name=nombre type=text value='"+p.getDescripcio()+"' size=100 maxlength=100>");
                  }%>
            </tr>
            <tr>
                <td> Estudiants</td>
                <td>
                    <%if(p==null){
                      out.print("<input name=nombre type=text size=100 maxlength=100>");
                  }else{
                      out.print("<input name=nombre type=text value='"+p.getEstudiants()+"' size=100 maxlength=100>");
                  }%>
            </tr>
            <tr>
                <td> Recursos </td>
                <td>
                    <%if(p==null){
                      out.print("<input name=nombre type=text size=100 maxlength=100>");
                  }else{
                      out.print("<input name=nombre type=text value='"+p.getRecursos()+"' size=100 maxlength=100>");
                  }%> 
            
            
           </td>
    </tr>
    <tr >
       <td> Estat </td>
       <td>
          <input  type="radio" name="rd">Proposat
          <input type="radio" name="rd">Assignat
          <input type="radio" name="rd">Acabat
          <input type="radio" name="rd">Pendent de defensa
          <input type="radio" name="rd">Defensat
      </td>
    
    </tr>
    <input type="button" name="enviar" title="enviar" value="Enviar">
</table>
    </form>
</div>

</body>
</html>