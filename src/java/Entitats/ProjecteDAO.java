/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitats;

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
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection connect = DriverManager.getConnection("jdbc:derby://localhost:1527/SOBDB", "root", "root");
            Statement stmt1 = connect.createStatement();
            Statement stmt2 = connect.createStatement();
            
            String query = "SELECT * FROM SOBDB.PROJECTE ORDER BY IDPROJ";
            ResultSet rs = stmt1.executeQuery(query);
            while(rs.next()){
                projectes.add(new Projecte(rs.getInt("IDPROJ"), rs.getString("TITOL"), rs.getString("DESCRIPCIO"), rs.getString("ESTAT"), rs.getString("ESTUDIANTS"), rs.getString("ESTUDIS"), rs.getString("RECURSOS"), rs.getString("DATA_DEFENSA"), rs.getString("QUALIFICACIO"), rs.getString("DATA_CREACIO"), rs.getString("DATA_MODIFICACIO")));
            }
            connect.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProjecteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return projectes;
    }
    
    
    
}
