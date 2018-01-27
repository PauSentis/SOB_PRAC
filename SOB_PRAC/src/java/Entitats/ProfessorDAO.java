/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitats;

import cat.urv.deim.sob.Professor;
import cat.urv.deim.sob.Projecte;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

/**
 *
 * @author Pau
 */
public class ProfessorDAO implements DAO.Dao{
    
    @Override
    public ArrayList<Professor> findAll() throws ServletException, IOException {
        ArrayList<Projecte> projectes = new ArrayList<>();
        ArrayList<Professor> professors = new ArrayList<>();
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection connect = DriverManager.getConnection("jdbc:derby://localhost:1527/SOBDB", "root", "root");
            Statement stmt1 = connect.createStatement();
            
            String query = "SELECT * FROM SOBDB.PROJECTE ORDER BY TITOL";
            ResultSet rs = stmt1.executeQuery(query);
            while(rs.next()){
                projectes.add(new Projecte(rs.getInt("IDPROJ"), rs.getString("TITOL"), rs.getString("DESCRIPCIO"), rs.getString("ESTAT"), rs.getString("ESTUDIANTS"), rs.getString("ESTUDIS"), rs.getString("RECURSOS"), rs.getString("DATA_DEFENSA"), rs.getString("QUALIFICACIO"), rs.getString("DATA_CREACIO"), rs.getString("DATA_MODIFICACIO")));
            }
            
            query = "SELECT * FROM SOBDB.PROFESSOR ORDER BY IDPROF";
            rs = stmt1.executeQuery(query);
            while(rs.next()){
                professors.add(new Professor(rs.getInt("IDPROF"), rs.getString("NOM"), rs.getString("PASS"), rs.getString("USUARI")));
            }
            
            query = "SELECT * FROM SOBDB.PROFPROJ ORDER BY IDPROJECTE";
            rs = stmt1.executeQuery(query);
            while(rs.next()){
                int idProfe = rs.getInt("IDPROFESSOR");
                int idProj = rs.getInt("IDPROJECTE");
                for(Projecte p: projectes){
                    if(p.getId()==idProj){
                        for(Professor profe: professors){
                            if(profe.getId()==idProfe){
                                profe.addProjecte(p);
                            }
                        }
                    }
                }
            }
            
            
            connect.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProjecteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return professors;
    }
    
    
    
    public Professor findByProfessor(String user) throws ServletException, IOException {
        
        ArrayList<Professor> professors = findAll();
        Professor result = null;

        for(Professor profe: professors){
            if(profe.getUsuari().equals(user)){
                result = profe;
            }
        }
        
        return result;
    }
    
}
