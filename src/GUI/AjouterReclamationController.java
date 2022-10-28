/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.javafx.font.FontFactory;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import static java.util.Collections.list;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.control.Label;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.K;
import static javafx.scene.input.KeyCode.T;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.text.Element;
import singleton.Service.ServiceCategorie;
import singleton.Service.ServiceReclamation;
import singleton.entities.Categorie;
import singleton.entities.Reclamation;
import singleton.entities.recCat;
import singleton.utils.MyDB;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AjouterReclamationController implements Initializable {

    private final ObservableList<Reclamation> dataList = FXCollections.observableArrayList();
    ServiceReclamation rs = new ServiceReclamation();
    @FXML
    private Label descLabel;
    @FXML
    private Label titreREC;
    @FXML
    private AnchorPane interfaceAjoutREC;
    @FXML
    private Label ObjetLabel;
    @FXML
    private TextField TextObjetRec;
    @FXML
    private TextArea TextDescriptionREC;
    @FXML
    private Button AjouterReclamation;
    @FXML
    private TableView<recCat> Table_View;
    @FXML
    private TextField recherche;
    @FXML
    private ImageView imgRecherche;
    @FXML
    private Button supprimerRec;
    @FXML
    private Button modifierRec;
    @FXML
    private Button Compte;
    @FXML
    private Button RDV;
    @FXML
    private Button REC;
    @FXML
    private TextField textIDREC;
    @FXML
    private TableColumn<recCat, String> columnDescriptionRec;
    @FXML
    private TableColumn<recCat, String> columnTypeRec;
    @FXML
    private TableColumn<recCat, String> columnObjetRec;
  
    @FXML
    private Button retour;

    @FXML
    private TableColumn<recCat, String> Date;

    @FXML
    private Button RecupererREC;
    @FXML
    private Button TéléchargerPDF;
    @FXML
    private Button ART;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<recCat> list = FXCollections.observableArrayList();

        try {
            ServiceReclamation es = new ServiceReclamation();

            list.addAll(es.readRec(1));
            System.out.println(list);

            //Categorie c = new Categorie();

            System.out.println("affiche successeful");
            columnDescriptionRec.setCellValueFactory(new PropertyValueFactory<recCat, String>("message"));
            columnObjetRec.setCellValueFactory(new PropertyValueFactory<recCat, String>("objet_reclamation"));
            Date.setCellValueFactory(new PropertyValueFactory<recCat, String>("date_reclamation"));
            columnTypeRec.setCellValueFactory(new PropertyValueFactory<recCat, String>("type_reclamation"));
            Table_View.setItems((ObservableList<recCat>) list);

            //} catch (SQLException ex) {
            //}
        } catch (SQLException ex) {
        }

    }

    @FXML
    private void AjouterReclamation(ActionEvent event) throws SQLException {
        
        
       /* ServiceReclamation sr=new ServiceReclamation();
        String pa = "dd/MM/yyyy";
            DateFormat df = new SimpleDateFormat(pa);
            java.util.Date toDay = Calendar.getInstance().getTime();
            String DateS = df.format(toDay);
                Reclamation rec=new Reclamation(0,TextDescriptionREC.getText(),DateS,TextObjetRec.getText(),1,1,"non traité");
                sr.ajouter2(rec);
        */
    

        if (TextDescriptionREC.getText().isEmpty() || TextObjetRec.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs  !");
            alert.showAndWait();
        } else {
            
            
            
            
            if (TextDescriptionREC.getText().length()>50 || TextObjetRec.getText().length()>50) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("les champs dois étre< 50 !");
            alert.showAndWait();
        } else
        
        if ( !isAlpha(TextDescriptionREC.getText()) || !isAlpha(TextObjetRec.getText())) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("les champs dois étre alphabétique !");
            alert.showAndWait();
        } else{
            
            
            
            

            ServiceReclamation sr = new ServiceReclamation();
            String arD = TextDescriptionREC.getText();
            String arO = TextObjetRec.getText();
            //String arT="non traité";
            String pa = "dd/MM/yyyy";
            DateFormat df = new SimpleDateFormat(pa);
            java.util.Date toDay = Calendar.getInstance().getTime();
            String DateS = df.format(toDay);
            AjouterCategorieController ac = new AjouterCategorieController();
           ServiceCategorie sc=new ServiceCategorie();
      
                Reclamation r = new Reclamation(arD, DateS, arO, 1, sc.rechRec(ac.T));
                sr.ajouter2(r);
            initialize(null, null);
            TextDescriptionREC.setText(" ");
            TextObjetRec.setText(" ");
        }}

    }

    @FXML
    void recherche(KeyEvent event) throws SQLException {
        ServiceReclamation service = new ServiceReclamation();

        ObservableList<recCat> List = FXCollections.observableArrayList(service.readRec(1));

        FilteredList<recCat> filteredData = new FilteredList<>(List, b -> true);
        // 2. Set the filter Predicate whenever the filter changes.
        recherche.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(recCat -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {

                    System.out.println("biennnnnnnnnnn");
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (recCat.getMessage().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches first name.
                } else if (recCat.getDate_reclamation().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                } else if (recCat.getObjet_reclamation().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                } else if (recCat.getType_reclamation().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                } else {
                    return false; // Does not match.
                }
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<recCat> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(Table_View.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        Table_View.setItems(sortedData);
//Écrire à Achref Hjaiej

    }

    @FXML
    private void supprimerRec(ActionEvent event) {

        List<recCat> rec = Table_View.getSelectionModel().getSelectedItems();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Vous voulez vraiment supprimer cette reclamation ?");
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            int id = Integer.parseInt(textIDREC.getText());
            supprimerReclamation(id);
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText(" Réclamation supprimé avec succés!");
            alert.show();
            textIDREC.setText(" ");

            int selectedID = Table_View.getSelectionModel().getSelectedIndex();
            Table_View.getItems().remove(selectedID);

            Table_View.refresh();

        }
    }

    @FXML
    private void modifierRec(ActionEvent event) throws SQLException {
        recCat Clikedrec = Table_View.getSelectionModel().getSelectedItem();

        if (!(TextDescriptionREC.getText().isEmpty() && TextObjetRec.getText().isEmpty())) {
            {

                Reclamation r = new Reclamation(Clikedrec.getId_reclamation(), TextDescriptionREC.getText(), TextObjetRec.getText(), Clikedrec.getId_user());
                System.out.println(r.getMessage());

                rs.update(r);

                initialize(null, null);

                TextDescriptionREC.setText(" ");
                TextObjetRec.setText(" ");
            }
        }
    }

    @FXML
    void RecupererREC(ActionEvent event) {
        recCat Clikedrec = Table_View.getSelectionModel().getSelectedItem();
        System.out.println(Clikedrec.getMessage());

        TextDescriptionREC.setText(Clikedrec.getMessage());

        TextObjetRec.setText(Clikedrec.getObjet_reclamation());
    }

    @FXML
    private void Compte(ActionEvent event) {
    }

    @FXML
    private void RDV(ActionEvent event) {
    }

    @FXML
    private void REC(ActionEvent event) {
    }



    @FXML
    void GetListRec(MouseEvent event) {
        int selectedId = Table_View.getSelectionModel().getSelectedItem().getId_reclamation();
        textIDREC.setText(String.valueOf(selectedId));

    }

    void RecupererMODIF(ActionEvent event) {
        recCat Clikedrec = Table_View.getSelectionModel().getSelectedItem();
        TextDescriptionREC.setText(String.valueOf(Clikedrec.getMessage()));
        TextObjetRec.setText(String.valueOf(Clikedrec.getObjet_reclamation()));

    }

    @FXML
    void retour(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AjouterCategorie.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

    /////////////////////////////////////////
    public void supprimerReclamation(int id) {
        Connection con;

        try {
            con = MyDB.getInstance().getConnection();

            String req = "DELETE from   `reclamation` where id_Reclamation = ?";
            PreparedStatement ps = con.prepareStatement(req);
            System.out.println("Suppression...");
            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Une ligne supprimée dans la table");
        } catch (SQLException e) {

        }

    }

   

    @FXML
    private void TéléchargerPDF(ActionEvent event) throws DocumentException {
       
     generatePDF ();
       
   
    }
///////////////////////////////////////////////////////////////
   public void generatePDF () throws DocumentException { 
             Connection con;
             con = MyDB.getInstance().getConnection();
    Document doc = new Document();
        String sql = "select* from reclamation";

        try {
            Statement prepared = con.prepareStatement(sql);
            ResultSet rs = prepared.executeQuery(sql);
            PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\ACHRAF\\Desktop\\PDF test\\reclamation.pdf"));
            doc.open();
            doc.getHtmlStyleClass();

          
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" List de Reclamation"));
            doc.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100);
            PdfPCell cell;
            
         
            ////
            cell = new PdfPCell(new Phrase("description Réclamation"));
            cell.setHorizontalAlignment(cell.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.GRAY);
            table.addCell(cell);
            
            ////
              /* cell = new PdfPCell(new Phrase("Type Réclamation"));
            cell.setHorizontalAlignment(cell.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.GRAY);
            table.addCell(cell);*/
            ///
            cell = new PdfPCell(new Phrase("Objet Eeclamation"));
            cell.setHorizontalAlignment(cell.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.GRAY);
            table.addCell(cell);
            ///
            cell = new PdfPCell(new Phrase("Date Réclamation"));
            cell.setHorizontalAlignment(cell.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.GRAY);
            table.addCell(cell);
            ///
       
            ///
         
            //////////////////////////////////////////////////////////////////////////////
            while (rs.next()) {
             
                //////
                cell = new PdfPCell(new Phrase(rs.getString("message").toString()));
                cell.setHorizontalAlignment(cell.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                table.addCell(cell);
                
                ///////
                /* cell = new PdfPCell(new Phrase(rs.getString("type_reclamation").toString()));
            cell.setHorizontalAlignment(cell.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.GRAY);
            table.addCell(cell);*/
                ////////
                cell = new PdfPCell(new Phrase(rs.getString("objet_reclamation").toString()));
                cell.setHorizontalAlignment(cell.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                table.addCell(cell);
                ///////
                cell = new PdfPCell(new Phrase(rs.getString("date_reclamation").toString()));
                cell.setHorizontalAlignment(cell.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                table.addCell(cell);
                ////////////
             
                ///////
           

            }

            doc.add(table);
            doc.close();
            Desktop.getDesktop().open(new File("C:\\Users\\ACHRAF\\Desktop\\PDF test\\reclamation.pdf"));

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    @FXML
    private void GetReclamationView(MouseEvent event) {
    }

    @FXML
    private void ART(ActionEvent event) {
    }

    @FXML
    private void LOGOUTbntCLICKED(ActionEvent event) {
    }
    
    public static boolean isAlpha(String s) {
        return s != null && s.matches("^[a-zA-Z]*$");
    }

    @FXML
    private void Table_View(SortEvent<String> event) {
    }

    
}
    


    
    

