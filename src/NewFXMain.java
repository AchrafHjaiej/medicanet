/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javafx.application.Application;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;

/**
 *
 * @author ACHRAF
 */

public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
     
        
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("LOGIN2.fxml"));
          
            Scene scene = new Scene(root);
            
            primaryStage.setTitle("MEDICANET"); 
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (IOException ex)
        {
            System.out.println(ex.getMessage());
            
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    

    }
    

