/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.javafx.font.FontFactory;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import singleton.entities.Reclamation;
import singleton.iservice.IService;
import singleton.utils.MyDB;
import java.util.*;
import java.sql.ResultSet;
import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;
import singleton.entities.AfficheAdmin;
import singleton.entities.recCat;
import singleton.iservice.IService2;

/**
 *
 * @author LENOVO
 */
public class ServiceReclamation implements IService2<Reclamation> {

    private Connection con;
    private Statement ste;

    public ServiceReclamation() {

        con = MyDB.getInstance().getConnection();
    }

    /*public void ajouter(Reclamation r) throws SQLException  {
     ste= con.createStatement();
    String req ="INSERT INTO `medicanet` ,`reclamation` INNER JOIN Utilisateur ON id_reclamation =Utilisateur.id_user
    (  `message`, `type_reclamation`,`objet_reclamation`,`id_user` ) VALUES ('"+r.getId_reclamation()+"','"+r.getMessage()+"','"+r.getType_reclamation()+"','"+r.getObjet_reclamation()+"','"+r.getId_user()+"')";
     ste.executeUpdate(req);   
    }*/
    @Override
    public void ajouter2(Reclamation r) throws SQLException {
        PreparedStatement pre = con.prepareStatement("INSERT INTO reclamation (`id_reclamation`,`message`,`date_reclamation`,`objet_reclamation`,`id_user`,`id_categorie`,`etat_reclamation`) VALUES (?,?,?,?,?,?,?);");
        pre.setInt(1, r.getId_reclamation());
        pre.setString(2, r.getMessage());
        pre.setString(3, r.getDate_reclamation());
        pre.setString(4, r.getObjet_reclamation());
        pre.setInt(5, r.getId_user());
        pre.setInt(6, r.getId_categorie());
        pre.setString(7, "non traité");
        System.out.println(pre);
        pre.executeUpdate();

    }

    @Override
    public boolean update(Reclamation r) throws SQLException {

        /* ste= con.createStatement();
        System.out.println(r.getMessage());
     String req ="UPDATE `reclamation` SET `message`="+r.getMessage()+",`objet_reclamation`="+r.getObjet_reclamation()+" WHERE `id_reclamation`="+r.getId_reclamation() ;
        System.out.println(r.getMessage());
     ste.executeUpdate(req);
     System.out.println("Votre réclamation est Modifiée");
      return true;*/
        PreparedStatement prep = con.prepareStatement("UPDATE `reclamation` SET `message`=?,`objet_reclamation`=? WHERE `id_reclamation`=? ");
        prep.setInt(3, r.getId_reclamation());
        prep.setString(1, r.getMessage());
        prep.setString(2, r.getObjet_reclamation());
        prep.executeUpdate();
        return true;

    }

    @Override
    public boolean delete(Reclamation r) throws SQLException {
        ste = con.createStatement();
        String req = "DELETE from `reclamation` where id_Reclamation = '" + r.getId_reclamation() + "'; ";
        ste.executeUpdate(req);
        System.out.println("Votre reclamation est Supprimée");
        return true;

    }

    @Override
    public ObservableList<Reclamation> readAll() throws SQLException {
        ObservableList<Reclamation> arr = FXCollections.observableArrayList();
        LocalDate todaysDate = LocalDate.now();
        ste = con.createStatement();
        ResultSet re = ste.executeQuery("select * from reclamation");

        while (re.next()) {
            Reclamation r = new Reclamation();
            r.setId_reclamation(re.getInt("id_reclamation"));
            r.setMessage(re.getString("message"));
            r.setDate_reclamation(re.getString("date_reclamation"));
            r.setObjet_reclamation(re.getString("objet_reclamation"));
            r.setId_user(re.getInt("id_user"));
            r.setId_categorie(re.getInt("id_categorie"));
            arr.add(r);

        }

        return arr;

    }

    private int Sysdate() {

        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ObservableList<recCat> readRec(int idu) throws SQLException {
        ObservableList<recCat> arr = FXCollections.observableArrayList();
        LocalDate todaysDate = LocalDate.now();
        ste = con.createStatement();
        ResultSet re = ste.executeQuery("select id_reclamation,message,date_reclamation,objet_reclamation,id_user,type_reclamation,r.id_categorie from reclamation r join catégorie c on r.id_categorie=c.id_categorie where id_user='" + idu + "'");

        while (re.next()) {
            recCat r = new recCat(re.getInt("id_reclamation"), re.getString("message"), re.getString("date_reclamation"), re.getString("objet_reclamation"), re.getInt("id_user"), re.getString("type_reclamation"), re.getInt("id_categorie"));
            arr.add(r);

        }
        return arr;
    }

    public ObservableList<AfficheAdmin> readAllAd() throws SQLException {
        ObservableList<AfficheAdmin> arr = FXCollections.observableArrayList();
        LocalDate todaysDate = LocalDate.now();
        ste = con.createStatement();
        ResultSet re = ste.executeQuery("select id_reclamation,message,date_reclamation,objet_reclamation,u.id_user,type_reclamation,c.id_categorie,etat_reclamation,username,mail  from catégorie c join reclamation r on c.id_categorie=r.id_categorie join utilisateur  u on u.id_user=r.id_user");

        while (re.next()) {
            AfficheAdmin a = new AfficheAdmin(re.getInt("id_reclamation"), re.getString("message"), re.getString("date_reclamation"), re.getString("objet_reclamation"), re.getInt("id_user"), re.getString("type_reclamation"), re.getInt("id_categorie"), re.getString("username"), re.getString("mail"),re.getString("etat_reclamation"));
            arr.add(a);

        }
        return arr;
    }
    
    public ObservableList<AfficheAdmin> readRech(String rec) throws SQLException {
        ObservableList<AfficheAdmin> arr = FXCollections.observableArrayList();
        LocalDate todaysDate = LocalDate.now();
        ste = con.createStatement();
        ResultSet re = ste.executeQuery("select id_reclamation,message,date_reclamation,objet_reclamation,u.id_user,type_reclamation,c.id_categorie,etat_reclamation,username,mail  from catégorie c join reclamation r on c.id_categorie=r.id_categorie join utilisateur  u on u.id_user=r.id_user where r.etat_reclamation='"+rec+"'");

        while (re.next()) {
            AfficheAdmin a = new AfficheAdmin(re.getInt("id_reclamation"), re.getString("message"), re.getString("date_reclamation"), re.getString("objet_reclamation"), re.getInt("id_user"), re.getString("type_reclamation"), re.getInt("id_categorie"), re.getString("username"), re.getString("mail"),re.getString("etat_reclamation"));
            arr.add(a);

        }
        return arr;
    }
 
    public void traitéReclamation(Reclamation R) {
       
        String req;
        req = "UPDATE reclamation SET id_reclamation`=" + R.getId_reclamation() + ",`message`='" + R.getMessage() + "',`date_reclamation`='" + R.getDate_reclamation() + "',`objet_reclamation`='" + R.getObjet_reclamation() + "',`id_user`=" + R.getId_user() + ",`id_categorie`=" + R.getId_categorie() + ",`etat_reclamation`=" + "traité";
        Statement st;
        try {
            st = con.createStatement();
            st.executeUpdate(req);
            System.out.println("la reclamation traité");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }}

    public void traitéReclamation2(AfficheAdmin R) {
       String req;
        req = "UPDATE reclamation SET id_reclamation`=" + R.getId_reclamation() + ",`message`='" + R.getMessage() + "',`date_reclamation`='" + R.getDate_reclamation() + "',`objet_reclamation`='" + R.getObjet_reclamation() + "',`id_user`=" + R.getId_user() + ",`id_categorie`=" + R.getId_categorie() + ",`etat_reclamation`=" + "traité";
        Statement st;
        try {
            st = con.createStatement();
            st.executeUpdate(req);
            System.out.println("la reclamation traité");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
    }
    //////////////////////////////////
    
  public ObservableList<recCat> statREC() throws SQLException {
        ObservableList<recCat> arr = FXCollections.observableArrayList();
        ste = con.createStatement();
        ResultSet re = ste.executeQuery("select count(*) nb,c.type_reclamation from reclamation r join catégorie c on r.id_categorie=c.id_categorie group BY c.type_reclamation");

        while (re.next()) {
            recCat a = new recCat(re.getInt("nb"),re.getString("type_reclamation"));
            arr.add(a);
        }
        
        return arr;
    }
 



}
    
   