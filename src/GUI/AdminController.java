/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

//import LOGINController;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import singleton.Service.ServiceReclamation;
import singleton.entities.AfficheAdmin;
import singleton.entities.Reclamation;
import singleton.utils.MyDB;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AdminController implements Initializable {

    @FXML
    private Button Compte;
    @FXML
    private Button RDV;
    @FXML
    private TableView<AfficheAdmin> Table_ViewAdmin;
    @FXML
    private TableColumn<AfficheAdmin, String> Email;
    @FXML
    private TableColumn<AfficheAdmin, String> description;
    @FXML
    private TableColumn<AfficheAdmin, String> objetREC;
    @FXML
    private TableColumn<AfficheAdmin, String> date;
    @FXML
    private Button supprimerRec;
    @FXML
    private Button repondre;
    @FXML
    private TableColumn<AfficheAdmin, String> Username;
    @FXML
    private TableColumn<AfficheAdmin, String> Type_Rec;
 
    private TextField textidRec;
        @FXML
    private TableColumn<AfficheAdmin, String> ETAT;
     Connection con;
    @FXML
    private TextField rech;
    @FXML
    private Button ADMINRECCCC;
    @FXML
    private Button ART;
    @FXML
    private Button LOG;
    @FXML
    private Button ACC;
    @FXML
    private Button Suivant;
    @FXML
    private Button backOf;
    @FXML
    private Button Statistique;
    @FXML
    private ImageView rechercheimg;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<AfficheAdmin> list = FXCollections.observableArrayList();

    try {
         ServiceReclamation es=new ServiceReclamation();
        
         
         list.addAll(es.readAllAd());
    System.out.println(list);
   
    
       
         
        
         System.out.println("affiche successeful");
           description.setCellValueFactory(new PropertyValueFactory<AfficheAdmin, String>("message"));
          objetREC.setCellValueFactory(new PropertyValueFactory<AfficheAdmin, String>("objet_reclamation"));
         date.setCellValueFactory(new PropertyValueFactory<AfficheAdmin, String>("date_reclamation"));
         Type_Rec.setCellValueFactory(new PropertyValueFactory<AfficheAdmin, String>("type_reclamation"));
         Username.setCellValueFactory(new PropertyValueFactory<AfficheAdmin, String>("username"));
         Email.setCellValueFactory(new PropertyValueFactory<AfficheAdmin, String>("mail"));
        ETAT.setCellValueFactory(new PropertyValueFactory<AfficheAdmin, String>("etat_reclamation"));
         
         
         
         
       Table_ViewAdmin.setItems((ObservableList<AfficheAdmin>) list);
         
         //} catch (SQLException ex) {
         
         //}
     } catch (SQLException ex) {
     }

          
    }   

    @FXML
    private void TableViewAdmin(MouseEvent event) {
    }
 public static String Aemail="";
    @FXML
    private void supprimerRec(ActionEvent event) {
        List<AfficheAdmin> rec = Table_ViewAdmin.getSelectionModel().getSelectedItems();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Vous voulez vraiment supprimer cette reclamation ?");
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
           
       
        
         supprimerReclamation(rec.get(0));
            
           Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText(" Réclamation supprimé avec succés!");
            alert.show();
        
          
            
               int selectedID = Table_ViewAdmin.getSelectionModel().getSelectedIndex();
              Table_ViewAdmin.getItems().remove(selectedID);       
                   
               
                Table_ViewAdmin.refresh();
                
            }
    
    

    }

    @FXML
    private void Compte(ActionEvent event) {
    }

    @FXML
    private void RDV(ActionEvent event) {
    }


    @FXML
    private void Repondre(ActionEvent event) throws IOException, SQLException {
         Parent root = FXMLLoader.load(getClass().getResource("EnvoyerEmail.fxml"));
            Scene scene = new Scene(root);
            Stage stage=new Stage();
          
           stage.setScene(scene);
           stage.show();
            /*Parent root = FXMLLoader.load(getClass().getResource("EnvoyerEmail.fxml"));
            Scene scene = new Scene(root);
            Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
           window.setScene(scene);
           window.show();
           */
        
        
       
        int acc =Table_ViewAdmin.getSelectionModel().getSelectedItem().getId_reclamation();
        traitéReclamation2(acc);
        
        Aemail=Table_ViewAdmin.getSelectionModel().getSelectedItem().getMail();
        
            
           
           
    }


/////////////////////////////////////////////////////////
     public void supprimerReclamation(AfficheAdmin R) {
        
        
   
        try {
             con = MyDB.getInstance().getConnection();
   
           
            String req ="DELETE from `reclamation` where id_reclamation = ?";
            PreparedStatement ps = con.prepareStatement(req);
            System.out.println("Suppression...");
            ps.setInt(1, R.getId_reclamation());
            ps.executeUpdate();
            System.out.println("Une ligne supprimée dans la table");
        } catch (SQLException e) {

        }

    }

  public void traitéReclamation2(int R) throws SQLException {
                     con = MyDB.getInstance().getConnection();

       String req = "UPDATE reclamation SET `etat_reclamation`='traité' where `id_reclamation`='"+R+"'";
        System.out.println(req);
PreparedStatement ste = con.prepareStatement(req);        
       ste.executeUpdate(req);
        System.out.println("la reclamation traité");
      
}

    @FXML
    private void Rechercher(ActionEvent event) {
        ObservableList<AfficheAdmin> list = FXCollections.observableArrayList();

    try {
         ServiceReclamation es=new ServiceReclamation();
        
         
         list.addAll(es.readRech(rech.getText()));
    System.out.println(list);
   
    
       
         
        
         System.out.println("affiche successeful");
           description.setCellValueFactory(new PropertyValueFactory<AfficheAdmin, String>("message"));
          objetREC.setCellValueFactory(new PropertyValueFactory<AfficheAdmin, String>("objet_reclamation"));
         date.setCellValueFactory(new PropertyValueFactory<AfficheAdmin, String>("date_reclamation"));
         Type_Rec.setCellValueFactory(new PropertyValueFactory<AfficheAdmin, String>("type_reclamation"));
         Username.setCellValueFactory(new PropertyValueFactory<AfficheAdmin, String>("username"));
         Email.setCellValueFactory(new PropertyValueFactory<AfficheAdmin, String>("mail"));
        ETAT.setCellValueFactory(new PropertyValueFactory<AfficheAdmin, String>("etat_reclamation"));
         
         
         
         
       Table_ViewAdmin.setItems((ObservableList<AfficheAdmin>) list);
         
         //} catch (SQLException ex) {
         
         //}
     } catch (SQLException ex) {
     }
        
    }

    @FXML
    private void RECADMIN(ActionEvent event) {
    }

    @FXML
    private void ART(ActionEvent event) {
    }

    @FXML
    private void btnLOGOUTClicked(ActionEvent event) {
        
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                        //Alert alert = new Alert(AlertType.CONFIRMATION);
                                        alert.setTitle("CONFIRMATION");
                                        alert.setHeaderText("Press OK if you want to Log Out !");
                                        alert.setContentText("Are You Sure ?");
                                        Optional<ButtonType> result = alert.showAndWait();
                                        if (result.get() == ButtonType.OK){     
                                                           try {  
                                                                FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\LOGIN2.fxml"));
                                                                Parent root = loader.load();
                                                                Scene scene =new  Scene(root);
                                                                 Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();
                                                                stage.setScene(scene);    
                                                           } catch (IOException ex) {
                                                               Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                                                           }  
                                        } else {
                                                            try {
                                                                 FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin.fxml"));
                                                                 Parent root = loader.load();
                                                                 Scene scene =new  Scene(root);
                                                                  Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();
                                                                 stage.setScene(scene);    
                                                            } catch (IOException ex) {
                                                                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                                                            }
                                                }        
        
    }

    @FXML
    private void btnACCEUIL(ActionEvent event) throws IOException {
        
                                                                FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\ADMIN.fxml"));
                                                                Parent root = loader.load();
                                                                Scene scene =new  Scene(root);
                                                                 Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();
                                                                stage.setScene(scene);  
    
    }

    @FXML
    private void Suivant(ActionEvent event) throws IOException {
        
             FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminCategorie.fxml"));
                                                                Parent root = loader.load();
                                                                Scene scene =new  Scene(root);
                                                                 Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();
                                                                stage.setScene(scene);  
        
    }

    @FXML
    private void backOf(ActionEvent event) throws IOException {
        
        
             FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\ADMIN.fxml"));
                                                                Parent root = loader.load();
                                                                Scene scene =new  Scene(root);
                                                                 Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();
                                                                stage.setScene(scene);  
        
        
    }

    @FXML
    private void Statistique(ActionEvent event) throws IOException {
        
          FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML.fxml"));
                                                                Parent root = loader.load();
                                                                Scene scene =new  Scene(root);
                                                                 Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();
                                                                stage.setScene(scene);  
    }

    @FXML
    private void re(MouseEvent event) {
    }
}
