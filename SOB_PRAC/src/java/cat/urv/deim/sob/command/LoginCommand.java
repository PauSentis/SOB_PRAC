/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.urv.deim.sob.command;

import Entitats.ProfessorDAO;
import Entitats.ProjecteDAO;
import cat.urv.deim.sob.Professor;
import cat.urv.deim.sob.Projecte;
import java.io.IOException;
import java.util.ArrayList;
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
        
        ProfessorDAO professorDAO = new ProfessorDAO();
        
        Professor profe = professorDAO.findByProfessor(request.getParameter("usuari"));
        
        if(profe==null||!profe.isValid(request.getParameter("pass"))){
            request.setAttribute("error", true);
            context.getRequestDispatcher("/login.jsp").forward(request, response);
        }else{
            HttpSession session = request.getSession(true);
            ProjecteDAO dao = new ProjecteDAO();
            ArrayList<Projecte> proj = dao.findByProfessor(profe.getId());
            request.setAttribute("proj", proj);
            session.setAttribute("currentSessionUser", profe);
            context.getRequestDispatcher("/userLogged.jsp").forward(request, response);
        }
    }
}
