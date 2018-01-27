/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.urv.deim.sob.command;

import Entitats.ProjecteDAO;
import cat.urv.deim.sob.Projecte;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Toni Ciordia
 */
public class ModificarCommand implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        ProjecteDAO dao = new ProjecteDAO();
        Projecte p = (Projecte) request.getAttribute("p");
        //dao.update(p.getId(),p.getTitol(),p.getDescripcio(),p.getEstat(),p.getEstudiants(),p.getEstudis(),p.getRecursos(),p.getData_defensa(),p.getQualificacio(),p.getData_creacio(),p.getData_modificacio());
        request.setAttribute("proj", p);
        ServletContext context = request.getSession().getServletContext();
        context.getRequestDispatcher("/modificar.jsp").forward(request, response);
        
    }
    
}
