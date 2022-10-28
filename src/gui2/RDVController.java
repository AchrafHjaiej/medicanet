/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui2;

import java.sql.Connection;
import edu.esprit.projet_sante.entities.ListMedecin;
import edu.esprit.projet_sante.entities.Rendez_vous;
//import edu.esprit.projet_sante.services.classes.ServiseListMed;
//import singleton_utils.MyDB;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Collection;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.geometry.Insets;
import java.io.IOException;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import singleton.Service.ServiseListMed;





/**
 * FXML Controller class
 *
 * @author Youssef
 */
public class RDVController implements Initializable {

   
    private GridPane ArContainer;
    @FXML
    private AnchorPane scene1;
    @FXML
    private ImageView idImg;
    @FXML
    private Label label1;
    @FXML
    private GridPane cardGrid;
    

    /*@FXML
    private Label label1;
    @FXML
    private ImageView idImg;
    @FXML
    private TableView<ListMedecin> ListeMedecin;
    @FXML
    private Button button444;
    @FXML
    private AnchorPane scene1;
    @FXML
    private TableColumn<ListMedecin, String> idc1;
    @FXML
    private TableColumn<ListMedecin, String> idc2;
    @FXML
    private TableColumn<ListMedecin, Integer> idc3;
    @FXML
    private TableColumn<ListMedecin, String> idc4;
    @FXML
    private TableColumn<ListMedecin, String> idc5;
    @FXML
    private TableColumn<ListMedecin, String> idc6;*/
    //private ObservableList<ListMedecin> data= FXCollections.observableArrayList();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            int columns = 0 ;
            int row = 1 ;
            
            ServiseListMed serv = new ServiseListMed();

        try {
            
          
            List<ListMedecin> list =serv.afficher();
            for(int i=0;i<list.size();i++){
                
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("ComposantMed.fxml"));
                
                VBox box =fxmlloader.load();
                
                ComposantMedController ComposantMedController = fxmlloader.getController();
                ComposantMedController.setData(list.get(i));
                
                
                if(columns == 2){
                    columns = 0;
                    ++row;
                }
                
                cardGrid.add(box,columns++, row);
                GridPane.setMargin(box,new Insets(10));
            }
            
            /*loadtable();
            idc1.setCellValueFactory(new PropertyValueFactory<ListMedecin, String>("nom"));
            idc2.setCellValueFactory(new PropertyValueFactory<ListMedecin, String>("prenom"));
            idc3.setCellValueFactory(new PropertyValueFactory<ListMedecin, Integer>("telephone"));
            idc4.setCellValueFactory(new PropertyValueFactory<ListMedecin, String>("specialite"));
            idc5.setCellValueFactory(new PropertyValueFactory<ListMedecin, String>("adresse"));
            idc6.setCellValueFactory(new PropertyValueFactory<ListMedecin, String>("disponabilite"));*/
        } catch ( Exception ex) {
            Logger.getLogger(RDVController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
          }
   
     


    
}
/////////////////////////////////////////////////////////////////////////////////////
