/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton.Service;

import edu.esprit.projet_sante.entities.ListMedecin;
import singleton.utils.MyDB;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Youssef
 */
public class ServiseListMed {
    
    private Connection con;
    private Statement ste;
    public ServiseListMed() {
                con = MyDB.getInstance().getConnection();
    }
    
    public List<ListMedecin> afficher() throws SQLException {
        List<ListMedecin> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet r= ste.executeQuery("SELECT * FROM `utilisateur` where role = 'MEDECIN'; ");
        while (r.next()){
            
            int id_user = r.getInt("id_user");
            String nom=r.getString("nom");
            String prenom=r.getString("prenom");
            String username=r.getString("username");
            String mail=r.getString("mail");
            String password=r.getString("password");
            String telephone=r.getString("telephone");
            String role=r.getString("role");
            String adresse=r.getString("adresse");
            String specialite=r.getString("specialite");
            String bio=r.getString("bio");
            ListMedecin t = new ListMedecin(id_user,nom,prenom,username,mail,password,telephone,role,adresse,specialite,bio);
            arr.add(t);
        }
    return arr;
    }
}
