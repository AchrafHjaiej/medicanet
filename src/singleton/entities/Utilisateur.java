/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton.entities;

/**
 *
 * @author ACHRAF
 */
public class Utilisateur {
    private int id_user;
    private String nom;
    private String prenom;
    private String username;
    private String mail;
    private String password;
    private int telephone;
    private String role;
    private String adresse;
    private int age;
    private String specialite;
    private String sexe;
    private String bio;
    private int nb1;

    public int getNb1() {
        return nb1;
    }

    public void setNb1(int nb1) {
        this.nb1 = nb1;
    }

    public Utilisateur(String role, int nb1) {
        this.role = role;
        this.nb1 = nb1;
    }
    

    public Utilisateur(int id_user, String nom, String prenom, String username, String mail, String password, int telephone, String role, String adresse, int age, String specialite, String sexe, String bio) {
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.telephone = telephone;
        this.role = role;
        this.adresse = adresse;
        this.age = age;
        this.specialite = specialite;
        this.sexe = sexe;
        this.bio = bio;
    }

    public Utilisateur() {
    }
    
    

    public Utilisateur(String nom, String prenom, String username, String mail, String password, int telephone, String role, String adresse, int age, String specialite, String sexe, String bio) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.telephone = telephone;
        this.role = role;
        this.adresse = adresse;
        this.age = age;
        this.specialite = specialite;
        this.sexe = sexe;
        this.bio = bio;
    }


    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getAge() {
        return age;
    }

    public String getSpecialite() {
        return specialite;
    }

    public String getSexe() {
        return sexe;
    }

    public String getBio() {
        return bio;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
    

    @Override
    public String toString() {
        return "Utilisateur{" + "id_user=" + id_user + ", nom=" + nom + ", prenom=" + prenom + ", username=" + username + ", mail=" + mail + ", password=" + password + ", telephone=" + telephone + ", role=" + role + ", adresse=" + adresse + ", age=" + age + ", specialite=" + specialite + ", sexe=" + sexe + ", bio=" + bio + '}';
    }



}
