/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui2;

import edu.esprit.projet_sante.entities.ListMedecin;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;


/**
 * FXML Controller class
 *
 * @author Youssef
 */
public class ComposantMedController implements Initializable {

    @FXML
    private Label idNomMedecin;
    @FXML
    private Label idSpecialite;
    @FXML
    private Label ldCabine;
    @FXML
    private Label ldBio;
    @FXML
    private Button plusDetails;
    ListMedecin r;
     

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            
    }    

    
    public void setData(ListMedecin ListMedecin){
        idNomMedecin.setText(ListMedecin.getNom());
         idSpecialite.setText(ListMedecin.getSpecialite());
         ldCabine.setText(ListMedecin.getAdresse());
         ldBio.setText(ListMedecin.getBio());
          r = new ListMedecin(ListMedecin.getId_user(),ListMedecin.getNom(),ListMedecin.getSpecialite(),ListMedecin.getAdresse(),ListMedecin.getBio()); 
        
    }

    @FXML
    private void plusDetails(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ReserverRDV.fxml"));
            Parent root=loader.load();
            ReserverRDVController dc = loader.getController();
            dc.setNomDoc(r.getNom());
            dc.setSpecialiteDoc(r.getSpecialite());
            dc.setAdresseDoc(r.getAdresse());
            dc.setBioDoc(r.getBio());
            dc.setM(r);
            
            
            idNomMedecin.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ComposantMedController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
