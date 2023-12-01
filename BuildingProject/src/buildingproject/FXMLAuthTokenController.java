
package buildingproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;


public class FXMLAuthTokenController implements Initializable {
    @FXML
    private Button cancelBut;

    @FXML
    private Button logBut;

    @FXML
    private PasswordField passInp;

    @FXML
    private TextField userInp;
    
    public void exit(){
        System.exit(0);
        Platform.exit();
    }
    
    public void loginF(){
        boolean isTrue = DataBase.isExist(userInp.getText().trim(), passInp.getText().trim());
        if(!isTrue){
            JOptionPane.showMessageDialog(null, "Your username or password is uncorect !!!!");
            passInp.setText("");
            return;
        }else {
            passInp.getScene().getWindow().hide();
            Pages p = new Pages("FXMLDocumant.fxml", userInp, true);
           
            p.setTitle("Building Material Company ~ V:1.0.1");
            p.setIcon("images\\bldc.png");
            p.setLocation(2, 3);
            p.newStrage();
        }
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
