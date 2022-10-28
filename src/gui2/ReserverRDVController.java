/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui2;

import edu.esprit.projet_sante.entities.CategorieRDV;
import edu.esprit.projet_sante.entities.ListMedecin;
import edu.esprit.projet_sante.entities.Rendez_vous;
//import edu.esprit.projet_sante.services.classes.ServiceCategorieRDV;
//import edu.esprit.projet_sante.services.classes.ServiceRDV;
//import edu.esprit.projet_sante.services.classes.ServiseListMed;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import singleton.Service.ServiceRDV;

/**
 * FXML Controller class
 *
 * @author Youssef
 */
public class ReserverRDVController implements Initializable {

    //@FXML
    //private AnchorPane scene2;
        public ListMedecin m ;

    @FXML
    private Label label2;
    @FXML
    private TableView<Rendez_vous> ListeRDV;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private DatePicker idDate;
    @FXML
    private TextField idHeure;
    @FXML
    private AnchorPane scene2;
    @FXML
    private TableColumn<Rendez_vous, Date> idc7;
    @FXML
    private TableColumn<Rendez_vous, String> idc8;
    
    @FXML
    private Button btnAcceuil;
    @FXML
    private Label nomDoc;
    @FXML
    private Label specialiteDoc;
    @FXML
    private Label adresseDoc;
    @FXML
    private TextArea bioDoc;
    
    private ListMedecin r;
    private Rendez_vous rv;
    
    

    
    /**
     * Initializes the controller class.
     */
    //@Override;
    public void initialize(URL url, ResourceBundle rb) {
        
        
        }    
    
    
    /*public void Controle_Saisie(String hr,Date dt) throws SQLException{
        
        if(hr.equals("")||dt.equals(""))
        {
            JOptionPane.showConfirmDialog(null, 
                "Les champs ne doit pas etre vide ", "Echec", JOptionPane.DEFAULT_OPTION);
        }
        else{
            if(hr.length()<3){
                JOptionPane.showConfirmDialog(null, 
                "L'article doit depasser 3 caractères", "Echec", JOptionPane.DEFAULT_OPTION);
            }
            else{
                try 
		{ 
			 Integer.parseInt(hr); 
			 JOptionPane.showConfirmDialog(null, 
                "l'heure ne doit pas etre de type numérique", "Echec", JOptionPane.DEFAULT_OPTION);
                         
                          
		}  
		catch (NumberFormatException e)  
		{ 
	        Rendez_vous r = new  Rendez_vous(1,2,dt,hr);
                ServiceRDV serv = new ServiceRDV();
            serv.ajouter(r);     
                System.out.println("Rendez-vous ajouté");
        
                JOptionPane.showConfirmDialog(null, 
                "Rendez-vous ajouté", "Succé", JOptionPane.DEFAULT_OPTION);
		} 
             }*/
    Integer x;
    public void setM(ListMedecin m) {
                this.m = m;
                x=m.getId_user();
                System.out.println(m.getId_user());
                loadtable();
                
                idc7.setCellValueFactory(new PropertyValueFactory<Rendez_vous, Date>("date_RV"));
                idc8.setCellValueFactory(new PropertyValueFactory<Rendez_vous, String>("heure_RV"));
            
    }
    
    private void loadtable(){
    try{
            ServiceRDV  serv= new ServiceRDV();
            List<Rendez_vous> arr = serv.afficher3(m.getId_user());
        ObservableList<Rendez_vous> list = FXCollections.observableArrayList(arr);
        this.ListeRDV.setItems(list);
                
    
    }
    catch(Exception e){System.out.print("error load");}
    
    }

    

    

    @FXML
    private void ajouterRDV(ActionEvent event) {
        String heure= idHeure.getText();
            java.sql.Date gettedDatePickerDate = java.sql.Date.valueOf(idDate.getValue());
    
        if(heure.equals("")||gettedDatePickerDate.equals(""))
        {
            JOptionPane.showConfirmDialog(null, 
                "Les champs ne doit pas etre vide ", "Echec", JOptionPane.DEFAULT_OPTION);
        }
        else{
            if(heure.length()>3){
                JOptionPane.showConfirmDialog(null, 
                "L'heure ne depasser pas 3 caractères", "Echec", JOptionPane.DEFAULT_OPTION);
            }
            else{
                
                try {
                    System.out.println(m.getId_user());
                    Rendez_vous r = new  Rendez_vous(1,m.getId_user(),gettedDatePickerDate,heure);
                    ServiceRDV serv = new ServiceRDV();
                    serv.ajouter(r);
                    System.out.println("Rendez-vous ajouté");
                    
                    JOptionPane.showConfirmDialog(null,
                            "Rendez-vous ajouté", "Succé", JOptionPane.DEFAULT_OPTION);
                                        loadtable();

       SendMailJava e=new SendMailJava();
        e.sendMail("youssef.rezgui@esprit.tn","Rendez-vous","Rendez-vous effectuer avec succée");
        SmsApi s=new SmsApi();
        s.sendSms("rezguiy67", "muXbQ_sCmb5!DV8", "+21626267723", "Rendez-vous effectuer avec succée");
                } catch (SQLException ex) {
                    Logger.getLogger(ReserverRDVController.class.getName()).log(Level.SEVERE, null, ex);
                }
		} 
}
        
        
        
        
        
          
        
    
    }

    @FXML
    private void modifierRDV(ActionEvent event) {
        
        
        int myIndex = ListeRDV.getSelectionModel().getSelectedIndex();
        int id = Integer.parseInt(String.valueOf(ListeRDV.getItems().get(myIndex).getId_RV()));
          
            String heure= idHeure.getText();
            java.sql.Date gettedDatePickerDate = java.sql.Date.valueOf(idDate.getValue());
if(heure.equals("")||gettedDatePickerDate.equals(""))
        {
            JOptionPane.showConfirmDialog(null, 
                "Les champs ne doit pas etre vide ", "Echec", JOptionPane.DEFAULT_OPTION);
        }
        else{
            if(heure.length()>3){
                JOptionPane.showConfirmDialog(null, 
                "L'heure ne depasser pas 3 caractères", "Echec", JOptionPane.DEFAULT_OPTION);
            }
            else{
        try
        {
        Rendez_vous r = new Rendez_vous(id,1,7,gettedDatePickerDate, heure);
        ServiceRDV serv = new ServiceRDV();
        serv.modifiers(r);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("modification d'un rendez vous");
 
alert.setHeaderText("modification d'un rendez vous");
alert.setContentText("Updated!");
 
alert.showAndWait();
            loadtable();
        }
        catch (SQLException ex)
        {
System.out.print("error load");
        }
        }
        
    }
    }

    @FXML
    private void supprimerRDV(ActionEvent event) {
         int myIndex = ListeRDV.getSelectionModel().getSelectedIndex();
        int id = Integer.parseInt(String.valueOf(ListeRDV.getItems().get(myIndex).getId_RV()));
        Date udate = new Date();

                    
 
        try
        {
            Rendez_vous r = new Rendez_vous(id,1,7,udate, "6h");
            ServiceRDV serv = new ServiceRDV();
            serv.supprimer(r);
            
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Suppression d'un rendez-vous");
 
            alert.setHeaderText("Suppression d'un rendez-vous");
            alert.setContentText("Deleted!");
 
            alert.showAndWait();
            loadtable();
        }
        catch (SQLException ex){System.out.print("error load");}
        }

    @FXML
    private void retourAcceuil(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RDV.fxml"));
            
            Parent root = loader.load();
            
            Scene scene =new  Scene(root);
            Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();
                     
            stage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(RDVController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setNomDoc(String mesaage) {
        this.nomDoc.setText(mesaage);
    }

    public void setSpecialiteDoc(String message) {
        this.specialiteDoc.setText(message);
    }

    public void setAdresseDoc(String message) {
        this.adresseDoc.setText(message);
    }

    public void setBioDoc(String message) {
        this.bioDoc.setText(message);
    }

    public ListMedecin getM() {
        return m;
    }


    

    

    
    
    
}
