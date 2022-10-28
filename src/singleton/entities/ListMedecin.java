/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.esprit.projet_sante.entities;

/**
 *
 * @author Youssef
 */
public class ListMedecin {
    
    private int id_user;
    private String nom;
    private String prenom;
    private String username;
    private String mail;
    private String password;
    private String telephone;
    private String role;
    private String adresse;
    private String specialite;
    private String disponabilite;
    private String bio;

    public ListMedecin(int id_user, String nom, String prenom, String username, String mail, String password, String telephone, String role, String adresse) {
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.telephone = telephone;
        this.role = role;
        this.adresse = adresse;
    }

    public ListMedecin(int id_user, String nom, String prenom, String username, String mail, String password, String telephone, String role, String adresse, String specialite, String bio) {
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.telephone = telephone;
        this.role = role;
        this.adresse = adresse;
        this.specialite = specialite;
        this.bio = bio;
    }

    public ListMedecin(String nom, String prenom, String telephone, String adresse, String specialite, String disponabilite, String bio) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.adresse = adresse;
        this.specialite = specialite;
        this.disponabilite = disponabilite;
        this.bio = bio;
    }

    public ListMedecin(String nom, String adresse, String specialite, String bio) {
        this.nom = nom;
        this.adresse = adresse;
        this.specialite = specialite;
        this.bio = bio;
    }

    public ListMedecin(int id_user, String nom, String adresse, String specialite, String bio) {
        this.id_user = id_user;
        this.nom = nom;
        this.adresse = adresse;
        this.specialite = specialite;
        this.bio = bio;
    }

    
    
    public ListMedecin(int id_user, String nom, String prenom, String username, String mail, String password, String telephone, String role, String adresse, String specialite, String disponabilite, String bio) {
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.telephone = telephone;
        this.role = role;
        this.adresse = adresse;
        this.specialite = specialite;
        this.disponabilite = disponabilite;
        this.bio = bio;
    }
    
    
    

    public int getId_user() {
        return id_user;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getUsername() {
        return username;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getRole() {
        return role;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getDisponabilite() {
        return disponabilite;
    }

    public void setDisponabilite(String disponabilite) {
        this.disponabilite = disponabilite;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "ListMedecin{" + "id_user=" + id_user + ", nom=" + nom + ", prenom=" + prenom + ", username=" + username + ", mail=" + mail + ", password=" + password + ", telephone=" + telephone + ", role=" + role + ", adresse=" + adresse + ", specialite=" + specialite + ", disponabilite=" + disponabilite + ", bio=" + bio + '}';
    }
    
    

    
    
}
