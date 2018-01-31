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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

/**
 *
 * @author Toni Ciordia
 */
public class ProjecteDAO implements DAO.Dao{

    @Override
    public ArrayList<Projecte> findAll() throws ServletException, IOException {
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
                                p.addProfessor(profe);
                            }
                        }
                    }
                }
            }
            
            
            connect.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProjecteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return projectes;
    }
    
    public ArrayList<Projecte> findActius() throws ServletException, IOException {
        ArrayList<Projecte> projectes = new ArrayList<>();
        ArrayList<Professor> professors = new ArrayList<>();
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection connect = DriverManager.getConnection("jdbc:derby://localhost:1527/SOBDB", "root", "root");
            Statement stmt1 = connect.createStatement();
            
            String query = "SELECT * FROM SOBDB.PROJECTE WHERE ESTAT != 'Defensat' ORDER BY TITOL";
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
                                p.addProfessor(profe);
                            }
                        }
                    }
                }
            }
            
            
            connect.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProjecteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return projectes;
    }
    
    public ArrayList<Projecte> findAnteriors() throws ServletException, IOException {
       ArrayList<Projecte> projectes = new ArrayList<>();
        ArrayList<Professor> professors = new ArrayList<>();
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
           try (Connection connect = DriverManager.getConnection("jdbc:derby://localhost:1527/SOBDB", "root", "root")) {
               Statement stmt1 = connect.createStatement();
               
               String query = "SELECT * FROM SOBDB.PROJECTE WHERE ESTAT = 'Defensat' ORDER BY TITOL";
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
                                   p.addProfessor(profe);
                               }
                           }
                       }
                   }
               }
           }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProjecteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return projectes;
    }

    
    public ArrayList<Projecte> findByProfessor(int IDprofessor) throws ServletException, IOException {
        
            ArrayList<Projecte> projectes = findAll();
            ArrayList<Projecte> result = new ArrayList<>();
            
            for(Projecte p: projectes){
                for(Professor profe: p.getListProfessor()){
                    if(profe.getId()==IDprofessor){
                        result.add(p);
                    }
                }
            }
        return result;
    }
    
    public void update (int id, String title, String desc, String state, String estudiants, String estudis, 
            String recursos, String data_defensa, String nota, String data_creacio, String data_mod, ArrayList<Professor> professors){
            
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection connect = DriverManager.getConnection("jdbc:derby://localhost:1527/SOBDB", "root", "root");
            Statement stmt1 = connect.createStatement();
            
            String query = "UPDATE SOBDB.PROJECTE SET TITOL='"+title
                        + "', DESCRIPCIO ='"+desc
                        + "', ESTAT ='"+state
                        + "', ESTUDIANTS ='"+estudiants
                        + "', ESTUDIS ='"+estudis
                        + "', RECURSOS ='"+recursos
                        + "', DATA_DEFENSA ='"+data_defensa
                        + "', QUALIFICACIO ='"+nota
                        + "', DATA_CREACIO ='"+data_creacio
                        + "', DATA_MODIFICACIO ='"+data_mod
                        + "' WHERE IDPROJ="+id;
            
            stmt1.executeUpdate(query);
            
            for(Professor p: professors){
                query = "INSERT INTO SOBDB.PROFPROJ (IDPROFESSOR, IDPROJECTE) VALUES ("+p.getId()+","+id+")";
                stmt1.executeUpdate(query);
            }
           
        connect.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProjecteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Projecte findById(int id) throws ServletException, IOException{
            ArrayList<Projecte> projectes = findAll();
            for(Projecte proj: projectes){
                if(proj.getId()==id) return proj;
            }
            return null;
    }
    
    public void insert (String title, String state, String estudis, String data_creacio, ArrayList<Professor> professors) throws ServletException, IOException{
            
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            try (Connection connect = DriverManager.getConnection("jdbc:derby://localhost:1527/SOBDB", "root", "root")) {
                Statement stmt1 = connect.createStatement();
                
                String query ="INSERT INTO SOBDB.PROJECTE (TITOL, ESTAT, ESTUDIS, DATA_CREACIO) VALUES "
                            + "('"+title
                            + "','"+state
                            + "','"+estudis
                            + "','"+data_creacio+"')";
                stmt1.executeUpdate(query);
                
                for(Professor p: professors){
                    query = "INSERT INTO SOBDB.PROFPROJ (IDPROFESSOR, IDPROJECTE) VALUES ("+p.getId()+","+findAll().size()+")";
                    stmt1.executeUpdate(query);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProjecteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
