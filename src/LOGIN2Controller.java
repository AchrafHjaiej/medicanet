
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.sun.jdi.connect.spi.Connection;
//import com.twilio.Twilio;
//import com.twilio.type.PhoneNumber;
//import com.twilio.rest.api.v2010.account.Message;

import static java.awt.SystemColor.text;
import java.io.IOException;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import singleton.Service.ServiceUtilisateur;
import singleton.entities.Utilisateur;
import singleton.utils.MyDB;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.StageStyle;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author ACHRAF
 */
public class LOGIN2Controller implements Initializable {

    private java.sql.Connection con;
    private Statement ste;

    MyDB db = MyDB.getInstance();
    // Connection con;
    public PreparedStatement st;
    public ResultSet result;

    @FXML
    private Button bntConnect;
    @FXML
    private Label btn_sendPassword;
    @FXML
    private TextField txt_UserName;
    @FXML
    private Button SIGNINBTN;
    //private Parent fxml;
    //String email;
    @FXML
    private PasswordField txt_Password;
    @FXML
    private Button getSms;
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        con = MyDB.getInstance().getConnection();
    }

    @FXML
    private void Connect(ActionEvent event) {
        String UserName = txt_UserName.getText();
        String Password = txt_Password.getText();
        if (UserName.equals("admin") && Password.equals("achraf")|| UserName.equals("admin") && Password.equals("tass")) {
            // VBox.getScene().getWindow().hide();
            Stage ADMIN = new Stage();
            System.out.println("YOUR PASSWORD IS CORRECT");
            try {
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ADMIN.fxml"));
                Parent root = loader.load();
                
                Scene scene = new Scene(root);
                scene.getStylesheets().add("newCSSAdmin.css");            
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();                
                stage.setScene(scene);               
                stage.initStyle(StageStyle.TRANSPARENT);
                
                stage.initStyle(StageStyle.DECORATED );
                     
                Stage transparent = new Stage();
                
            //    Scene scene = .getScene();
       transparent.initStyle(StageStyle.TRANSPARENT);
       //decorated.setScene(null);
                transparent.setScene(scene);
                transparent.show();
             //   decorated.hide();
                
                
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (!UserName.equals("admin") && !Password.equals("achraf")) {
            String req = "select username,password,role from utilisateur where username ='" + txt_UserName.getText() + "' && password='" + txt_Password.getText() + "' ";

            try {
                st = con.prepareStatement(req);
                result = st.executeQuery();

                if (result.next()) {
                    String Role = result.getString("role");
                    System.out.println("YOUR PASSWORD IS CORRECT");
                    try {

                        if (Role.equals("MEDECIN")) {
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Job TN:: Success Message");
                            alert.setHeaderText(null);
                            alert.setContentText("WELCOME DOCTOR");
                            alert.showAndWait();
                            //SessionManager.setRole("candidat");
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("HOME.fxml"));
                            Parent root = loader.load();
                            Scene scene = new Scene(root);
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.setScene(scene);
                        } else if (Role.equals("PATIENT")) {
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Job TN:: Success Message");
                            alert.setHeaderText(null);
                            alert.setContentText("WELCOME :) ");
                            alert.showAndWait();
                            // SessionManager.setRole("sociéte");
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("HOMEPATIENT.fxml"));
                            Parent root = loader.load();
                            Scene scene = new Scene(root);
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.setScene(scene);
                        }

                    } catch (IOException ex) {
                        Logger.getLogger(HOMEController.class.getName()).log(Level.SEVERE, null, ex);
                        // String Role=result.getString("role");
                    }

                } else {
                    txt_UserName.setText("");
                    txt_Password.setText("");
                    txt_UserName.requestFocus();
                    JOptionPane.showMessageDialog(null, "Login Failed");
                    System.out.println("ERROR! YOUR PASSWORD IS INCORRECT  !!!!! ");
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Wrong Password");
                    alert.setHeaderText(null);
                    alert.setContentText("ERROR!  YOUR USERNAME OR YOUR PASSWORD IS INCORRECT  !!!!!");
                    alert.showAndWait();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LOGIN2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private void CreateAcount(ActionEvent event) {
    }
/*
    private void sendPassword(MouseEvent event) {
        try {
            sendMail("achref.hjaiej@esprit.tn");
        } catch (Exception ex) {
            Logger.getLogger(LOGIN2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
*/
    @FXML
    private void TOSIGNIN(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SIGNIN2.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(LOGIN2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void SENDPASSWORD(MouseEvent event) throws Exception {

    }

    public void sendMail(String recepient) throws Exception {
                System.out.println(recepient);
        System.out.println("Preparing to send email");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        //properties.put("mail.smtp.ssl.trust", "*");
        //properties.put("mail.debug", "true");
        final String myAccountEmail = "achref.hjaiej@esprit.tn";
        final String password = "213JMT0538";
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
             return new javax.mail.PasswordAuthentication(myAccountEmail, password);
            }
        });
        Message message = preparedMessage(session, myAccountEmail, recepient);
        System.out.println(message);
       // sendSMS();
        
        //Message message = Message.creator(new PhoneNumber(+21625154475),
          //          new PhoneNumber("(+13854062174"),
            //        "Your reset code is " + randomCode).create();
           // System.out.println(message.getSid()); 
        
        
        System.out.println("sms sent");
        try {
            Transport.send(message);
            Alert alert = new Alert(AlertType.CONFIRMATION, "Consulter votre boite mail pour recup password", javafx.scene.control.ButtonType.OK);
            System.out.println("Message sent successfully");
            alert.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

 
    private  Message preparedMessage(Session session, String myAccountEmail, String recepient) {

        String req = "select password from utilisateur where username ='" + txt_UserName.getText() + "'";
        String pass = "";

        try {
            st = con.prepareStatement(req);
            result = st.executeQuery();
            if (result.next()) {
                pass = result.getString("password");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // String text="Votre mot de passe est : "+pass+"";
        //String objet ="Recupération de mot de passe";
        try {
                    Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("MedicaNet Password");
           // message.setText();
            String htmlcode = "<h1> " + "Your Password is :" + pass + " </h1> <h2><b> </b></h2>";
            message.setContent(htmlcode, "text/html");
            return message;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @FXML
    private void SENDPASSWORD1(MouseEvent event) {
        String req = "select mail from utilisateur where username ='" + txt_UserName.getText() + "'";
        String mail = "";
        try {
            st = con.prepareStatement(req);
            result = st.executeQuery();
            if (result.next()) {

                mail = result.getString("mail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            sendMail(mail);
        } catch (Exception ex) {
            Logger.getLogger(LOGIN2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
 
   
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent()));
        stage.show();
    }

    private Parent createContent() {
        var field = new ValidatingTextField(input -> input.matches("\\d+"));
        field.setFont(Font.font(22));

        var btn = new Button("Submit");
        btn.setFont(Font.font(22));
        btn.disableProperty().bind(field.isValidProperty.not());

        return new VBox(field, btn);
    }

    @FXML
    private void getSms(ActionEvent event) throws IOException {
        
          
             FXMLLoader loader = new FXMLLoader(getClass().getResource("SMS.fxml"));
                                                                Parent root = loader.load();
                                                                Scene scene =new  Scene(root);
                                                                 Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();
                                                                stage.setScene(scene);  
        
    }

    private static class ValidatingTextField extends TextField {
        private final Predicate<String> validation;
        private BooleanProperty isValidProperty = new SimpleBooleanProperty();

        ValidatingTextField(Predicate<String> validation) {
            this.validation = validation;

            textProperty().addListener((o, oldValue, newText) -> {
                isValidProperty.set(validation.test(newText));
            });

            isValidProperty.set(validation.test(""));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


/*
public class Principal {

	public static void main(String[] args) {
	
        SmsUniqueRequest smsrequestunique = new SmsUniqueRequest();
        smsrequestunique.setSms("This is a one-time test!");
        smsrequestunique.setKeyid("API_KEY_HERE");
        smsrequestunique.setNum("PHONE_NUMBER_HERE");
        try{
        	SMSReponse result = apiInstance3.sendSms(smsrequestunique);
            System.out.println(result);
        }
        catch (ApiException e)
        {
        	System.err.println("Exception when calling SmsApi#sendSms");
            e.printStackTrace();
        }
        
	}

}*/
    
}
