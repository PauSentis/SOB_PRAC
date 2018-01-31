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
import com.sun.xml.bind.StringInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Toni Ciordia
 */
@Path("tfg")
public class RESTProjecte {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray findAll(@Context UriInfo info) throws ServletException, IOException{
        
        Gson gson = new Gson();
        
        ProjecteDAO daoProj = new ProjecteDAO();
        
        MultivaluedMap<String, String> state = info.getQueryParameters();
        ArrayList<Projecte> projectes;

        if(state.getFirst("state")==null){
            projectes = daoProj.findAll();
            
        }else{
            projectes = new ArrayList<>();
            ArrayList<Projecte> allProjects = daoProj.findAll();
      
            for (String estat: state.get("state")){
                for (Projecte proj : allProjects) {
                    if (proj.getEstat().equals(estat)) {
                        projectes.add(proj);
                    }
                }
            }
                      
        }
            String json = gson.toJson(projectes);
            
            JsonArray js = Json.createReader(new StringReader(json)).readArray();
        
        return js;
        
    }
    /*
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/assign")
    public JsonObject assignStudents(){
        
    }*/
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public JsonObject findById(@PathParam("id") String id) throws ServletException, IOException{
        
        Gson gson = new Gson();
        
        ProjecteDAO daoProj = new ProjecteDAO();
        
        Projecte projecte = daoProj.findById(Integer.parseInt(id));
        
        String json = gson.toJson(projecte);
        
        JsonObject jsonObject = Json.createReader(new StringReader(json)).readObject();
        return jsonObject;
        
    }
    
    
}
