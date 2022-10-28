/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton.entities;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author LENOVO
 */
public class Reclamation {
    
    private int id_reclamation;
    private String message;
    private String date_reclamation;
    private String objet_reclamation;
    private int id_user;
    private int id_categorie;
   private String etat_reclamation;
   private String typeReclamation;

    public String getTypeReclamation() {
        return typeReclamation;
    }

    public void setTypeReclamation(String typeReclamation) {
        this.typeReclamation = typeReclamation;
    }

    public Reclamation(int id_reclamation, String message, String date_reclamation, String objet_reclamation, int id_user, int id_categorie, String etat_reclamation, String typeReclamation) {
        this.id_reclamation = id_reclamation;
        this.message = message;
        this.date_reclamation = date_reclamation;
        this.objet_reclamation = objet_reclamation;
        this.id_user = id_user;
        this.id_categorie = id_categorie;
        this.etat_reclamation = etat_reclamation;
        this.typeReclamation = typeReclamation;
    }

  
    public Reclamation(String message, String date_reclamation, String objet_reclamation, int id_user, int id_categorie) {
        this.message = message;
        this.date_reclamation = date_reclamation;
        this.objet_reclamation = objet_reclamation;
        this.id_user = id_user;
        this.id_categorie = id_categorie;
    }

    public Reclamation(String message, String date_reclamation, String objet_reclamation, int id_user, int id_categorie, String etat_reclamation) {
        this.message = message;
        this.date_reclamation = date_reclamation;
        this.objet_reclamation = objet_reclamation;
        this.id_user = id_user;
        this.id_categorie = id_categorie;
        this.etat_reclamation = etat_reclamation;
    }

    public Reclamation(int id_reclamation, String message, String date_reclamation, String objet_reclamation, int id_user, int id_categorie) {
        this.id_reclamation = id_reclamation;
        this.message = message;
        this.date_reclamation = date_reclamation;
        this.objet_reclamation = objet_reclamation;
        this.id_user = id_user;
        this.id_categorie = id_categorie;
    }

    public Reclamation(int id_reclamation, String message, String objet_reclamation, int id_user) {
        this.id_reclamation = id_reclamation;
        this.message = message;
        this.objet_reclamation = objet_reclamation;
        this.id_user = id_user;
    }

    public Reclamation() {
    }

    public String getEtat_reclamation() {
        return etat_reclamation;
    }

    public void setEtat_reclamation(String etat_reclamation) {
        this.etat_reclamation = etat_reclamation;
    }

    public Reclamation(int id_reclamation, String message, String date_reclamation, String objet_reclamation, int id_user, int id_categorie, String etat_reclamation) {
        this.id_reclamation = id_reclamation;
        this.message = message;
        this.date_reclamation = date_reclamation;
        this.objet_reclamation = objet_reclamation;
        this.id_user = id_user;
        this.id_categorie = id_categorie;
        this.etat_reclamation = etat_reclamation;
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

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }


    
}
