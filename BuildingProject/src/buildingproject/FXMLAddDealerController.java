
package buildingproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;


public class FXMLAddDealerController implements Initializable {

    
    
    @FXML
    private Button canBut;

    @FXML
    private TextField due;

    @FXML
    private TextField ndt;

    @FXML
    private TextField nom;

    @FXML
    private TextField pay;

    @FXML
    private TextField pren;

    @FXML
    private Label price;

    @FXML
    private CheckBox rec;

    @FXML
    private Button savBut;

    @FXML
    private TextField vil;
    
    @FXML
    private Label clienFourn;
    
    
    
    
    
    
    public void saveToDB(){
        try {
             String nome = nom.getText().trim();
        String prenom = pren.getText().trim();
        String ville = vil.getText().trim();
        String num2t = ndt.getText().trim();
        float paym = Float.parseFloat(pay.getText().trim());
        float dues = Float.parseFloat(due.getText().trim());
        int r = (rec.isSelected()) ? 1 : 0;
        String date = DateTimeTotalType.date;
        String time = DateTimeTotalType.time;
        if(nome.equals("") || prenom.equals("") || pay.getText().trim().equals("") || due.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Le nome ,prenome , payment, dues is required field !!!!");
            return;
        }
        String matr = nome.substring(0, 1).toUpperCase()+prenom.substring(0, 1).toUpperCase()+DateTimeTotalType.date+DateTimeTotalType.time;
        matr = matr.replace(":", "").replace("-", "");
        String type = "Client";
        if(Lists.pointerOfDealers == 2)
            type = "Fourniseur";
        DataBase.insertDealer(type, nome, prenom, ville, num2t, paym, dues, date, time, matr, r);
        DateTimeTotalType.pay = paym;
        DateTimeTotalType.due = dues;
        DataBase.incrementCount();
        DateTimeTotalType.bon= DataBase.getCountBon();
        
        PDFInvoiceGenerate.pdfCreate();
        } catch (Exception e) {
        }
    
    }
    
    public void exitF(){
        Lists.exit(vil);
    }
    
    public void dueF(){
        try {
            if(pay.getText().equals("")){
            due.setText("");
            return;
        }
        float f =  -Float.parseFloat(pay.getText()) + DateTimeTotalType.total;
        due.setText(f+"");
        } catch (Exception e) {
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Platform.runLater(()->{
        
            if(Lists.pointerOfDealers == 1){
                clienFourn.setText("L'information De Client");
                
                
            }else if(Lists.pointerOfDealers == 2){
                clienFourn.setText("L'incfomation De Fourniseur");
            }
            
            price.setText(DateTimeTotalType.total+"");

        
        });
        
       
    }    
    
}
