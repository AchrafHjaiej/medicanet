/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import GUI.Statistique;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import singleton.Service.ServiceUtilisateur;
import singleton.entities.Utilisateur;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import singleton.Service.ServiceCategorie;
import singleton.Service.ServiceReclamation;

/**
 * FXML Controller class
 *
 * @author ACHRAF
 */
public class StatController implements Initializable {

    @FXML
    private PieChart stat1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            AfficheStat(null);
            //Search2();
        } catch (SQLException ex) {
            Logger.getLogger(StatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
     
   ServiceUtilisateur serv= new ServiceUtilisateur();
   //List<Utilisateur> list= serv.readAll();
   
       void AfficheStat(ActionEvent event) throws SQLException {
         ServiceCategorie sc = new ServiceCategorie();
        stat1.setTitle("Les statistiques sur les Types des Reclamations ");
       // stat.getData().setAll(new PieChart.Data("Avis", sc.Search1()), new PieChart.Data("Feedback", sc.Search2()),
              //  new PieChart.Data("Reclamation", sc.Search3()));
              int nb1=0;
                      ServiceUtilisateur sr =new ServiceUtilisateur();
                      nb1=sr.statRole().size();
                     // System.out.println();
    for(int i=0; i<nb1;i++)
    {
        stat1.getData().add(new PieChart.Data(sr.statRole().get(i).getRole(),sr.statRole().get(i).getNb1()));
        
    }
       }
    
     
    }
    

