/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton.entities;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author LENOVO
 */
public class AfficheAdmin {
    private int id_reclamation;
    private String message;
    private String date_reclamation;
    private String objet_reclamation;
    private int id_user;
    private String type_reclamation;
    private int id_categorie;
    private String username;
    private String mail;
    private String etat_reclamation;

    public AfficheAdmin(int id_reclamation, String message, String date_reclamation, String objet_reclamation, int id_user, String type_reclamation, int id_categorie, String username, String mail) {
        this.id_reclamation = id_reclamation;
        this.message = message;
        this.date_reclamation = date_reclamation;
        this.objet_reclamation = objet_reclamation;
        this.id_user = id_user;
        this.type_reclamation = type_reclamation;
        this.id_categorie = id_categorie;
        this.username = username;
        this.mail = mail;
    }

    public AfficheAdmin(int id_reclamation, String message, String date_reclamation, String objet_reclamation, int id_user, String type_reclamation, int id_categorie, String username, String mail, String etat_reclamation) {
        this.id_reclamation = id_reclamation;
        this.message = message;
        this.date_reclamation = date_reclamation;
        this.objet_reclamation = objet_reclamation;
        this.id_user = id_user;
        this.type_reclamation = type_reclamation;
        this.id_categorie = id_categorie;
        this.username = username;
        this.mail = mail;
        this.etat_reclamation = etat_reclamation;
    }

    public AfficheAdmin() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getEtat_reclamation() {
        return etat_reclamation;
    }

    public void setEtat_reclamation(String etat_reclamation) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

 

    
}
