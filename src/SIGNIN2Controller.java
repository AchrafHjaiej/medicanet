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
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.TouchEvent;

/**
 * FXML Controller class
 *
 * @author ACHRAF
 */
public class SIGNIN2Controller implements Initializable {
    
        MyDB db = MyDB.getInstance();
    Connection con;
    public  PreparedStatement st;
    public ResultSet result;
    @FXML
    private Button btnCreateAccount;
    @FXML
    private ComboBox<String> combospecialite;
    @FXML
    private ComboBox<String> combosexe;
    
    
   void Connect() {
                    String UserName = txt_UserName.getText();
                    String Password = txt_Password.getText();
                    if (this.UserName.equals("achrafadmin97")&&Password.equals("adminadmin"))
                     System.out.println("YOUR PASSWORD IS CORRECT"); 
                    else{
                        System.out.println("ERROR!!");
                    }
                    
    }

    @FXML
    void CreateAcount(ActionEvent event) {
        
               {
        
        
       try {
           
           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LOGIN2.fxml"));
            
            Parent root = loader.load();
            
            Scene scene =new  Scene(root);
             Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();
                     
            stage.setScene(scene);
           
           
       } catch (IOException ex) {
           Logger.getLogger(LOGINController.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        
        
    }
               

    }

  
    

    private TextField txt_Password;

    private TextField txt_UserName;
   

    @FXML
    private TextField LastName;
    @FXML
    private TextField FirstName;
    @FXML
    private TextField UserName;
    @FXML
    private TextField Mail;
    @FXML
    private PasswordField Password;
    @FXML
    private TextField Telephone;
    @FXML
    private TextField AGE;
    private TextField Specialite;
    private TextField Sexe;
    @FXML
    private ComboBox<String> comboboxRole;
    @FXML
    private TextField Adresse;
    @FXML
    private TextArea Bio;
     String a;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         comboboxRole.setItems(FXCollections.observableArrayList("PATIENT","MEDECIN"));
          combospecialite.setItems(FXCollections.observableArrayList("Addictologi","Allergologie","Anatomie et cytopathologie","Anesthésie-réanimation","Biologie médicale","Dermatologie et vénérologie","Endocrinologie-diabétologie-nutrition","Génétique médicale","Gériatrie","Gynécologie médicale","Hématologie","Hépato-gastro-entérologie","Médecine cardiovasculaire","Médecine d’urgence","Médecine du sport","Médecine du travail","Médecine générale","Maladies infectieuses et tropicales","Médecine intensive-réanimation","Médecine interne","Médecine légale et expertises médicales","Médecine nucléaire","Médecine physique et de réadaptation","Médecine vasculaire","Néphrologie","Neurologie","Oncologie","Pédiatrie","Pneumologie"," Psychiatrie","Radiologie et imagerie médicale","Rhumatologie","Santé publique"));
         combosexe.setItems(FXCollections.observableArrayList("HOMME","FEMME"));
         //comboboxRole.hide();
         combospecialite.setDisable(true);
         
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
                    String Specialite = this.combospecialite.getValue();
                    String Sexe = this.combosexe.getValue();
                    String Bio = this.Bio.getText();
                    Utilisateur t1 =new Utilisateur(FirstName,LastName,UserName,Mail,Password,Telephone,Role,Adresse,Age,Specialite,Sexe,Bio);
                    ServiceUtilisateur servi =new ServiceUtilisateur();             
                    servi.ajouter(t1);
                } catch (SQLException ex) {
                    Logger.getLogger(SIGNIN2Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                /////
                FXMLLoader loader = new FXMLLoader(getClass().getResource("SIGNIN2.fxml"));
                
                Parent root = loader.load();
                SIGNIN2Controller sic =loader.getController();
                //sic.setLastName(LastName);
            } 
            catch (IOException ex) {
                Logger.getLogger(SIGNIN2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Votre utilisateur est Ajoutée avec succès !!");
        
    }

    @FXML
    private void btnCANCELClicked(ActionEvent event) {
        
        {
        
        
       try {
           
           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LOGIN2.fxml"));
            
            Parent root = loader.load();
            
            Scene scene =new  Scene(root);
             Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();
                     
            stage.setScene(scene);
           
           
       } catch (IOException ex) {
           Logger.getLogger(LOGINController.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        
        
    }
    
        
    }

    @FXML
    private void comboboxRoleUpdate(ActionEvent event) {
        String a=  comboboxRole.getSelectionModel().getSelectedItem().toString() ;
        System.out.println(a);
         if(a=="MEDECIN"){
                     //combospecialite.show();
                     combospecialite.setDisable(false);
         }else{
             combospecialite.setDisable(true);
         }   
        
    }

    private void CreateAccount(ActionEvent event) {
         
}

    @FXML
    private void CONINT_NOM(KeyEvent event) {
        if (LastName.getText().isEmpty() ) {
               Alert alert = new Alert(Alert.AlertType.ERROR);
                                        //Alert alert = new Alert(AlertType.CONFIRMATION);
                                        alert.setTitle("CONFIRMATION");
                                        alert.setHeaderText("Press OK if you want to Log Out !");
                                        alert.setContentText("Are You Sure ?");
                                        Optional<ButtonType> result = alert.showAndWait();
            
        }
    }

    private void CONINT_NOM2(KeyEvent event) {
          if (LastName.getText().isEmpty() ) {
               Alert alert = new Alert(Alert.AlertType.ERROR);
                                        //Alert alert = new Alert(AlertType.CONFIRMATION);
                                        alert.setTitle("CONFIRMATION");
                                        alert.setHeaderText("Press OK if you want to Log Out !");
                                        alert.setContentText("Are You Sure ?");
                                        Optional<ButtonType> result = alert.showAndWait();
    }
    }
    @FXML
    private void CONINT_NOM5(DragEvent event) {
          if (LastName.getText().isEmpty() ) {
               Alert alert = new Alert(Alert.AlertType.ERROR);
                                        //Alert alert = new Alert(AlertType.CONFIRMATION);
                                        alert.setTitle("CONFIRMATION");
                                        alert.setHeaderText("YOU MUST ENTER YOUR NAME");
                                        //alert.setContentText("Are You Sure ?");
                                        Optional<ButtonType> result = alert.showAndWait();
    }}

    @FXML
    private void CONINT_NOM3(TouchEvent event) {
          if (LastName.getText().isEmpty() ) {
               Alert alert = new Alert(Alert.AlertType.ERROR);
                                        //Alert alert = new Alert(AlertType.CONFIRMATION);
                                        alert.setTitle("CONFIRMATION");
                                        alert.setHeaderText("Press OK if you want to Log Out !");
                                        alert.setContentText("Are You Sure ?");
                                        Optional<ButtonType> result = alert.showAndWait();}
    }
  

    @FXML
    private void CONINT_NOM4(DragEvent event) {
        
          if (LastName.getText().isEmpty() ) {
               Alert alert = new Alert(Alert.AlertType.ERROR);
                                        //Alert alert = new Alert(AlertType.CONFIRMATION);
                                        alert.setTitle("CONFIRMATION");
                                        alert.setHeaderText("Press OK if you want to Log Out !");
                                        alert.setContentText("Are You Sure ?");
                                        Optional<ButtonType> result = alert.showAndWait();
    }}
}