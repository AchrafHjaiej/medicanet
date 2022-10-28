/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton.Service;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import singleton.iservice.IService;
import singleton.utils.MyDB;
import java.util.*;
import java.sql.ResultSet;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import singleton.entities.Categorie;
import singleton.iservice.IService2;

/**
 *
 * @author LENOVO
 */
public class ServiceCategorie implements IService2<Categorie> {
   
    private Connection con;
    private Statement ste;
    
    public ServiceCategorie(){
    
      con=MyDB.getInstance().getConnection();
    }

    @Override
    public void ajouter2(Categorie c) throws SQLException {
     PreparedStatement pre= con.prepareStatement("INSERT INTO catégorie (`id_categorie`,`type_reclamation`) VALUES (?,?);");
     pre.setInt(1,c.getId_categorie());
     pre.setString(2,c.getType_reclamation());
    
    
     pre.executeUpdate();
    }

    @Override
    public boolean update(Categorie c) throws SQLException {
     ste= con.createStatement();
     String req ="UPDATE `catégorie` SET `id_categorie`='"+c.getId_categorie()+"', `type_reclamation` = '"+c.getType_reclamation()+"' where id_categorie = '"+c.getId_categorie()+"'; ";
     ste.executeUpdate(req);
     System.out.println("Votre catégorie est Modifier");
      return true;
    }

    @Override
    public boolean delete(Categorie c) throws SQLException {
     ste= con.createStatement();
     String req ="DELETE from   `catégorie` where id_categorie = '"+c.getId_categorie()+"'; ";
     ste.executeUpdate(req);   
     System.out.println("Votre categorie est Supprimer");
     return true;
    }

    @Override
    public List<Categorie> readAll() throws SQLException {
          List<Categorie> arr= new ArrayList<>();
       
        ste=con.createStatement();
        ResultSet re =ste.executeQuery("select * from catégorie");
        
         while (re.next()){
            Categorie c = new Categorie();
            c.setId_categorie(re.getInt("id_Categorie"));
            c.setType_reclamation(re.getString("type_reclamation"));
          
          
          
            arr.add(c);
        
       
        }
        
        
        return arr;
         
    }
    
   public  ObservableList<String>  GetTypeCategorie() throws SQLException{
         ste=con.createStatement();
        ResultSet re =ste.executeQuery("select type_reclamation from catégorie");
       ObservableList<String> list = FXCollections.observableArrayList();
       String type ;
        while (re.next()){       
            type= re.getString("type_reclamation");
                    list.add(type);

        }
        
        return list;
    
    }
   
   public long Search1() throws SQLException {

        List<Categorie> Abon = readAll();
        return Abon.stream().filter(b -> b.getType_reclamation().equalsIgnoreCase("Avis")).count();

    }

    public long Search2() throws SQLException {

        List<Categorie> Abon = readAll();
        return Abon.stream().filter(b -> b.getType_reclamation().equalsIgnoreCase("Feedback")).count();

    }

    public long Search3() throws SQLException {

        List<Categorie> Abon = readAll();
        return Abon.stream().filter(b -> b.getType_reclamation().equalsIgnoreCase("Reclamation")).count();

    }
     
    
    
        public int rechRec(String rec) throws SQLException {
          
       
        ste=con.createStatement();
        ResultSet re =ste.executeQuery("select id_Categorie from catégorie where type_reclamation='"+rec+"'");
        int id=0;
         while (re.next()){
            id=re.getInt("id_Categorie");
                 
       
        }
        
        
        return id;
         
    }

}
