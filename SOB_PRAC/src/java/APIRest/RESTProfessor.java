/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APIRest;

import Entitats.ProjecteDAO;
import cat.urv.deim.sob.Projecte;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Toni Ciordia
 */

@Path("/professor")
public class RESTProfessor {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Professor ProfeById(@PathParam("id") String id) throws ServletException, IOException{
        
        ProjecteDAO dao = new ProjecteDAO();
        ArrayList<Projecte> projectes = dao.findByProfessor(Integer.parseInt(id));
        
        
        
    }
    
}
