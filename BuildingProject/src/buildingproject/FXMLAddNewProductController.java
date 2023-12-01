
package buildingproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author RJS
 */
public class FXMLAddNewProductController implements Initializable {

    
    @FXML
    private Button add;

    @FXML
    private TextField code;

    @FXML
    private Button updBut;
    
  

    @FXML
    private TextField desi;

    @FXML
    private CheckBox disp;

    @FXML
    private ImageView exitImg;

    @FXML
    private ComboBox<String> expImp;

    @FXML
    private TextField pruni;

    @FXML
    private TextField udm;
    
    @FXML 
    private Button delBut;
    
    
   public void exitF(){
       Lists.exit(udm);
   }
    
    public void addP(){
        int sel = 0;
        if(code.getText().trim().equals("") || udm.getText().trim().equals("") || desi.getText().trim().equals("") || pruni.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Please fill the fields");
            return;
        }
        if(disp.isSelected())
            sel = 1;
        try {
          DataBase.insertProduct(code.getText(), desi.getText(), Float.parseFloat(pruni.getText()), udm.getText(), sel,expImp.getSelectionModel().getSelectedItem());
            JOptionPane.showMessageDialog(null, "Product added successfully");
            code.setText("");
            udm.setText("");
            desi.setText("");
            pruni.setText("");
            
          
        } catch (Exception e) {
            System.out.println(e+"");
        
        }
        
    }
    
    public void updateP(){
        int sel = 0;
        if(desi.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Please fill the designation Code");
            return;
        }
        if(disp.isSelected())
            sel = 1;
        try {
          DataBase.updateProduct(desi.getText().trim(), sel);
            JOptionPane.showMessageDialog(null, "Product update successfully");
            code.setText("");
            udm.setText("");
            desi.setText("");
            pruni.setText("");
            
          
        } catch (Exception e) {
            System.out.println(e+"");
        
        }
           
    }
    
    public void deleteP(){
        
        if(desi.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Please fill the designation Code");
            return;
        }
        
        try {
            DataBase.delProduct(desi.getText().trim());
            JOptionPane.showMessageDialog(null, "Product deleted  successfully");
            code.setText("");
            udm.setText("");
            desi.setText("");
            pruni.setText("");
            
          
        } catch (Exception e) {
            System.out.println(e+"");
        
        }
           
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(()->{
            ObservableList<String> list = FXCollections.observableArrayList("Export","Import");
            expImp.setItems(list);
            
            desi.getScene().addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                if(event.getCode() == KeyCode.E && event.isControlDown()){
                    exitF();
                }
            
            
            });
        
        
        });
        
        
    }    
    
}
