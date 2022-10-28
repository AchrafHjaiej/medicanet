/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package singleton_jdbc;

import singleton.Service.ServiceUtilisateur;
import singleton.entities.Utilisateur;
import singleton.utils.MyDB;
import java.util.*;
import java.sql.SQLException;



/**
 *
 * @author ACHRAF
 */
public class Singleton_JDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyDB db = MyDB.getInstance();
        
        
        ServiceUtilisateur serv= new ServiceUtilisateur();
        Utilisateur t1 =new Utilisateur("kabbous","tessnime","tass","kabbous.tessnime@esprit.tn","tass",28695127,"ADMIN","avenue taieb mhiri rue ali azzabi hammamet 8050",25,"cardiologue","HOMME","residant");
       Utilisateur t2 =new Utilisateur("leila","Trabelsi","tarek","achref.hjaiej@esprit.tn","fdfd",25154475,"MEDECIN","avenue taieb mhiri rue ali azzabi hammamet 8050",25,"cardiologue","FEMME","residant");
       Utilisateur t3 =new Utilisateur("salah","Hjaiej","lasmer","achref.hjaiej@esprit.tn","fddf",25154475,"PATIENT","avenue taieb mhiri rue ali azzabi hammamet ",25,"cardiologue","HOMME","residant");
        Utilisateur t4 =new Utilisateur("fawez","Hjaiej","tijani","achref.hjaiej@esprit.tn","dfdf",25154475,"ADMIN","avenue taieb mhiri rue ali azzabi hammamet ",25,"cardiologue","HOMME","residant");
        
        try {
       serv.ajouter(t1);
        //serv.ajouter(t2);
        //serv.ajouter2(t3);
        //serv.ajouter2(t4);
        //Utilisateur t =new Utilisateur(3, "kabous", "tasnim", "ukjbj", "mkjhkjh", "passwokhbbkjrd", "telone", "robkhle", "adkjresse");
        //serv.update(t);
        
        //Utilisateur t =new Utilisateur(13, "nom", "prenom", "username", "mail", "password", "telephone", "role", "adresse" );
        //serv.delete(t);
        List<Utilisateur> list= serv.readAll();
            System.out.println(list);
        
        } catch (SQLException ex){
            System.out.println(ex);
                    }
     
    } 
        
        
        
        
        
        
       

    }

