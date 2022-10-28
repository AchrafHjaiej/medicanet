/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.esprit.projet_sante.entities;

import java.util.Date;

/**
 *
 * @author Youssef
 */
public class Rendez_vous {
    
    private int id_RV,id_patient,id_medecin;
    private String heure_RV,categorie;
    private Date date_RV;

    public Rendez_vous(int id_RV, int id_patient, int id_medecin, String heure_RV, String categorie, Date date_RV) {
        this.id_RV = id_RV;
        this.id_patient = id_patient;
        this.id_medecin = id_medecin;
        this.heure_RV = heure_RV;
        this.categorie = categorie;
        this.date_RV = date_RV;
    }
    
    
    
    

    public Rendez_vous(Date date_RV, String heure_RV) {
        this.heure_RV = heure_RV;
        this.date_RV = date_RV;
    }

    public Rendez_vous(int id_RV, int id_patient, int id_medecin, Date date_RV, String heure_RV) {
        this.id_RV = id_RV;
        this.id_patient = id_patient;
        this.id_medecin = id_medecin;
        this.date_RV = date_RV;
        this.heure_RV = heure_RV;
    }
    

    public Rendez_vous(int id_patient, int id_medecin, Date date_RV, String heure_RV) {
        this.id_patient = id_patient;
        this.id_medecin = id_medecin;
        this.date_RV = date_RV;
        this.heure_RV = heure_RV;
    }

    public Rendez_vous() {
    }

    public int getId_RV() {
        return id_RV;
    }

    public void setId_RV(int id_RV) {
        this.id_RV = id_RV;
    }

    public int getId_patient() {
        return id_patient;
    }

    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }

    public int getId_medecin() {
        return id_medecin;
    }

    public void setId_medecin(int id_medecin) {
        this.id_medecin = id_medecin;
    }

    public Date getDate_RV() {
        return date_RV;
    }

    public void setDate_RV(Date date_RV) {
        this.date_RV = date_RV;
    }

    public String getHeure_RV() {
        return heure_RV;
    }

    public void setHeure_RV(String heure_RV) {
        this.heure_RV = heure_RV;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    
    
    
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public String toString() {
        return "Rendez_vous{" + "id_RV=" + id_RV + ", id_patient=" + id_patient + ", id_medecin=" + id_medecin + ", heure_RV=" + heure_RV + ", categorie=" + categorie + ", date_RV=" + date_RV + '}';
    }
    
    
    
     
}
