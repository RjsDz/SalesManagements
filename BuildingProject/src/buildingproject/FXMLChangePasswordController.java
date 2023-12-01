
package buildingproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;


public class FXMLChangePasswordController implements Initializable {

    
    
    @FXML
    private Button changBut;

    @FXML
    private Button exitBut;

    @FXML
    private TextField passInp;

    @FXML
    private TextField userInp;
    
    
    public void changF(){
        String username = userInp.getText().trim();
        String password = passInp.getText().trim();
        if(username.equals("") || password.equals("")){
            JOptionPane.showMessageDialog(null, "You should field all the fields !!! ");
            return;
        }
        
        DataBase.changeUserLogin(username, password);
        JOptionPane.showMessageDialog(null, "Updated was successfully ");
        userInp.setText("");
        passInp.setText("");
    }
    
    public void exitF(){
        exitBut.getScene().getWindow().hide();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
