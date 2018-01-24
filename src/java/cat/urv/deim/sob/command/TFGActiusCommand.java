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

public class TFGActiusCommand implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        ProjecteDAO dao = new ProjecteDAO();
        ArrayList<Projecte> actius = dao.findActius();
        ServletContext context = request.getSession().getServletContext();
        request.setAttribute("actius", actius);
        context.getRequestDispatcher("/actius.jsp").forward(request, response);
    }
    
}
