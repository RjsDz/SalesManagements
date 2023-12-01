
package buildingproject;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javax.swing.JOptionPane;

/**
 * 
 *
 * @author Rjs
 */
public class FXMLDocumantController implements Initializable {

    @FXML
    private Button addProdButt;
    
    @FXML
    private Label typeG;
    

    @FXML
    private Button addProdButt1;

    @FXML
    private Label bonNum;

    @FXML
    private TableColumn<Product, String> code;

    @FXML
    private Label dateLab;

    @FXML
    private TableColumn<Product, String> dis;

    @FXML
    private TableColumn<Product, Integer> disp;

    @FXML
    private ImageView exitIm;
    
    @FXML
    private ImageView ps;

    @FXML
    private Button expBut;

    @FXML
    private Button impButt;

    @FXML
    private Label itemsLab;

    @FXML
    private TextField newQteLab;

    @FXML
    private ImageView plus;

    @FXML
    private ImageView plus1;
    
    @FXML 
    private ImageView gr;

    @FXML
    private ImageView printImg;

    @FXML
    private TableColumn<Product, Float> pu;

    @FXML
    private TableColumn<Product, Float> qte;

    @FXML
    private TextField receivedLab;

    @FXML
    private TextField rendLab;

    @FXML
    private Button serchButt;

    @FXML
    private TableColumn<Product, Float> sum;

    @FXML
    private TableView<Product> table;

    @FXML
    private Label timeLab;

    @FXML
    private Label totalLab;

    @FXML
    private TableColumn<Product, String> udm;

    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    
    
    public void exitF(){
        DataBase.closeConnectionDB();
        System.exit(0);
        Platform.exit();
    }
    
    private void updateDateTime() {
    try {
        Date dateTime = new Date();
        SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");
        String date_ = formatterDate.format(dateTime);
        String time_ = formatterTime.format(dateTime);

        Platform.runLater(() -> {
            dateLab.setText(date_);
            timeLab.setText(time_);
            bonNum.setText(DateTimeTotalType.bon+"");
            totalF();
         /*
        userLab.setText(Employee.name);
            total();*/
        });
    } catch (Exception ex) {
        System.out.println(ex);
    }
    
}
    public void addProductPage(){
        Pages p = new Pages("FXMLAddNewProduct.fxml", timeLab, true);
        p.fixSize(true);
        p.setTitle("Add New Product");
        p.setIcon("images\\pr.png");
        p.newStrage();
    }
    
    public void searchPage(){
        Pages p = new Pages("FXMLSearch.fxml", timeLab, true);
        p.fixSize(true);
        p.setTitle("Search For  Product");
        p.setIcon("images\\pr.png");
        p.newStrage();
    }
    
    
    public void plusF(){
        int index = 0;
        
        
        switch (Lists.pointerOfProduct) {
            case 1:
                if(Lists.list1.size() == 0)
                    break;
                index = Lists.list1.size() - 1;
                float newqte = Lists.list1.get(index).getQte() + 1;
                Lists.list1.get(index).setQte(newqte);
                table.setItems(Lists.list1);
                table.refresh();
                break;
            case 2:
                if(Lists.list2.size() == 0)
                    break;
                index = Lists.list2.size() - 1;
                newqte = Lists.list2.get(index).getQte() + 1;
                Lists.list2.get(index).setQte(newqte);
                table.setItems(Lists.list2);
                table.refresh();
                break;
        }
        totalF();
    }
    
    public void minusF(){
        int index = 0;
        
        switch (Lists.pointerOfProduct) {
            case 1:
                index = Lists.list1.size() - 1;
                if(Lists.list1.get(index).getQte() < 2)
                    return;
                float newqte = Lists.list1.get(index).getQte() - 1;
                Lists.list1.get(index).setQte(newqte);
                table.setItems(Lists.list1);
                table.refresh();
                break;
            case 2:
                index = Lists.list2.size() - 1;
                if(Lists.list2.get(index).getQte() < 2)
                    return;
                newqte = Lists.list2.get(index).getQte() + 1;
                Lists.list2.get(index).setQte(newqte);
                table.setItems(Lists.list2);
                table.refresh();
                break;
        }
        totalF();
    }
    
    public void delRecord(){
        int index = table.getSelectionModel().getSelectedIndex();
        if(index == -1)
            return;
        switch (Lists.pointerOfProduct) {
            case 1:
                Lists.list1.remove(index);
                table.setItems(Lists.list1);
                table.refresh();
                break;
            case 2:
                Lists.list2.remove(index);
                table.setItems(Lists.list2);
                table.refresh();
                break;
        }
        totalF();
    }
    
    public void dropTableView(){
        switch (Lists.pointerOfProduct) {
            case 1:
                Lists.list1.clear();
                table.setItems(Lists.list1);
                table.refresh();
                break;
            case 2:
                Lists.list2.clear();
                table.setItems(Lists.list2);
                table.refresh();
                break;
        }
    }
    
    public void importF(){
        Lists.pointerOfProduct = 2;
        Lists.pointerOfDealers = 2;
        table.setItems(Lists.list2);
        table.refresh();
        totalF();
        typeG.setText("Gerer Les Fourniseurs");
    }
    
    public void exportF(){
        Lists.pointerOfProduct = 1;
        Lists.pointerOfDealers = 1;
        table.setItems(Lists.list1);
        table.refresh();
        totalF();
        typeG.setText("Gerer Les Clients");
    }
    
    public void totalF(){
        float s = 0;
        int i = 0;
        switch (Lists.pointerOfProduct) {
            case 1:
                i = Lists.list1.size();
                for(Product p : Lists.list1){
                    s += p.getSum();    
                }
                break;
            case 2:
                i = Lists.list2.size();
                for(Product p : Lists.list2){
                    s += p.getSum();
                }
                break;
        }
        totalLab.setText(s+"");
        itemsLab.setText(i+"");
    }

    
  void changeQteF() {
    try {
        float newQte = Float.parseFloat(newQteLab.getText());

        int selectedIndex = table.getSelectionModel().getSelectedIndex();

        if (selectedIndex > -1) {
            switch (Lists.pointerOfProduct) {
                case 1:
                    if (selectedIndex < Lists.list1.size()) {
                        Lists.list1.get(selectedIndex).setQte(newQte);
                        table.setItems(Lists.list1);
                    } else {
                        displayErrorAlert("Invalid Index for List 1");
                    }
                    break;
                case 2:
                    if (selectedIndex < Lists.list2.size()) {
                        Lists.list2.get(selectedIndex).setQte(newQte);
                        table.setItems(Lists.list2);
                    } else {
                        displayErrorAlert("Invalid Index for List 2");
                    }
                    break;
            }
            table.refresh();
            newQteLab.setText("");
            
        } else {
            displayErrorAlert("Select a record in the table!");
        }
    } catch (NumberFormatException e) {
        displayErrorAlert("Invalid Quantity Input");
    } catch (Exception e) {
        displayErrorAlert("An unexpected error occurred: " + e.getMessage());
    }
}

private void displayErrorAlert(String message) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Error");
    alert.setHeaderText(null);
    alert.setContentText(message);
   
    alert.showAndWait();
}

    
    public void rendF(){
        if(receivedLab.getText().equals("")){
            rendLab.setText("");
            return;
        }
        try {
          float f = Float.parseFloat(receivedLab.getText()) - Float.parseFloat(totalLab.getText());
            rendLab.setText(f+"");  
        } catch (Exception e) {
            System.out.println(e+"");
        }
        
    }
    
    public void openCalcPage(){
        Pages p = new Pages("FXMLCalc.fxml", timeLab, true);
        p.fixSize(true);
        p.setTitle("Calculator");
        p.setIcon("images\\calculator.png");
        p.newStrage();
    }
    
    public void editedTotalF(){
        if(Float.parseFloat(totalLab.getText()) < 1.0 ){
            JOptionPane.showMessageDialog(null, "Ther is not purchase !!!!");
            return;
        }
        valider();
        Pages p = new Pages("FXMLAddDealer.fxml", timeLab, true);
        if(Lists.pointerOfDealers == 1){
            DateTimeTotalType.total = Float.parseFloat(totalLab.getText());
            
            p.fixSize(true);
            p.setTitle("L'information de client");
            p.setIcon("images\\client.png");
            p.newStrage();
        }else if(Lists.pointerOfDealers == 2){
            DateTimeTotalType.total = Float.parseFloat(totalLab.getText());
            p.fixSize(true);
            p.setTitle("L'information de fourniseur");
            p.setIcon("images\\four.png");
            p.newStrage();
        }
        
        
    }
    
    public void valider(){
        DateTimeTotalType.date = dateLab.getText();
        DateTimeTotalType.time = timeLab.getText();
        DateTimeTotalType.total = Float.parseFloat(totalLab.getText());
    }
    
    public void openBlackListPage(){
        Pages p = new Pages("FXMLBlackList.fxml", timeLab, true);
            p.fixSize(true);
            p.setTitle("Black List");
            p.setIcon("images\\list.png");
            p.newStrage();
    }
    
    
    public void openChangePassword(){
         Pages p = new Pages("FXMLChangePassword.fxml", timeLab, true);
            p.fixSize(true);
            p.setTitle("Password & Usernam Configuration");
            p.setIcon("images\\key.png");
            p.newStrage();       
    }
    
    public void openStatPage(){
         Pages p = new Pages("FXMLStat.fxml", timeLab, true);
            p.fixSize(true);
            p.setTitle("Statistics");
            p.setIcon("images\\analytic.png");
            p.newStrage();       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        Platform.runLater(()->{
            // Cell Values of Tables
            code.setCellValueFactory(new PropertyValueFactory("code"));
            dis.setCellValueFactory(new PropertyValueFactory("disignation"));
            udm.setCellValueFactory(new PropertyValueFactory("unite_de_mesure"));
            pu.setCellValueFactory(new PropertyValueFactory("prix_unitaire"));
            qte.setCellValueFactory(new PropertyValueFactory("qte"));
            sum.setCellValueFactory(new PropertyValueFactory("sum"));
            disp.setCellValueFactory(new PropertyValueFactory("disponibility"));
            
          
            bonNum.setText(DateTimeTotalType.bon+"");
            rendLab.getScene().addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                if(event.getCode() == KeyCode.E && event.isControlDown()){
                    exitF();
                }else if(event.getCode() == KeyCode.F3){
                    searchPage();
                }else if(event.getCode() == KeyCode.D && event.isControlDown()){
                    delRecord();
                }else if(event.getCode() == KeyCode.F4 && event.isControlDown()){
                    plusF();
                }else if(event.getCode() == KeyCode.F5 && event.isControlDown()){
                    minusF();
                }else if(event.getCode() == KeyCode.N && event.isControlDown()){
                    changeQteF();
                }else if(event.getCode() == KeyCode.F1){
                    exportF();
                }else if(event.getCode() == KeyCode.F2){
                    importF();
                }else if(event.getCode() == KeyCode.P && event.isControlDown()){
                    editedTotalF();
                }
                event.consume();
            
            
            });
            
            if(Lists.pointerOfProduct == 1){
                table.setItems(Lists.list1);
                table.refresh();
            }else if(Lists.pointerOfProduct == 2){
                table.setItems(Lists.list2);
                table.refresh();
            }
            
            
        scheduler.scheduleAtFixedRate(FXMLDocumantController.this::updateDateTime, 0, 1, TimeUnit.SECONDS);
        });
    }    
    
}
