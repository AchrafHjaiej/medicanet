package GUI;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
 import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import singleton.Service.ServiceCategorie;
import singleton.Service.ServiceReclamation;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class FXMLController implements Initializable {
    


    @FXML
    private PieChart stat;

   



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            AfficheStat(null);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
 
    
     void AfficheStat(ActionEvent event) throws SQLException {
         ServiceCategorie sc = new ServiceCategorie();
        stat.setTitle("Les statistiques sur les Types des Reclamations ");
       // stat.getData().setAll(new PieChart.Data("Avis", sc.Search1()), new PieChart.Data("Feedback", sc.Search2()),
              //  new PieChart.Data("Reclamation", sc.Search3()));
              int nb=0;
                      ServiceReclamation sr =new ServiceReclamation();
                      nb=sr.statREC().size();
    for(int i=0; i<nb;i++)
    {
        stat.getData().add(new PieChart.Data(sr.statREC().get(i).getType_reclamation(),sr.statREC().get(i).getNbr()));
    }
    
    }
    
    
}
