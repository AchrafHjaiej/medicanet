/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton.Service;

import singleton.entities.Utilisateur;
import singleton.iservice.IService;
import singleton.utils.MyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import singleton.entities.recCat;



/**
 *
 * @author ACHRAF
 */
public class ServiceUtilisateur implements IService<Utilisateur>{
  private Connection con;
  private Statement ste;

    public ServiceUtilisateur() {
        con = MyDB.getInstance().getConnection();
    }
   
  
    @Override
    public void ajouter(Utilisateur t) throws SQLException {
     ste= con.createStatement();
     String req ="INSERT INTO  `medicanet` .`utilisateur` ( `nom`,`prenom`, `username`, `mail`, `password`, `telephone`, `role`, `adresse`, `age`, `specialite`, `sexe`, `bio`) VALUES ('"+t.getNom()+"','"+t.getPrenom()+"','"+t.getUsername()+"','"+t.getMail()+"','"+t.getPassword()+"','"+t.getTelephone()+"','"+t.getRole()+"','"+t.getAdresse()+"','"+t.getAge()+"','"+t.getSpecialite()+"','"+t.getSexe()+"','"+t.getBio()+"')";
     ste.executeUpdate(req); 
     System.out.println("Votre utilisateur est Ajoutée avec succès !!"); 
    }
 
     public void ajouter2(Utilisateur t) throws SQLException {
     PreparedStatement pre= con.prepareStatement("INSERT INTO `medicanetapp`.`utilisateur` ( `nom`, `prenom`, `username`, `mail`, `password`, `telephone`, `role`, `adresse`, `age`, `specialite`, `sexe`, `bio`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);");
     pre.setString(1,t.getNom());
     pre.setString(2,t.getPrenom());
     pre.setString(3,t.getUsername());
     pre.setString(4,t.getMail());
     pre.setString(5,t.getPassword());
     pre.setInt(6,t.getTelephone());
     pre.setString(7,t.getRole());
     pre.setString(8,t.getAdresse());
     pre.setInt(9,t.getAge());
     pre.setString(10,t.getSpecialite());
     pre.setString(11,t.getSexe());
     pre.setString(12,t.getBio());
     pre.executeUpdate();
     System.out.println("Votre utilisateur est Ajoutée avec succès !!");  
    }

    @Override
    public boolean update(Utilisateur t) throws SQLException {
        
              ste= con.createStatement();
     String req ="UPDATE `medicanet` .`utilisateur` SET `id_user`='"+t.getId_user()+"', `nom` = '"+t.getNom()+"',`prenom` = '"+t.getPrenom()+"',`username`='"+t.getUsername()+"',`mail`='"+t.getMail()+"',`password`='"+t.getPassword()+"',`telephone`='"+t.getTelephone()+"',`role`='"+t.getRole()+"',`adresse`='"+t.getAdresse()+  "',`age`='"+t.getAge()+"',`specialite`='"+t.getSpecialite()+"',`sexe`='"+t.getSexe()+"',`bio`='"+t.getBio()+     "' where id_user = '"+t.getId_user()+"'; ";
     ste.executeUpdate(req);
     System.out.println("Votre utilisateur est Modifier !!");
      return true;
        
                                                             }

    @Override
    public boolean delete(Utilisateur t) throws SQLException {
       
       
     
      ste= con.createStatement();
     String req ="DELETE from  `medicanet` .`utilisateur` where id_user = '"+t.getId_user()+"'; ";
     ste.executeUpdate(req);   
     System.out.println("Votre utilisateur est Supprimer !!");
     return true;
     
    }

    @Override
    public List<Utilisateur> readAll() throws SQLException {
        List<Utilisateur> arr= new ArrayList<>();
        ste=con.createStatement();
        ResultSet r =ste.executeQuery("select * from utilisateur");
        while (r.next()){
        int id_user = r.getInt("id_user");
        String nom=r.getString("nom");
        String prenom=r.getString("prenom");
        String username=r.getString("username");
        String mail=r.getString("mail");
        String password=r.getString("password");
        int telephone=r.getInt("telephone");
        String role=r.getString("role");
        String adresse=r.getString("adresse");
        int age = r.getInt("age");
        String specialite=r.getString("specialite");
        String sexe=r.getString("sexe");
        String bio=r.getString("bio");
        Utilisateur t = new Utilisateur(id_user,nom,prenom,username,mail,password,telephone,role,adresse,age,specialite,sexe,bio);
       arr.add(t);
       
        }
        
        
        return arr;
    }
  

    
  public ObservableList<Utilisateur> statRole() throws SQLException {
        ObservableList<Utilisateur> arr = FXCollections.observableArrayList();
        ste = con.createStatement();
        
        ResultSet re = ste.executeQuery("select count(*) nb1 ,role from utilisateur GROUPE BY role");
   
        while (re.next()) 
        
        
        {
            Utilisateur a = new Utilisateur(re.getString("role"),re.getInt("nb1"));
            arr.add(a);
        }
        
        return arr;
    }
 
 
     
    
}
