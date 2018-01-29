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
import java.util.Iterator;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Toni Ciordia
 */
public class FerModificacioCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = request.getSession().getServletContext();
        ProjecteDAO dao = new ProjecteDAO();
        Projecte p = (Projecte) context.getAttribute("projecgteM");
        
        ProfessorDAO profeDAO = new ProfessorDAO();
        
        String s = request.getParameter("professors");
        StringBuilder sb = new StringBuilder();
        ArrayList<Professor> professors = new ArrayList();
        
        for(int n=0; n<s.length(); n++){
            char c = s.charAt(n);
            System.out.println("Lletra: "+c);
            if(c==','){
                if(sb.toString().trim().length()>0 && (profeDAO.findByProfessor(sb.toString().trim())!=null)){
                    professors.add(profeDAO.findByProfessor(sb.toString().trim()));
                }
                sb = new StringBuilder();
            }else{
                sb.append(c);
            }
        }
        
        if(sb.toString().trim().length()>0 && (profeDAO.findByProfessor(sb.toString().trim())!=null)){
            professors.add(profeDAO.findByProfessor(sb.toString().trim()));
        }
        
        System.out.println("Llista: "+professors.toString());
        for(Professor profeProj: p.getListProfessor()){
            for (Professor profeAdd : professors) {
                if(profeProj.getId()==profeAdd.getId()){
                    professors.remove(profeAdd);
                }
            }
        }
        
        
        
        switch (p.getEstat()){
            case "Proposat":
                dao.update(p.getId(), 
                        request.getParameter("titol"), 
                        p.getDescripcio(), 
                        request.getParameter("estat"), 
                        p.getEstudiants(), 
                        request.getParameter("estudis"), 
                        p.getRecursos(), 
                        p.getData_defensa(), 
                        p.getQualificacio(), 
                        request.getParameter("data_creacio"), 
                        p.getData_modificacio(), 
                        professors);
                break;
            case "Assignat":
                dao.update(p.getId(), 
                        request.getParameter("titol"), 
                        request.getParameter("descripcio"), 
                        request.getParameter("estat"), 
                        request.getParameter("estudiants"), 
                        request.getParameter("estudis"), 
                        request.getParameter("recursos"), 
                        p.getData_defensa(), 
                        p.getQualificacio(), 
                        p.getData_creacio(), 
                        p.getData_modificacio(), 
                        professors);
                break;
                
            case "Acabat":
                System.out.println("Acabat");
                dao.update(p.getId(), 
                        request.getParameter("titol"), 
                        request.getParameter("descripcio"), 
                        request.getParameter("estat"), 
                        request.getParameter("estudiants"), 
                        request.getParameter("estudis"), 
                        request.getParameter("recursos"), 
                        p.getData_defensa(), 
                        p.getQualificacio(), 
                        p.getData_creacio(), 
                        request.getParameter("data_modificacio"), 
                        professors);
                break;
                
            case "Pendent de defensa":
                dao.update(p.getId(), 
                        request.getParameter("titol"), 
                        request.getParameter("descripcio"), 
                        request.getParameter("estat"), 
                        request.getParameter("estudiants"), 
                        request.getParameter("estudis"), 
                        request.getParameter("recursos"), 
                        request.getParameter("data_defensa"), 
                        p.getQualificacio(), 
                        p.getData_creacio(), 
                        request.getParameter("data_modificacio"), 
                        professors);
                break;
                
            case "Defensat":
                dao.update(p.getId(), 
                        request.getParameter("titol"), 
                        request.getParameter("descripcio"), 
                        request.getParameter("estat"), 
                        request.getParameter("estudiants"), 
                        request.getParameter("estudis"), 
                        request.getParameter("recursos"), 
                        request.getParameter("data_defensa"), 
                        request.getParameter("qualificacio"), 
                        p.getData_creacio(), 
                        request.getParameter("data_modificacio"), 
                        professors);
                break;
        }
        
        context.getRequestDispatcher("/login.do").forward(request, response);
    }
    
}
