/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.esprit.projet_sante.gui;

import edu.esprit.projet_sante.entities.CategorieRDV;
import edu.esprit.projet_sante.entities.Rendez_vous;
import edu.esprit.projet_sante.services.classes.ServiceCategorieRDV;
import edu.esprit.projet_sante.services.classes.ServiceRDV;
import java.net.URL;
import java.sql.SQLException;
import static java.util.Collections.list;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Youssef
 */
public class EspaceMedecinController implements Initializable {

    
    
    
    @FXML
    private AnchorPane scene1;
    @FXML
    private Label label1;
    @FXML
    private ImageView idImg;
    @FXML
    private TableView<Rendez_vous> espT1;
    @FXML
    private TableColumn<Rendez_vous, String> espC1;
    @FXML
    private TableColumn<Rendez_vous, Date> espC2;
    @FXML
    private TableView<CategorieRDV> espT2;
    @FXML
    private TableColumn<CategorieRDV, String> espC3;
    @FXML
    private Button buttonUpdate1;
    @FXML
    private Button buttonAnnul1;
    @FXML
    private DatePicker idDate;
    @FXML
    private TextField idHeure;
    @FXML
    private ComboBox<String> idCat;
    @FXML
    private Button buttonAffect11;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadtable();
        loadtable2();
        
        idCat.setItems(FXCollections.observableArrayList("consultation","controle","acte","therapie","operation"));
        String categorie =idCat.getValue();
        
        espC2.setCellValueFactory(new PropertyValueFactory<Rendez_vous, Date>("date_RV"));
        espC1.setCellValueFactory(new PropertyValueFactory<Rendez_vous, String>("heure_RV"));
        espC3.setCellValueFactory(new PropertyValueFactory<CategorieRDV, String>("categorie"));
        
        
        
        
    }    


    private void loadtable(){
    try{
        ServiceRDV es=new ServiceRDV();
        List<Rendez_vous>arr=es.afficher();
        ObservableList<Rendez_vous> list = FXCollections.observableArrayList(arr);
        this.espT1.setItems(list);
                
    
    }
    catch(Exception e){System.out.print("error load");}
    
    }
    
    private void loadtable2(){
    try{
        ServiceCategorieRDV es=new ServiceCategorieRDV();
        List<CategorieRDV>arr=es.afficher();
        ObservableList<CategorieRDV> list = FXCollections.observableArrayList(arr);
        this.espT2.setItems(list);
                
    
    }
    catch(Exception e){System.out.print("error load");}
    
    }
    
    

    @FXML
    private void testUpdate(ActionEvent event) {
        int myIndex = espT1.getSelectionModel().getSelectedIndex();
        int id = Integer.parseInt(String.valueOf(espT1.getItems().get(myIndex).getId_RV()));
          
            String heure= idHeure.getText();
            //String Categorie =idCombo.getValue();
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
    private void testAnnul(ActionEvent event) {
        int myIndex = espT1.getSelectionModel().getSelectedIndex();
        int id = Integer.parseInt(String.valueOf(espT1.getItems().get(myIndex).getId_RV()));
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
    private void testAffect(ActionEvent event) {
        try {
            int myIndex = espT1.getSelectionModel().getSelectedIndex();
            int id = Integer.parseInt(String.valueOf(espT1.getItems().get(myIndex).getId_RV()));
            String cat =idCat.getValue();
            CategorieRDV r = new  CategorieRDV(id,cat);
            ServiceCategorieRDV serv = new ServiceCategorieRDV();
            serv.ajouter(r);
            System.out.println("Categorie ajouté");
            
            JOptionPane.showConfirmDialog(null,
                    "Categorie ajouté", "Succé", JOptionPane.DEFAULT_OPTION);
            loadtable2();
        } catch (SQLException ex) {
            Logger.getLogger(EspaceMedecinController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
