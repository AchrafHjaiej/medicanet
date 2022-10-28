import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import singleton.Service.ServiceUtilisateur;
import singleton.entities.Utilisateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.sun.jdi.connect.spi.Connection;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import java.sql.PreparedStatement;
import java.util.Optional;
import java.util.regex.Pattern;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
//import javafx.scene.image.Image;


/**
 * FXML Controller class
 *
 * @author ACHRAF
 * 
 * 
 * 
 * 
 * 
 * 
 */











public class ADMINController implements Initializable {
    
    
    
  
    

        MyDB db = MyDB.getInstance();
    Connection con;
    public  PreparedStatement st;
    public ResultSet result;
        @FXML
    private TableView<Utilisateur> TABLEUSER;


    @FXML
    private TableColumn<Utilisateur,String> col_id;
    @FXML
    private TableColumn<Utilisateur,String> col_nom;
    @FXML
    private TableColumn<Utilisateur,String> col_prenom;
    @FXML
    private TableColumn<Utilisateur,String> col_username;
    @FXML
    private TableColumn<Utilisateur,String> col_mail;
    @FXML
    private TableColumn<Utilisateur,String> col_password;
    @FXML
    private TableColumn<Utilisateur,Integer> col_telephone;
    @FXML
    private TableColumn<Utilisateur,String> col_role;
    @FXML
    private TableColumn<Utilisateur,String> col_adresse;
    @FXML
    private TableColumn<Utilisateur,Integer> col_age;
    @FXML
    private TableColumn<Utilisateur,String> col_specialite;
    @FXML
    private TableColumn<Utilisateur,String> col_sexe;
    @FXML
    private TableColumn<Utilisateur,String> col_bio;
    
    @FXML
    private ComboBox<String> comboROLEbox;
    @FXML
    private ComboBox<String> combosexebox;
    @FXML
    private ComboBox<String> combospecialitebox;

    @FXML
    private TextField txt_adresse;
    @FXML
    private TextField txt_mail;
    @FXML
    private TextField txt_nom;
    @FXML
    private PasswordField txt_password;
    @FXML
    private TextField txt_prenom;
    @FXML
    private TextField txt_search_ID;
    @FXML
    private TextField txt_telephone;
    @FXML
    private TextField txt_username;
    @FXML
    private Button addbntgestuser;   
    @FXML
    private Button updatebtngestuser;  
    @FXML
    private Button deletebtngestuser;
    @FXML
    private TextField txt_age;
    @FXML
    private TextField txt_bio;
  
    
    private final ObservableList<Utilisateur> dataList = FXCollections.observableArrayList();
    @FXML
    private Button btnrefresh;
    @FXML
    private TextField TXT_ID;
    @FXML
    private Button LOADDDDDD;
    String d;
    @FXML
    private Button ADMINRECCCC;
    @FXML
    private ImageView imgRecherche;
    @FXML
    private Button Compte;
    @FXML
    private Button RDV;
    @FXML
    private Button ART;
    @FXML
    private Button LOG;
    @FXML
    private Button ACC;
    @FXML
    private ImageView qrimg;
    @FXML
    private Button Statistic;
        @FXML
          
            
    


     
            
            
            
            
    void getAddView(MouseEvent event) throws SQLException {
        
        
                
                
                
                try {
                    String LastName = this.txt_nom.getText();
                    String FirstName = this.txt_prenom.getText();
                    String UserName = this.txt_username.getText();
                    String Mail = this.txt_mail.getText();
                    
                  
                    String Password = this.txt_password.getText();
                    int Telephone = Integer.parseInt(this.txt_telephone.getText());
                    String Role =comboROLEbox.getValue();
                    String Adresse = this.txt_adresse.getText();
                    int Age =Integer.parseInt(this.txt_age.getText());
                    String Specialite = this.combospecialitebox.getValue();
                    String Sexe = this.combosexebox.getValue();
                    String Bio = this.txt_bio.getText();
                    
                    
                    Utilisateur t1 =new Utilisateur(FirstName,LastName,UserName,Mail,Password,Telephone,Role,Adresse,Age,Specialite,Sexe,Bio);
                    ServiceUtilisateur servi =new ServiceUtilisateur();
                    servi.ajouter(t1);
                     refresh_table();
               
                
                  if (isValid(Mail)) {
                           Alert alert = new Alert(AlertType.CONFIRMATION);
                                        //Alert alert = new Alert(AlertType.CONFIRMATION);
                                        alert.setTitle("Your Mail Is Valid");
                                        alert.setHeaderText("Press OK  !");
                                        alert.setContentText("OK");
                                        FXMLLoader loader = new FXMLLoader(getClass().getResource("SIGNIN2.fxml"));
                
                Parent root = loader.load();
                SIGNIN2Controller sic =loader.getController();
                //sic.setLastName(LastName);
                        
                    }
                    else{
                     Alert alert = new Alert(AlertType.ERROR);
                                        //Alert alert = new Alert(AlertType.CONFIRMATION);
                                        alert.setTitle("Your Mail Is not Valid");
                                        alert.setHeaderText("Press OK  !");
                                        alert.setContentText("OK");
                    
                    
                    }
                
                /////
                
            } 
            catch (IOException ex) {
                Logger.getLogger(SIGNIN2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Votre utilisateur est Ajoutée avec succès !!");
    
        

    }

    private boolean isValid(String email) {
        String M_mailm = "[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9._]+([.][a-zA-Z0-9]+)+";
        Pattern pat = Pattern.compile(M_mailm);
        if (txt_mail == null) {
            return false;
        }
        return pat.matcher(email).matches();
    }
    
    
    @FXML
    void getDeleteView(MouseEvent event) {
    var a =this.TABLEUSER.getSelectionModel().getSelectedItem();
    try {ServiceUtilisateur servii =new ServiceUtilisateur();
    servii.delete(a);
    refresh_table();
    }
    catch(Exception e){}
    }

    @FXML
    void getUpdateView(MouseEvent event) {
        
          Utilisateur a = new Utilisateur(Integer.parseInt(TXT_ID.getText()), txt_nom.getText(), txt_prenom.getText(), txt_username.getText(), txt_mail.getText(), txt_password.getText(), Integer.parseInt(txt_telephone.getText()),comboROLEbox.getValue(), txt_adresse.getText(), Integer.parseInt(txt_age.getText()), combospecialitebox.getValue(), combosexebox.getValue(), txt_bio.getText());
        try {
            ServiceUtilisateur servic =new ServiceUtilisateur();
            servic.update(a);
            refresh_table();
            
        } catch (Exception e) {
        }
    }

   void  refresh_table () {
   
             try {
              ServiceUtilisateur servii =new ServiceUtilisateur();
          ObservableList<Utilisateur> list = FXCollections.observableArrayList(servii.readAll());   
          this.TABLEUSER.getItems().clear();
          this.TABLEUSER.getItems().addAll(list);
          
          
        } catch (Exception e) {
        }
        // TODO
    }    

   
   
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         comboROLEbox.setItems(FXCollections.observableArrayList("PATIENT","MEDECIN"));
         combospecialitebox.setItems(FXCollections.observableArrayList("Addictologi","Allergologie","Anatomie et cytopathologie","Anesthésie-réanimation","Biologie médicale","Dermatologie et vénérologie","Endocrinologie-diabétologie-nutrition","Génétique médicale","Gériatrie","Gynécologie médicale","Hématologie","Hépato-gastro-entérologie","Médecine cardiovasculaire","Médecine d’urgence","Médecine du sport","Médecine du travail","Médecine générale","Maladies infectieuses et tropicales","Médecine intensive-réanimation","Médecine interne","Médecine légale et expertises médicales","Médecine nucléaire","Médecine physique et de réadaptation","Médecine vasculaire","Néphrologie","Neurologie","Oncologie","Pédiatrie","Pneumologie"," Psychiatrie","Radiologie et imagerie médicale","Rhumatologie","Santé publique"));
         combosexebox.setItems(FXCollections.observableArrayList("HOMME","FEMME"));
        
        col_id.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("id_user"));
        col_nom.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("nom"));
        col_prenom.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("prenom"));
        col_username.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("username"));
        col_mail.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("mail"));
        col_password.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("password"));
        col_telephone.setCellValueFactory(new PropertyValueFactory<Utilisateur, Integer>("telephone"));
        col_role.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("role"));
        col_adresse.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("adresse"));
        col_age.setCellValueFactory(new PropertyValueFactory<Utilisateur, Integer>("age"));
        col_specialite.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("specialite"));
        col_sexe.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("sexe"));
        col_bio.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("bio"));  
        combospecialitebox.setDisable(true);
         
   refresh_table();
        // TODO
    }    
    @FXML
    private void getrefreshview(ActionEvent event) {
            try {
              ServiceUtilisateur servii =new ServiceUtilisateur();
          ObservableList<Utilisateur> list = FXCollections.observableArrayList(servii.readAll());   
          this.TABLEUSER.getItems().clear();
          this.TABLEUSER.getItems().addAll(list);                  
        } catch (Exception e) {
        }
    }

    @FXML
    private void btnLOGOUTClicked(ActionEvent event) {
        
        
                                        Alert alert = new Alert(AlertType.CONFIRMATION);
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
                                                                 FXMLLoader loader = new FXMLLoader(getClass().getResource("ADMIN.fxml"));
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
    private void comboboxROLE(ActionEvent event) {
            String a=  comboROLEbox.getSelectionModel().getSelectedItem().toString() ;
        System.out.println(a);
         if(a=="MEDECIN"){
                     //combospecialite.show();
                     combospecialitebox.setDisable(false);
         }else{
             combospecialitebox.setDisable(true);
         }   
        
        
    }

    @FXML
    private void getSEARCHviewBykeyPressed(KeyEvent event) throws SQLException  {
         ServiceUtilisateur serviiceee =new ServiceUtilisateur();

          ObservableList<Utilisateur> list = FXCollections.observableArrayList(serviiceee.readAll());   
        
      FilteredList<Utilisateur> filteredData = new FilteredList<>(list, b -> true);
        // 2. Set the filter Predicate whenever the filter changes.
		txt_search_ID.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(Utilisateur -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					
                                        System.out.println("biennnnnnnnnnn");
                                        return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (Utilisateur.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (Utilisateur.getPrenom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                                else if (Utilisateur.getUsername().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                                else if (Utilisateur.getRole().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                                else if (Utilisateur.getSpecialite().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                                else if (Utilisateur.getSexe().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                                else if (Utilisateur.getBio().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                                else if (String.valueOf(Utilisateur.getTelephone()).indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}                                                               
				else if (String.valueOf(Utilisateur.getAge()).indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Utilisateur> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(TABLEUSER.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		TABLEUSER.setItems(sortedData);    
    }

    @FXML
    private void GET_REFRESH(MouseEvent event) {
          try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ADMIN.fxml"));
                Parent root = loader.load();
                Scene scene =new  Scene(root);
                Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                refresh_table();
            } catch (IOException ex) {
                Logger.getLogger(ADMINController.class.getName()).log(Level.SEVERE, null, ex);
            }      
        try {
                refresh_table();
              ServiceUtilisateur servii =new ServiceUtilisateur();
          ObservableList<Utilisateur> list = FXCollections.observableArrayList(servii.readAll());   
          this.TABLEUSER.getItems().clear();
          this.TABLEUSER.getItems().addAll(list);                  
        } catch (Exception e) {
        }
    }

    @FXML
    private void LOAD(MouseEvent event) {
        
                Utilisateur p =TABLEUSER.getItems().get(TABLEUSER.getSelectionModel().getSelectedIndex());
                TXT_ID.setText(""+p.getId_user());
                txt_nom.setText(p.getNom());
                txt_prenom.setText(p.getPrenom());
                txt_username.setText(p.getUsername());
                txt_mail.setText(p.getMail());
                txt_password.setText(p.getPassword());
                txt_telephone.setText(""+p.getTelephone());
                comboROLEbox.setValue(p.getRole());
                txt_adresse.setText(p.getAdresse());
                txt_age.setText(""+p.getAge());
                combospecialitebox.setValue(p.getSpecialite());
                combosexebox.setValue(p.getSexe());
                txt_bio.setText(p.getBio());
                
                
                    ObservableList<Utilisateur> list = FXCollections.observableArrayList();        
                 TABLEUSER.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
  // if (newValue != null) {
                try {
                    
                 d=null;
               d  = (newValue.getNom() + " | " +     newValue.getPrenom()+ " | " + newValue.getAdresse()+    " | "+  newValue.getSpecialite());
                    
                    FileOutputStream fos = null;
                   //String details = txt_nom.getText()+txt_adresse.getText();
                    ByteArrayOutputStream out = QRCode.from(d).to(ImageType.PNG ).stream() ;
                    String aa="C:\\Users\\ACHRAF\\Documents\\NetBeansProjects\\singleton_JDBC\\src\\QRcode\\Mychannel.png";
                    File f = new File("C:\\Users\\ACHRAF\\Documents\\NetBeansProjects\\singleton_JDBC\\src\\QRcode\\Mychannel.png") ;
                    fos = new FileOutputStream(f,false);
                        fos.write (out.toByteArray()) ;
                         fos.flush();                   
                         fos.close();                   
                         refresh_table();
//                       list.clear();
                         System.out.println(newValue.getNom() + " | " +     newValue.getPrenom()+ " | " + newValue.getAdresse()+    " | "+  newValue.getSpecialite());
                       qrimg.setImage(new javafx.scene.image.Image(aa));
                        } catch (FileNotFoundException ex) {
               Logger.getLogger(ADMINController.class.getName()).log(Level.SEVERE, null, ex);
           } catch (IOException ex) {
               Logger.getLogger(ADMINController.class.getName()).log(Level.SEVERE, null, ex);
           }
     //}
});             
    
                
                
                
    }

    @FXML
    private void RECADMIN(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("\\GUI\\Admin.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
           
        } catch (IOException ex) {
            Logger.getLogger(LOGIN2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Compte(ActionEvent event) {
    }

    @FXML
    private void RDV(ActionEvent event) {
    }

    @FXML
    private void getARCView(ActionEvent event) {
    }

    @FXML
    private void ACC(ActionEvent event) {
    }
    

    @FXML
    private void Statistic(ActionEvent event) throws IOException { 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Stat.fxml"));
                                                                Parent root = loader.load();
                                                                Scene scene =new  Scene(root);
                                                                 Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();
                                                                stage.setScene(scene);  
        
    }

   
}