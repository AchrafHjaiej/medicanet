/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author ACHRAF
 */
public class SMSController implements Initializable {

    @FXML
    private Button clicktorecieve;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
         void sendSMS(){
String num ="";
      
        

      
         String ACCOUNT_SID = "AC3b4824cf7799c6e73d543867a3d90868"; 
     String AUTH_TOKEN = "176ef4f6967cf0eed036b07fa3f1c273"; 
       Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
       
        Message message = Message.creator(new PhoneNumber("+33758350670"), new PhoneNumber("(+14092206134"),"Your reset code is " ).create();
           System.out.println(message.getSid());
     
  
     
     }

    @FXML
    private void clicktoRecieve(ActionEvent event) {
        
        sendSMS();
    }
    
}
