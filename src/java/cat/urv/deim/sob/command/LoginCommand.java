/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.urv.deim.sob.command;

import cat.urv.deim.sob.Professor;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command{
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext context = request.getSession().getServletContext();
        
        Professor profe = new Professor();

        profe.setUsuari(request.getParameter("usuari"));
        profe.setContrasenya(request.getParameter("pass"));
        
        

        if(profe.isValid()){
            HttpSession session = request.getSession(true);
            session.setAttribute("currentSessionUser", profe);
            response.sendRedirect("userLogged.jsp");
        }

        else{
             request.setAttribute("error", true);
             context.getRequestDispatcher("/login.jsp").forward(request, response);
             return;
        }

    }
    
    
    
}
