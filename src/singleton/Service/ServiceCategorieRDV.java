/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton.Service;

import edu.esprit.projet_sante.entities.CategorieRDV;
//import edu.esprit.projet_sante.utils.MyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import singleton.utils.MyDB;

/**
 *
 * @author Youssef
 */
public class ServiceCategorieRDV {
    private Connection con;
    private Statement ste;
    public ServiceCategorieRDV(){
        con = MyDB.getInstance().getConnection();

    }
    public void ajouter(CategorieRDV c) throws SQLException {
        PreparedStatement pre= con.prepareStatement("INSERT INTO `medicanet`.`categorie_rdv`(`id_categorie_rdv`, `id_rdv`, `categorie`)VALUES(?,?,?);");
        pre.setInt(1, c.getId_categorie_rdv());
        pre.setInt(2, c.getId_rdv());
        pre.setString(3, c.getCategorie()); 
        
        
        pre.executeUpdate();
    }
    
    public List<CategorieRDV> afficher() throws SQLException {
        List<CategorieRDV> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet r= ste.executeQuery("SELECT * FROM `categorie_rdv`");
        while (r.next()){
            int id_categorie_rdv = r.getInt("id_categorie_rdv");
            int id_rdv = r.getInt("id_rdv");
            String categorie =r.getString("categorie");
            
            
            CategorieRDV catrdv = new CategorieRDV(id_categorie_rdv, id_rdv,categorie); 
            arr.add(catrdv);
        }
    return arr;
    }
    
    
    public boolean modifiers(CategorieRDV r) throws SQLException {
            ste= con.createStatement();
            String rdv ="UPDATE `categorie_rdv` SET `id_categorie_rdv`='"+r.getId_categorie_rdv()+"', `id_rdv` = '"+r.getId_rdv()+"',`categorie` = '"+r.getCategorie()+"' where id_categorie_rdv = '"+r.getId_categorie_rdv()+"'; ";
            ste.executeUpdate(rdv);
            System.out.println("Votre categorie est Modifier");
            return true;
    }

    
    public boolean supprimer(CategorieRDV r) throws SQLException {
        ste= con.createStatement();
        String rdv ="DELETE from   `categorie_rdv` where id_categorie_rdv = '"+r.getId_categorie_rdv()+"'; ";
        ste.executeUpdate(rdv);   
        System.out.println("Votre categorie est Supprimer");
        return true;  
    }
    
}
