/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton.entities;

/**
 *
 * @author LENOVO
 */
public class recCat {
    private int nbr;
    private int id_reclamation;
    private String message;
    private String date_reclamation;
    private String objet_reclamation;
    private int id_user;
    private String type_reclamation;
    private int id_categorie;

    public int getNbr() {
        return nbr;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
    }

    public recCat(int nbr, String type_reclamation) {
        this.nbr = nbr;
        this.type_reclamation = type_reclamation;
    }

    
    public recCat(int id_reclamation, String message, String date_reclamation, String objet_reclamation, int id_user, String type_reclamation, int id_categorie) {
        this.id_reclamation = id_reclamation;
        this.message = message;
        this.date_reclamation = date_reclamation;
        this.objet_reclamation = objet_reclamation;
        this.id_user = id_user;
        this.type_reclamation = type_reclamation;
        this.id_categorie = id_categorie;
    }

    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate_reclamation() {
        return date_reclamation;
    }

    public void setDate_reclamation(String date_reclamation) {
        this.date_reclamation = date_reclamation;
    }

    public String getObjet_reclamation() {
        return objet_reclamation;
    }

    public void setObjet_reclamation(String objet_reclamation) {
        this.objet_reclamation = objet_reclamation;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getType_reclamation() {
        return type_reclamation;
    }

    public void setType_reclamation(String type_reclamation) {
        this.type_reclamation = type_reclamation;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }
    
    

    

   
    
    
    
}
