package cat.urv.deim.sob;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pau
 */
public class Professor {
    
    private String nom;
    private String contrasenya;
    private String usuari;
    private int id;
    
    public Professor(){
        
    }
    
    public Professor(String nom, String contrasenya, String usuari, int id){
        this.nom = nom;
        this.contrasenya = contrasenya;
        this.usuari = usuari;
        this.id = id;
    }
    
    public String getNom(){
        return nom;
    }
    
    public void setNom(String nom){
        this.nom=nom;
    }
    
    public String getConstrasenya(){
        return contrasenya;
    }
    
    public void setContrasenya(String contrasenya){
        this.contrasenya=contrasenya;
    }
    
    public String getUsuari(){
        return usuari;
    }
    
    public void setUsuari(String usuari){
        this.usuari=usuari;
    }
    
    public int getId(){
        return id;
    }
    
    public void setNom(int id){
        this.id=id;
    }
    
}
