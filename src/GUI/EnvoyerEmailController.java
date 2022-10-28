/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class EnvoyerEmailController implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private TextField subject;
    @FXML
    private TextArea message;
    @FXML
    private Button envoyer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        email.setText("mail"+AdminController.Aemail);
        // TODO
    }    

    @FXML
    private void email(ActionEvent event) {
    }

    @FXML
    private void subject(ActionEvent event) {
    }

    @FXML
    private void envoyer(ActionEvent event) 
    {
        String to=email.getText();
        String sub=subject.getText();
        String msg=message.getText();
        Email e=new Email();
        e.envoyer(to,sub,msg);
    }
}
