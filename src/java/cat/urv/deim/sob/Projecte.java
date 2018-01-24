package cat.urv.deim.sob;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Projecte {
    
    private int id;
    private String titol;
    private String descripcio;
    private String estat;
    private String estudiants;
    private String estudis;
    private String recursos;
    private String data_defensa;
    private String qualificacio;
    private String data_creacio;
    private String data_modificacio;
    private ArrayList<Professor> listProfessor;
    
    public Projecte (int id, String titol, String descripcio, String estat,String estudiants, String estudis, String recursos, String data_defensa, String qualificacio, String data_creacio, String data_modificacio){
        this.id=id;
        this.titol=titol;
        this.descripcio=descripcio;
        this.estat=estat;
        this.estudiants=estudiants;
        this.estudis=estudis;
        this.recursos=recursos;
        this.data_defensa=data_defensa;
        this.qualificacio=qualificacio;
        this.data_creacio=data_creacio;
        this.data_modificacio=data_modificacio;                
    }

    public int getId() {
        return id;
    }

    public String getTitol() {
        return titol;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public String getEstat() {
        return estat;
    }
    
    public String getEstudiants() {
        return estudiants;
    }

    public String getEstudis() {
        return estudis;
    }

    public String getRecursos() {
        return recursos;
    }

    public String getData_defensa() {
        return data_defensa;
    }

    public String getQualificacio() {
        return qualificacio;
    }

    public String getData_creacio() {
        return data_creacio;
    }

    public String getData_modificacio() {
        return data_modificacio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }
    
    public void setEstudiants(String estudiants) {
        this.estudiants = estudiants;
    }

    public void setEstudis(String estudis) {
        this.estudis = estudis;
    }

    public void setRecursos(String recursos) {
        this.recursos = recursos;
    }

    public void setData_defensa(String data_defensa) {
        this.data_defensa = data_defensa;
    }

    public void setQualificacio(String qualificacio) {
        this.qualificacio = qualificacio;
    }

    public void setData_creacio(String data_creacio) {
        this.data_creacio = data_creacio;
    }

    public void setData_modificacio(String data_modificacio) {
        this.data_modificacio = data_modificacio;
    }
    
    
    
    
}
