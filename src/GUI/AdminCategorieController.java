/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import singleton.Service.ServiceCategorie;
import singleton.Service.ServiceReclamation;
import singleton.entities.AfficheAdmin;
import singleton.entities.Categorie;
import singleton.entities.recCat;
import singleton.utils.MyDB;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AdminCategorieController implements Initializable {

    @FXML
    private Button Compte;
    @FXML
    private Button RDV;
    @FXML
    private TextField type_categ;
    @FXML
    private Button ajoutType;
    @FXML
    private Button modifierType;
    @FXML
    private TableColumn<Categorie, String> typeR;
    @FXML
    private TableView<Categorie> tabel1;
    @FXML
    private Button recuperType;
    @FXML
    private Button supprimerType1;
    @FXML
    private Button ADMINRECCCC;
    @FXML
    private Button ART;
    @FXML
    private Button LOG;
    @FXML
    private Button ACC;
    @FXML
    private Button backOf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         ObservableList<Categorie> list = FXCollections.observableArrayList();

    try {
         ServiceCategorie sc =new ServiceCategorie();   
         list.addAll(sc.readAll() );
         System.out.println(list);
         System.out.println("affiche successeful");
        
          typeR.setCellValueFactory(new PropertyValueFactory<Categorie,String>("type_reclamation"));
         
          tabel1.setItems((ObservableList<Categorie>) list);
          System.out.println(tabel1.getItems());

     } catch (SQLException ex) {
     }

          
    }    
    
    @FXML
    private void Compte(ActionEvent event) {
    }

    @FXML
    private void RDV(ActionEvent event) {
    }


    @FXML
    private void ajoutType(ActionEvent event) throws SQLException {
        
        
    ServiceCategorie sr=new ServiceCategorie();
    String t =  type_categ.getText();
  
  
     Categorie c=new Categorie(t);
      sr.ajouter2(c);
      
   
    
     initialize(null,null);
      type_categ.setText(" ");
             

    }
    
    @FXML
    private void supprimerType(ActionEvent event) {
         List<Categorie> rec = tabel1.getSelectionModel().getSelectedItems();
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
        
            
               int selectedID = tabel1.getSelectionModel().getSelectedIndex();
              tabel1.getItems().remove(selectedID);       
                   
               
                tabel1.refresh();
                
            }
    
    
    
    }
    
    @FXML
    private void modifierType(ActionEvent event) throws SQLException {
        
        ServiceCategorie sc = new ServiceCategorie();
        Categorie Clikedrec = tabel1.getSelectionModel().getSelectedItem();
      
          
      if(!(type_categ.getText().isEmpty())){
               {
    
       
        
        Categorie c =new Categorie (Clikedrec.getId_categorie(), type_categ.getText());
        System.out.println(c.getType_reclamation());
        
        sc.update(c);
       
         initialize(null,null);
         
        type_categ.setText(" ");
               }      
}
   
        
    }
        
    
    /////////////////////////////
     public void supprimerReclamation(Categorie C) {
        Connection con;
        
   
        try {
             con = MyDB.getInstance().getConnection();
   
           
            String req ="DELETE from `Catégorie` where id_categorie = ?";
            PreparedStatement ps = con.prepareStatement(req);
            System.out.println("Suppression...");
            ps.setInt(1, C.getId_categorie());
            ps.executeUpdate();
            System.out.println("Une ligne supprimée dans la table");
        } catch (SQLException e) {

        }

    }

    @FXML
    private void recupererType(ActionEvent event) {
        ServiceCategorie sc = new ServiceCategorie();
        Categorie Clikedrec = tabel1.getSelectionModel().getSelectedItem();
      
          
                
        type_categ.setText(Clikedrec.getType_reclamation());
    
    }

    @FXML
    private void RECADMIN(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin.fxml"));
                                                                Parent root = loader.load();
                                                                Scene scene =new  Scene(root);
                                                                 Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();
                                                                stage.setScene(scene);  
        
    }

    @FXML
    private void getARCView(ActionEvent event) {
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
                                                                 FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminCategorie.fxml"));
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
    private void ACC(ActionEvent event) throws IOException {
        
          FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\ADMIN.fxml"));
                                                                Parent root = loader.load();
                                                                Scene scene =new  Scene(root);
                                                                 Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();
                                                                stage.setScene(scene);  
    }

    @FXML
    private void backOf(ActionEvent event) throws IOException {
        
        
             FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin.fxml"));
                                                                Parent root = loader.load();
                                                                Scene scene =new  Scene(root);
                                                                 Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();
                                                                stage.setScene(scene);  
        
    }

    
    

}
