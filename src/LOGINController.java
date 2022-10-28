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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


/**
 * FXML Controller class
 *
 * @author ACHRAF
 */
public class LOGINController implements Initializable {
    
    private java.sql.Connection con;
  private Statement ste;
  
  MyDB db = MyDB.getInstance();
   // Connection con;
    public  PreparedStatement st;
    public ResultSet result;
  
  
  
  
    private TextField UserName;
 

    @FXML
    private Button bntConnect;
    @FXML
    private Button btnCreateAccount;
    
    @FXML
    private Label btn_sendPassword;

    @FXML
    private TextField txt_Password;

    @FXML
    private TextField txt_UserName;
 
     /*  @FXML
    private JFXButton LogIninbtnmv;

    @FXML
    private JFXButton Signinbtnmv;

    @FXML
    private Button bntConnect;

    @FXML
    private Button btnCreateAccount;

    @FXML
    private Label btn_sendPassword;

    @FXML
    private TextField txt_Password;

    @FXML
    private TextField txt_UserName;
    
    */
    
    
    
    
    
    
    
    
    
    private TableView<?> TABLEUSER;
    private TableColumn<?, ?> col_id;
    private TableColumn<?, ?> col_nom;
    private TableColumn<?, ?> col_prenom;
    private TableColumn<?, ?> col_username;
    private TableColumn<?, ?> col_mail;
    private TableColumn<?, ?> col_password;
    private TableColumn<?, ?> col_telephone;
    private TableColumn<?, ?> col_role;
    private TableColumn<?, ?> col_adresse;
    private Button addbntgestuser;
    private Button deletebtngestuser;
    @FXML
    private Button LogIninbtnmv;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        con = MyDB.getInstance().getConnection();
    }    
//private VBox VBox;
private Parent fxml;
    @FXML
    
    


   /* @FXML
    //void Connect(ActionEvent event) {

    

    @FXML
    void CreateAcount(ActionEvent event) {
   
    }

    @FXML
    void openLogIn(ActionEvent event) {

    }

    @FXML
    void openSignIn(ActionEvent event) {

    }

    @FXML
    void sendPassword(MouseEvent event) {

    }*/
    
    private void Connect() {
    

                        String UserName = txt_UserName.getText();
                        String Password = txt_Password.getText();
                        String req ="select username, password from utilisateur";
                        try {
                                st=con.prepareStatement(req);
                                result=st.executeQuery();
                            // if(result.next()){
                                if (UserName.equals("achraf")&&Password.equals("admin"))
                                 { 
                               // VBox.getScene().getWindow().hide();
                                Stage ADMIN =new Stage();
                                System.out.println("YOUR PASSWORD IS CORRECT");
                            try {
                                fxml=FXMLLoader.load(getClass().getResource("ADMIN.fxml"));
                                Scene scene =new Scene(fxml);
                                ADMIN.setScene(scene);
                                ADMIN.show();
                          
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        //else if
                        //      {
                        
                        // }
                        else
                        {
                            
                            System.out.println("ERROR! YOUR PASSWORD IS INCORRECT  !!!!! ");
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Wrong Password");
                            alert.setHeaderText(null);
                            alert.setContentText("ERROR!   YOUR PASSWORD IS INCORRECT  !!!!!");
                            alert.showAndWait();

                            
                            
                        }
                   //     }   
                    } catch (SQLException ex) {
            Logger.getLogger(LOGINController.class.getName()).log(Level.SEVERE, null, ex);
        }
                            
    }  
    @FXML
     private void CreateAcount(ActionEvent event) {
        
        try {
            
            
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SIGNIN2.fxml"));
            
            Parent root = loader.load();
            
            Scene scene =new  Scene(root);
             Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();
                     
            stage.setScene(scene);
            //stage.setScene(scene);
            //Stage.show();
                       //sic.setLastName(LastName);
        } catch (IOException ex) {
            Logger.getLogger(LOGINController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        
    

    @FXML
     private void sendPassword(MouseEvent event) {
    }

    @FXML
    private void openLogIn(ActionEvent event) {
    }

        
    

}