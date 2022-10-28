/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import com.sun.jdi.connect.spi.Connection;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import singleton.Service.ServiceUtilisateur;
import singleton.entities.Utilisateur;
import singleton.utils.MyDB;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author ACHRAF
 */
public class SIGNINController implements Initializable {

    MyDB db = MyDB.getInstance();
    Connection con;
    public  PreparedStatement st;
    public ResultSet result;
    
    

    private TextField txt_Password;

    private TextField txt_UserName;
   

    void Connect() {
                    String UserName = txt_UserName.getText();
                    String Password = txt_Password.getText();
                    if (this.UserName.equals("achrafadmin97")&&Password.equals("adminadmin"))
                     System.out.println("YOUR PASSWORD IS CORRECT"); 
                    else{
                        System.out.println("ERROR!!");
                    }
                    
    }

    void CreateAcount(ActionEvent event) {

    }

    void sendPassword(MouseEvent event) {

    }



    
    

    @FXML
    private TextField LastName;
    @FXML
    private TextField FirstName;
    @FXML
    private TextField UserName;
    @FXML
    private TextField Mail;
    @FXML
    private TextField Password;
    @FXML
    private TextField Telephone;
    @FXML
    private ComboBox<String> comboboxRole;
    @FXML
    private TextField Adresse;
    @FXML
    private TextField AGE;
    @FXML
    private TextField Specialite;
    @FXML
    private TextField Sexe;
    @FXML
    private TextField Bio;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboboxRole.setItems(FXCollections.observableArrayList("PATIENT","MEDECIN"));
    }    

    @FXML
    private void comboboxRoleUpdate(ActionEvent event) {
    }

    @FXML
    private void btnCREATEClicked(ActionEvent event) {
        
         try {
                
                
                
                try {
                    String LastName = this.LastName.getText();
                    String FirstName = this.FirstName.getText();
                    String UserName = this.UserName.getText();
                    String Mail = this.Mail.getText();
                    String Password = this.Password.getText();
                    int Telephone = Integer.parseInt(this.Telephone.getText());
                    String Role =comboboxRole.getValue();
                    String Adresse = this.Adresse.getText();
                    int Age =Integer.parseInt(this.AGE.getText());
                    String Specialite = this.Specialite.getText();
                    String Sexe = this.Sexe.getText();
                    String Bio = this.Bio.getText();
                    Utilisateur t1 =new Utilisateur(FirstName,LastName,UserName,Mail,Password,Telephone,Role,Adresse,Age,Specialite,Sexe,Bio);
                    ServiceUtilisateur servi =new ServiceUtilisateur();
                    servi.ajouter(t1);
                } catch (SQLException ex) {
                    Logger.getLogger(SIGNINController.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Votre utilisateur est Ajoutée avec succès !!");
                
                
                /////
                FXMLLoader loader = new FXMLLoader(getClass().getResource("SIGNIN.fxml"));
                
                Parent root = loader.load();
                SIGNINController sic =loader.getController();
                //sic.setLastName(LastName);
            } catch (IOException ex) {
                Logger.getLogger(SIGNINController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void btnCANCELClicked(ActionEvent event) {
        
        
       try {
           
           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LOGIN.fxml"));
            
            Parent root = loader.load();
            
            Scene scene =new  Scene(root);
             Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();
                     
            stage.setScene(scene);
           
           
       } catch (IOException ex) {
           Logger.getLogger(LOGINController.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        
        
    }
    
}
