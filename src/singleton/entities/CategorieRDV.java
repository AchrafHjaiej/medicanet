/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.esprit.projet_sante.entities;

/**
 *
 * @author Youssef
 */
public class CategorieRDV {
    private int id_categorie_rdv;
    private int id_rdv;
    private String categorie;

    public CategorieRDV(int id_categorie_rdv, int id_rdv, String categorie) {
        this.id_categorie_rdv = id_categorie_rdv;
        this.id_rdv = id_rdv;
        this.categorie = categorie;
    }

    public CategorieRDV(int id_rdv, String categorie) {
        this.id_rdv = id_rdv;
        this.categorie = categorie;
    }
    

    

    public int getId_categorie_rdv() {
        return id_categorie_rdv;
    }

    public void setId_categorie_rdv(int id_categorie_rdv) {
        this.id_categorie_rdv = id_categorie_rdv;
    }

    public int getId_rdv() {
        return id_rdv;
    }

    public void setId_rdv(int id_rdv) {
        this.id_rdv = id_rdv;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "CategorieRDV{" + "id_categorie_rdv=" + id_categorie_rdv + ", id_rdv=" + id_rdv + ", categorie=" + categorie + '}';
    }

    

    
    
    
}
