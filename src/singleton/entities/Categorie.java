/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton.entities;

/**
 *
 * @author LENOVO
 */
public class Categorie {
    
     private int id_categorie;
    private String type_reclamation;
  

    public Categorie(int id_categorie, String type_reclamation) {
        this.id_categorie = id_categorie;
        this.type_reclamation = type_reclamation;
       
    }

    public Categorie(String type_reclamation) {
        this.type_reclamation = type_reclamation;
        
    }

    public Categorie() {
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getType_reclamation() {
        return type_reclamation;
    }

    public void setType_reclamation(String type_reclamation) {
        this.type_reclamation = type_reclamation;
    }

   

    @Override
    public String toString() {
        return "Categorie{" + "id_categorie=" + id_categorie + ", type_reclamation=" + type_reclamation + '}';
    }

   
    
  
    
    
    
}


