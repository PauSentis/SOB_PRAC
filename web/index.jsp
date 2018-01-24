<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
  <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>
      SOB p1
    </title>
  </head>
  <body>
 <% 
    ServletContext context = request.getSession().getServletContext();
    RequestDispatcher r = context.getRequestDispatcher("/TFGtots.do");
    r.forward(request, response); %>
  </body>
</html>