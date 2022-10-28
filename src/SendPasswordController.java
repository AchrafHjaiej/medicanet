/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.lookups.v1.PhoneNumber;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author ACHRAF
 */
public class SendPasswordController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void GETSMS(ActionEvent event) {
        
        
      
    }
    
    
    
          
     void sendSMS(){
       
//curl 'https://api.twilio.com/2010-04-01/Accounts/AC3b4824cf7799c6e73d543867a3d90868/Messages.json' -X POST \
//--data-urlencode 'To=+21625154475' \
//--data-urlencode 'MessagingServiceSid=ACd69dd8098f35f0daabc6a0ad44fe73a5' \
//--data-urlencode 'Body=your password is +pass+' \
//-u AC3b4824cf7799c6e73d543867a3d90868:[AuthToken]
       
/*
            String ACCOUNT_SID = "ACd69dd8098f35f0daabc6a0ad44fe73a5";
            String AUTH_TOKEN = "fbb183185332303afaf52679e54d0cfd";
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            String getf = txt_Password.getText();
            Random rand = new Random();
            randomCode = rand.nextInt(999999);
            System.out.println(randomCode);


*/
       }
        

}
