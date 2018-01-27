<%@page import="java.util.ArrayList"%>
<%@page import="cat.urv.deim.sob.Projecte"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Llistat dels TFGs anteriors</title>
        
        <style>
            table, th, td {
                    border: 1px solid black;
                    border-collapse: collapse;
                    text-align: center;
                }

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
  <li><a class="active" href="TFGanteriors.do">Projectes Anteriors</a></li>
  <li><a href="TFGtots.do">Tots els projectes</a></li>
  <li style="float:right"><a href="login.jsp">Iniciar Sessió</a></li>
</ul>
guilipolles
<div style="padding:20px;margin-top:60px;margin-left:10px;background-color:#F2FBEF;height:1500px;">

    <table style="width:100%">
        <thead>
            <tr>
                <th>Títol</th>
                <th>Professors</th>
                <th>Estat</th>
                <th>Estudis</th>
                <th>Descripció</th>
                <th>Estudiant/s</th>
                <th>Recursos</th>
                <th>Data defensa</th>
                <th>Data modificació</th>
                <th>Qualificació</th>
            </tr>
        </thead>
        <tbody>
           <%
                ArrayList<Projecte> list = (ArrayList<Projecte>) request.getAttribute("anteriors");
                out.print("<tr>");
                for(Projecte projecte : list){
                    String url;
                    out.print("<tr><td>"+projecte.getTitol()+"</td><td>");
                    for (int i =0; i<projecte.getListProfessor().size(); i++){
                        url = "TfgsProfe.do?id="+projecte.getListProfessor().get(i).getId();
                        if(i!=projecte.getListProfessor().size()-1){
                             out.print("<a href= "+url+">"+ projecte.getListProfessor().get(i).getNom()+", </a>");
                        }else{
                             out.print("<a href= "+url+">"+ projecte.getListProfessor().get(i).getNom()+" </a>");
                        }
                       
                    }
                    out.print("</td><td>"+projecte.getEstat()+"</td><td>"+projecte.getEstudis()+"</td><td>"+projecte.getDescripcio()+"</td><td>"+projecte.getEstudiants()+"</td><td>"+projecte.getRecursos()+"</td><td>"+projecte.getData_defensa()+"</td><td>"+projecte.getData_modificacio()+"</td><td>"+projecte.getQualificacio()+"</td><tr>");
                }
            %>
        </tbody>
    </table>

</div>

</body>
</html>