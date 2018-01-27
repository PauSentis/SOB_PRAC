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
                      out.print("<input name=titol type=text size=100 maxlength=100>");
                  }else{
                      out.print("<input name=titol type=text value='"+p.getTitol()+"' size=100 maxlength=100>");
                  }%>
            </tr>
            <tr>

                <td> Professors</td>
                <td>
                    <%if(p==null){
                      out.print("<input name=professors type=text size=100 maxlength=100>");
                  }else{
                      out.print("<input name=professors type=text value='"+p.getProfessors().toString()+"' size=100 maxlength=100>");
                  }%>

            </tr>
            <tr>
                <td> Estudis</td>
                <td>
                    <%if(p==null){
                      out.print("<input name=estudis type=text size=100 maxlength=100>");
                  }else{
                      out.print("<input name=estudis type=text value='"+p.getEstudis()+"' size=100 maxlength=100>");
                  }%>
            </tr>
            <tr>
                <td> Descripció</td>
                <td>
                    <%if(p==null){
                      out.print("<input name=descripcio type=text size=100 maxlength=100>");
                  }else{
                      out.print("<input name=descripcio type=text value='"+p.getDescripcio()+"' size=100 maxlength=100>");
                  }%>
            </tr>
            <tr>
                <td> Estudiants</td>
                <td>
                    <%if(p==null){
                      out.print("<input name=estudiants type=text size=100 maxlength=100>");
                  }else{
                      out.print("<input name=estudiants type=text value='"+p.getEstudiants()+"' size=100 maxlength=100>");
                  }%>
            </tr>
            <tr>
                <td> Recursos </td>
                <td>
                    <%if(p==null){
                      out.print("<input name=recursos type=text size=100 maxlength=100>");
                  }else{
                      out.print("<input name=recursos type=text value='"+p.getRecursos()+"' size=100 maxlength=100>");
                  }%> 
            </tr>
            <tr>
                <td> Data defensa </td>
                <td>
                    <%if(p==null){
                      out.print("<input name=data_defensa type=text size=100 maxlength=100>");
                  }else{
                      out.print("<input name=data_defensa type=text value='"+p.getData_defensa()+"' size=100 maxlength=100>");
                  }%> 
            </tr>
            <tr>
                <td> Qualificació </td>
                <td>
                    <%if(p==null){
                      out.print("<input name=qualificacio type=text size=100 maxlength=100>");
                  }else{
                      out.print("<input name=qualificacio type=text value='"+p.getQualificacio()+"' size=100 maxlength=100>");
                  }%> 
            </tr>
            <tr >
                <td> Data modificació </td>
                <td>
                    <%if(p==null){
                      out.print("<input name=data_modificacio type=text size=100 maxlength=100>");
                  }else{
                      out.print("<input name=data_modificacio type=text value='"+p.getData_modificacio()+"' size=100 maxlength=100>");
                  }%>
            
            
           </td>
    </tr>
    <tr >
       <td> Estat </td>
       <td>
          <input  type="radio" name="estat" value="proposat">Proposat
          <input type="radio" name="estat" value="assignat">Assignat
          <input type="radio" name="estat" value="acabat">Acabat
          <input type="radio" name="estat" value="pendent_de_defensa">Pendent de defensa
          <input type="radio" name="estat" value="defensat">Defensat
      </td>
    
    </tr>
    <input type="button" name="enviar" title="enviar" value="Enviar">
</table>
    </form>
</div>

</body>
</html>