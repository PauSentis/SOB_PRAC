/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;

public interface Dao {
    
    public ArrayList<?> findAll() throws ServletException, IOException;
    
    
}
