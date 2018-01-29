/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.urv.deim.sob.command;

import Entitats.ProjecteDAO;
import cat.urv.deim.sob.Professor;
import cat.urv.deim.sob.Projecte;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pau
 */
public class FerAfegirCommand implements Command{
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = request.getSession().getServletContext();
        ProjecteDAO dao = new ProjecteDAO();
        
        StringBuilder s = new StringBuilder();
        
        dao.insert(request.getParameter("titol"), 
                request.getParameter("estat"), 
                request.getParameter("estudis"), 
                request.getParameter("data_creacio"), 
                new ArrayList<Professor>());
        
        context.getRequestDispatcher("/login.do").forward(request, response);
    }
}
