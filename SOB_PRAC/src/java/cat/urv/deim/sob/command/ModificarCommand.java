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
        
        ServletContext context = request.getSession().getServletContext();
        ProjecteDAO dao = new ProjecteDAO();
        int idProj = Integer.parseInt(request.getParameter("idProj"));
        Projecte p = dao.findById(idProj);
        request.setAttribute("projecgteM", p);
        context.setAttribute("projecgteM", p);
        System.out.println("Estat"+p.getTitol());
        
        switch (p.getEstat()){
            case "Proposat":
                context.getRequestDispatcher("/proposat.jsp").forward(request, response);
                break;
            
            case "Assignat":
                context.getRequestDispatcher("/assignat.jsp").forward(request, response);
                break;
                
            case "Acabat":
                context.getRequestDispatcher("/acabat.jsp").forward(request, response);
                break;
                
            case "Pendent de defensa":
                context.getRequestDispatcher("/pendentdedefensa.jsp").forward(request, response);
                break;
                
            case "Defensat":
                context.getRequestDispatcher("/defensat.jsp").forward(request, response);
                break;
        }
    }
    
}
