/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APIRest;

import Entitats.ProfessorDAO;
import Entitats.ProjecteDAO;
import cat.urv.deim.sob.Professor;
import cat.urv.deim.sob.Projecte;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.JsonObject;
import javax.servlet.ServletException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Toni Ciordia
 */

@Path("/professor")
public class RESTProfessor {
    
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public JsonObject ProfeById(@PathParam("id") String id) throws ServletException, IOException{
       
        Gson gson = new Gson();
        
        ProjecteDAO daoProj = new ProjecteDAO();
        ProfessorDAO daoProf = new ProfessorDAO();
        
        ArrayList<Projecte> projectes = daoProj.findByProfessor(Integer.parseInt(id));
        Professor profe = daoProf.findById(Integer.parseInt(id));
        profe.setListProjectes(projectes);
        
        
        String json = gson.toJson(profe);
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        return jsonObject;
        
    }
    
}
