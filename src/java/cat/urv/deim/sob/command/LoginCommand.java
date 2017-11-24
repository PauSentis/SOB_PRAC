/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.urv.deim.sob.command;

import cat.urv.deim.sob.Professor;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pau
 */
public class LoginCommand implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Professor profe = new Professor();
        
       profe.setUsuari(request.getParameter("usuari"));
       profe.setContrasenya(request.getParameter("pass"));
        
        
        
        
        
    }
    
    
    
}
