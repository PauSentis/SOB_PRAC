package cat.urv.deim.sob;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Professor {
    
    private String nom;
    private String contrasenya;
    private String usuari;
    private int id;
    private ArrayList<Projecte> listProjectes = new ArrayList<>();
    private Boolean valid = false;
    
    public Professor(){
        
    }
    
    public Professor(int id, String nom, String contrasenya, String usuari){
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
    
    public void setId(int id){
        this.id=id;
    }
    
    public ArrayList<Projecte> getListProjectes(){
        return listProjectes;
    }
    
    public void setListProjectes(ArrayList<Projecte> listProjecte){
        this.listProjectes = listProjecte;
    }
    
    public void addProjecte(Projecte p){
        listProjectes.add(p);
    }
    
    public boolean isValid(String pass){
        
        if(contrasenya.equals(pass)){
            valid = true;
        }else{
            valid = false;
        }
        
        return valid;
    }
    
    public void setValid(boolean valid){
        this.valid = valid;
    }
    
}
