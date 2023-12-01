
package buildingproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javax.swing.JOptionPane;


public class FXMLSearchController implements Initializable {

    
    @FXML
    private TableColumn<Product, String> codeCol;

    @FXML
    private TableColumn<Product, String> desCol;

    @FXML
    private TableColumn<Product, Integer> dispCol;

    @FXML
    private ImageView exitImg;

    @FXML
    private TableColumn<Product, Float> puCol;

    @FXML
    private TextField searchInp;

    @FXML
    private Button sendBut;

    @FXML
    private TableView<Product> table;

    @FXML
    private TableColumn<Product, String> udmCol;
    
    private ObservableList<Product> newList = Lists.products();
    
    public void exitF(){
        Lists.exit(searchInp);
    }
    
    public void filter(){
        String match = searchInp.getText();
        newList = FXCollections.observableArrayList();
        for(Product p : Lists.products()){
            boolean codeB = String.valueOf(p.getCode()).toLowerCase().contains(match.toLowerCase());
            boolean designationB = p.getDisignation().toLowerCase().contains(match.toLowerCase());
            boolean priceB = String.valueOf(p.getPrix_unitaire()).toLowerCase().contains(match.toLowerCase());
            boolean dispB = String.valueOf(p.getDisponibility()).toLowerCase().contains(match.toLowerCase());
            if (codeB || designationB || priceB || dispB || dispB) {
                newList.add(p);
            }
        }
        table.setItems(newList);
        table.refresh();
    }
    
    public void insertIntoInput(){
        int index = table.getSelectionModel().getSelectedIndex();
        /*if(newList.get(index).getDisponibility() == 0){
            JOptionPane.showMessageDialog(null, "The product selected is not available !!!");
            return;
        }*/
        if(index != -1)
            searchInp.setText(newList.get(index).getDisignation());
    }
    
    public void sendData(){
        boolean isExist = false;
        Product product = null;
        for(Product p : newList){
            if(searchInp.getText().equals(p.getDisignation()) && p.getDisponibility() == 0){
               JOptionPane.showMessageDialog(null, "The product selected is not available !!!");
                return; 
            }
        }
        
        
            for(Product p : Lists.products()){
                if(p.getDisignation().equals(searchInp.getText())){
                    if(p.getDisponibility() == 0){
                        JOptionPane.showMessageDialog(null, "The product selected is not available !!!");
                        return;
                    }
                    isExist = true;
                    product = p;
                    break;
                }
            }
            if(isExist && Lists.pointerOfProduct == 1){
                Lists.list1.add(product);
            }else if(isExist && Lists.pointerOfProduct == 2){
                Lists.list2.add(product);
            }
        searchInp.setText("");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Platform.runLater(()->{
             ObservableList<Product> list  = FXCollections.observableArrayList();
             if(Lists.pointerOfProduct == 1){
               list = DataBase.fetchAllProducts("Export");
             }else if(Lists.pointerOfProduct == 2){
                list = DataBase.fetchAllProducts("Import");
             }
            codeCol.setCellValueFactory(new PropertyValueFactory("code"));
            desCol.setCellValueFactory(new PropertyValueFactory("disignation"));
            udmCol.setCellValueFactory(new PropertyValueFactory("unite_de_mesure"));
            puCol.setCellValueFactory(new PropertyValueFactory("prix_unitaire"));
            dispCol.setCellValueFactory(new PropertyValueFactory("disponibility"));
            
            table.setItems(list);
            table.refresh();
            
            searchInp.getScene().addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                if(event.getCode() == KeyCode.E && event.isControlDown()){
                    exitF();
                }else if(event.getCode() == KeyCode.S && event.isControlDown()){
                    sendData();
                }
            
            
            });
            
            
            
        
        
        });
         
         
         
         
    }    
    
}
