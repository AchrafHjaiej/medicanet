/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.sun.jdi.connect.spi.Connection;
import com.sun.prism.Image;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import singleton.Service.ServiceUtilisateur;
import singleton.entities.Utilisateur;
import singleton.utils.MyDB;

/**
 * FXML Controller class
 *
 * @author ACHRAF
 */
public class HOMEPATIENTController implements Initializable {

    
        MyDB db = MyDB.getInstance();
    Connection con;
    public  PreparedStatement st;
    public ResultSet result;
    @FXML
    private Button demandeReclamation;
    @FXML
    private Button RDV;
    
    /**
     * 
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void LOGOUTbntCLICKED(ActionEvent event) {
                                                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
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
                                                                 FXMLLoader loader = new FXMLLoader(getClass().getResource("HOMEPATIENT.fxml"));
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
    private void GetQRcode(MouseEvent event) throws FileNotFoundException, IOException, WriterException{
         

            FileOutputStream fos = null;     
            String details = "MEDICANET APP ";
            ByteArrayOutputStream out = QRCode.from(details).to(ImageType.PNG ).stream() ;
            File f = new File("C:\\Users\\ACHRAF\\Documents\\NetBeansProjects\\singleton_JDBC\\src\\QRcode\\Mychannel.png") ;
            fos = new FileOutputStream(f);          
            fos.write (out.toByteArray()) ;         
            fos.flush();                       
            fos.close();    
            System.out.println("bbbbbbbbbbbbbbbbb");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("QRcode.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
    }

    @FXML
    private void GetReclamationView(MouseEvent event) {
        
        
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("\\GUI\\AjouterCategorie.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(LOGIN2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void RDV(ActionEvent event) {
        
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("\\gui2\\RDV.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(LOGIN2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            
    }
  
    

