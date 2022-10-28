/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui2;

import edu.esprit.projet_sante.entities.ListMedecin;
import edu.esprit.projet_sante.entities.Rendez_vous;
//import edu.esprit.projet_sante.services.classes.ServiceRDV;
//import edu.esprit.projet_sante.services.classes.ServiseListMed;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import singleton.Service.ServiceRDV;

/**
 * FXML Controller class
 *
 * @author Youssef
 */
public class Admin_rdvController implements Initializable {

    @FXML
    private TableView<Rendez_vous> TABLERDV;
    @FXML
    private TableColumn<Rendez_vous, Integer> col_id;
    @FXML
    private TableColumn<Rendez_vous, Date> col_DATE;
    @FXML
    private TableColumn<Rendez_vous, String> col_HEURE;
    @FXML
    private TableColumn<Rendez_vous, Integer> col_ID_MED;
    @FXML
    private TableColumn<Rendez_vous, Integer> col_ID_PATIEN;
    @FXML
    private TableColumn<Rendez_vous, String> col_CATEGORIE;
    @FXML
    private Button deletebtnRDV;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
loadtable();

        col_DATE.setCellValueFactory(new PropertyValueFactory<Rendez_vous, Date>("date_RV"));
        col_HEURE.setCellValueFactory(new PropertyValueFactory<Rendez_vous, String>("heure_RV")); 
        col_id.setCellValueFactory(new PropertyValueFactory<Rendez_vous, Integer>("id_RV"));
        col_ID_MED.setCellValueFactory(new PropertyValueFactory<Rendez_vous, Integer>("id_medecin")); 
        col_ID_PATIEN.setCellValueFactory(new PropertyValueFactory<Rendez_vous, Integer>("id_patient "));
        col_CATEGORIE.setCellValueFactory(new PropertyValueFactory<Rendez_vous, String>("categorie")); 
    }    
    
    private void loadtable(){
    try{
        ServiceRDV es=new ServiceRDV();
        List<Rendez_vous>arr=es.afficher2();
        ObservableList<Rendez_vous> list = FXCollections.observableArrayList(arr);
        this.TABLERDV.setItems(list);
                
    
    }
    catch(Exception e){System.out.print("error load");}
    
    }
    
    

    @FXML
    private void btnLOGOUTClicked(ActionEvent event) {
    }

    @FXML
    private void getDeleteView(MouseEvent event) {
        int myIndex = TABLERDV.getSelectionModel().getSelectedIndex();
        int id = Integer.parseInt(String.valueOf(TABLERDV.getItems().get(myIndex).getId_RV()));
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

    
}
