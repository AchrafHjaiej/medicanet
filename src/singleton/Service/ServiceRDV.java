/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton.Service;


import edu.esprit.projet_sante.entities.ListMedecin;
import edu.esprit.projet_sante.entities.Rendez_vous;
//import edu.esprit.projet_sante.gui.ReserverRDVController;
import singleton.utils.MyDB;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
//import java.util.Date;
import java.sql.Date;



/**
 *
 * @author Youssef
 */
public class ServiceRDV {
    private Connection con;
    private Statement ste;
    public ServiceRDV(){
                con = MyDB.getInstance().getConnection();

    }
    
    public void ajouter(Rendez_vous r) throws SQLException {
        PreparedStatement pre= con.prepareStatement("INSERT INTO `medicanet`.`rendez_vous`( `id_patient`, `id_medecin`,`date_RV`,`heure_RV`)VALUES(?,?,?,?);");
        pre.setInt(1, r.getId_patient());
        pre.setInt(2, r.getId_medecin());
        pre.setDate(3, (java.sql.Date) r.getDate_RV()); 
        pre.setString(4, r.getHeure_RV());
        
        pre.executeUpdate();
    }
    
    
    public List<Rendez_vous> afficher() throws SQLException {
        List<Rendez_vous> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet r= ste.executeQuery("SELECT * FROM `rendez_vous`");
        System.out.println(r);
        while (r.next()){
            int id_RV = r.getInt("id_RV");
            Date date_RV =r.getDate("date_RV");
            String heure_RV =r.getString("heure_RV");
            int id_patient = r.getInt("id_patient");
            int id_medecin = r.getInt("id_medecin");
            Rendez_vous rdv = new Rendez_vous(id_RV, id_patient,id_medecin, date_RV, heure_RV); 
            arr.add(rdv);
        }
    return arr;
    }
    
    public List<Rendez_vous> afficher3(Integer rdv1) throws SQLException {
        List<Rendez_vous> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet r= ste.executeQuery("SELECT * FROM `rendez_vous`where id_medecin = '"+rdv1+"';");
        System.out.println(r);
        while (r.next()){
            int id_RV = r.getInt("id_RV");
            Date date_RV =r.getDate("date_RV");
            String heure_RV =r.getString("heure_RV");
            int id_patient = r.getInt("id_patient");
            int id_medecin = r.getInt("id_medecin");
            Rendez_vous rdv = new Rendez_vous(id_RV, id_patient,id_medecin, date_RV, heure_RV); 
            arr.add(rdv);
        }
    return arr;
    }
    
    public List<Rendez_vous> afficher2() throws SQLException {
        List<Rendez_vous> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet r= ste.executeQuery("SELECT * FROM `rendez_vous` JOIN categorie_rdv");
        System.out.println(r);
        while (r.next()){
            int id_RV = r.getInt("id_RV");
            Date date_RV =r.getDate("date_RV");
            String heure_RV =r.getString("heure_RV");
            int id_patient = r.getInt("id_patient");
            int id_medecin = r.getInt("id_medecin");
            String categorie = r.getString("categorie");
            Rendez_vous rdv = new Rendez_vous(id_RV, id_patient,id_medecin,heure_RV ,categorie ,date_RV); 
            arr.add(rdv);
        }
    return arr;
    }
    
    
    
    
    
    
    
    
    
    
    public boolean modifiers(Rendez_vous r) throws SQLException {
            ste= con.createStatement();
            String rdv ="UPDATE `rendez_vous` SET `id_RV`='"+r.getId_RV()+"', `date_RV` = '"+r.getDate_RV()+"',`heure_RV` = '"+r.getHeure_RV()+"', `id_patient` = '"+r.getId_patient()+"',`id_medecin` = '"+r.getId_medecin()+"' where id_RV = '"+r.getId_RV()+"'; ";
            ste.executeUpdate(rdv);
            System.out.println("Votre rendez-vous est Modifier");
            return true;
    }

    
    public boolean supprimer(Rendez_vous r) throws SQLException {
        ste= con.createStatement();
        String rdv ="DELETE from   `rendez_vous` where id_RV = '"+r.getId_RV()+"'; ";
        ste.executeUpdate(rdv);   
        System.out.println("Votre rendez-vous est Supprimer");
        return true;  
    }
    

    
}
