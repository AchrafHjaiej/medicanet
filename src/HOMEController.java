/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

/**
 * FXML Controller class
 *
 * @author ACHRAF
 */
public class HOMEController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void bntLOGOUTCLICKED(ActionEvent event) {
                                                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                        //Alert alert = new Alert(AlertType.CONFIRMATION);
                                        alert.setTitle("CONFIRMATION");
                                        alert.setHeaderText("Press OK if you want to Log Out !");
                                        alert.setContentText("Are You Sure ?");
                                        Optional<ButtonType> result = alert.showAndWait();
                                        if (result.get() == ButtonType.OK){     
                                                           try {  
                                                                FXMLLoader loader = new FXMLLoader(getClass().getResource("LOGIN2.fxml"));
                                                                Parent root = loader.load();
                                                                Scene scene =new  Scene(root);
                                                                 Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();
                                                                stage.setScene(scene);    
                                                           } catch (IOException ex) {
                                                               Logger.getLogger(LOGINController.class.getName()).log(Level.SEVERE, null, ex);
                                                           }  
                                        } else {
                                                            try {
                                                                 FXMLLoader loader = new FXMLLoader(getClass().getResource("HOME.fxml"));
                                                                 Parent root = loader.load();
                                                                 Scene scene =new  Scene(root);
                                                                  Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();
                                                                 stage.setScene(scene);    
                                                            } catch (IOException ex) {
                                                                Logger.getLogger(LOGINController.class.getName()).log(Level.SEVERE, null, ex);
                                                            }
                                                }     
        
    }
    
    
    
    public static void main(String[] args) throws Exception
{

 

} 
    
    
}
