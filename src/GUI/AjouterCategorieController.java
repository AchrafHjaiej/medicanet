
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import singleton.Service.ServiceCategorie;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AjouterCategorieController implements Initializable {
     
    @FXML
    private Label labelTypeREC;
    @FXML
    private ComboBox<String>TypeRec;
    @FXML
    private Button RDV;
    @FXML
    private Button REC;
    @FXML
    private Button suivant;
    @FXML
    private Button ART;
    @FXML
    private Button ACC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     ServiceCategorie sc=new ServiceCategorie();
        try {
            TypeRec.setItems(FXCollections.observableArrayList(sc.GetTypeCategorie()));
        } catch (SQLException ex) {
            Logger.getLogger(AjouterCategorieController.class.getName()).log(Level.SEVERE, null, ex);
        }
     

   
    }
    static public String T ="";
   
   @FXML
    void AjoutTypeRec(ActionEvent event) throws SQLException {
       
         
    T =  TypeRec.getValue();
   
  
         
    }
        


    @FXML
    private void RDV(ActionEvent event) {
    }

    @FXML
    private void REC(ActionEvent event) {
    }


    @FXML
    private void Suivant(ActionEvent event) throws IOException {
        
    Parent root = FXMLLoader.load(getClass().getResource("AjouterReclamation.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void GetReclamationView(MouseEvent event) {
    }

    @FXML
    private void ART(ActionEvent event) {
    }

    @FXML
    private void ACC(ActionEvent event) {
    }

    @FXML
    private void LOGOUTbntCLICKED(ActionEvent event) {
    }
    
}
