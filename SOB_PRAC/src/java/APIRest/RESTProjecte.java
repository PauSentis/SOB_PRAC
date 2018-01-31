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
import com.google.gson.reflect.TypeToken;
import com.sun.xml.bind.StringInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.binding.Bindings;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
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
    
    @Path("{id}/assign")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response assignStudents(JsonObject jsonInici,  @PathParam("id") String id) throws ServletException, IOException{
        String user = jsonInici.getString("user");
        String password = jsonInici.getString("password");
        
        ProfessorDAO professorDAO = new ProfessorDAO();
        Professor profe = professorDAO.findByProfessor(user);
        
        
        if(profe==null||!profe.isValid(password)){
            return Response.status(Response.Status.CREATED).entity("Error, autentificació incorrecte").build();
        }else{
            String s = jsonInici.getString("noms");
        
            ProjecteDAO daoProj = new ProjecteDAO();
            Projecte p = daoProj.findById(Integer.parseInt(id));
            if(p.getEstudiants().length()>0){
                s= p.getEstudiants()+", "+s;
            }

            daoProj.update(p.getId(), p.getTitol(), p.getDescripcio(), p.getEstat(),
                    s, p.getEstudis(), p.getRecursos(), p.getData_defensa(),
                    p.getQualificacio(), p.getData_creacio(), p.getData_modificacio(), p.getListProfessor());
        }
        
        return Response.status(Response.Status.CREATED).entity("Alumnes acutalitzats correctament").build();
    }
    
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
