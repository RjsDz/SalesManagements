package buildingproject;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

public class FXMLBlackListController implements Initializable {

    @FXML
    private TableColumn<Dealer, Float> blDueCol;

    @FXML
    private TableColumn<Dealer, String> blMatCol;

    @FXML
    private TableColumn<Dealer, String> blNom;

    @FXML
    private TableColumn<Dealer, String> blPrenCol;

    @FXML
    private TableView<Dealer> blTable;

    @FXML
    private Label changedLab;

    @FXML
    private TableColumn<Dealer, Float> dueCol;

    @FXML
    private ImageView factory;

    @FXML
    private TableColumn<Dealer, String> matCol;

    @FXML
    private TableColumn<Dealer, String> nom;

    @FXML
    private TableColumn<Dealer, String> prenCol;

    @FXML
    private TableView<Dealer> table;

    @FXML
    private ImageView toBl;

    @FXML
    private TextField filterInp;

    @FXML
    private TableColumn<Dealer, String> blPhone;

    @FXML
    private TableColumn<Dealer, String> phone;

    private ObservableList<Dealer> l1 = DataBase.fetchClients();
    private ObservableList<Dealer> l2 = DataBase.fetchCliensBL();
    private ObservableList<Dealer> l3 = DataBase.fetchFourn();
    private ObservableList<Dealer> l4 = DataBase.fetchFournBL();

    public void filterFClient() {
        String regex = filterInp.getText().trim().toLowerCase();

        if (regex.isEmpty()) {
            l1 = DataBase.fetchClients();
            l2 = DataBase.fetchCliensBL();
            table.setItems(l1);
            table.refresh();
            blTable.setItems(l2);
            blTable.refresh();
            return;
        }

        ObservableList<Dealer> filteredList = l1.filtered(d ->
                d.getMatricule().toLowerCase().contains(regex) ||
                        d.getNome().toLowerCase().contains(regex) ||
                        d.getPrenome().toLowerCase().contains(regex)
        );
        l1 = filteredList;
        table.setItems(l1);
        table.refresh();

        ObservableList<Dealer> blFilteredList = l2.filtered(d ->
                d.getMatricule().toLowerCase().contains(regex) ||
                        d.getNome().toLowerCase().contains(regex) ||
                        d.getPrenome().toLowerCase().contains(regex)
        );
        l2 = blFilteredList;
        blTable.setItems(l2);
        blTable.refresh();
    }

    public void filterFFourn() {
        String regex = filterInp.getText().trim().toLowerCase();

        if (regex.isEmpty()) {
            l3 = DataBase.fetchFourn();
            l4 = DataBase.fetchCliensBL();
            table.setItems(l3);
            table.refresh();
            blTable.setItems(l4);
            blTable.refresh();
            return;
        }

        ObservableList<Dealer> filteredList = l3.filtered(d ->
                d.getMatricule().toLowerCase().contains(regex) ||
                        d.getNome().toLowerCase().contains(regex) ||
                        d.getPrenome().toLowerCase().contains(regex)
        );
        l3 = filteredList;
        table.setItems(l3);
        table.refresh();

        ObservableList<Dealer> blFilteredList = l4.filtered(d ->
                d.getMatricule().toLowerCase().contains(regex) ||
                        d.getNome().toLowerCase().contains(regex) ||
                        d.getPrenome().toLowerCase().contains(regex)
        );
        l4 = blFilteredList;
        blTable.setItems(l4);
        blTable.refresh();
    }

    public void filterF() {
        switch (Lists.pointerOfDealers) {
            case 1:
                filterFClient();
                break;
            case 2:
                filterFFourn();
                break;
        }
    }
    
    
    
    public void toBL(){
        int index = table.getSelectionModel().getSelectedIndex();
        String reg = filterInp.getText().trim();
        String matricule;
        if(index < 0 && reg.equals("") ){
            JOptionPane.showMessageDialog(null, "Ther is not selected record !!!");
            return;
        }
        
        switch (Lists.pointerOfDealers) {
            case 1:
                DataBase.clientToBL(reg);
                l1 = DataBase.fetchClients();
                l2 = DataBase.fetchCliensBL();
                table.setItems(l1);
                table.refresh();
                
                blTable.setItems(l2);
                blTable.refresh();
                break;
            case 2:
                DataBase.fournToBL(reg);
                l3 = DataBase.fetchFourn();
                l4 = DataBase.fetchFournBL();
                table.setItems(l3);
                table.refresh();
                
                blTable.setItems(l4);
                blTable.refresh();
                break;
        }
    }
    
    public void selectL(){
        int index = table.getSelectionModel().getSelectedIndex();
        if(index < 0)
            return ;
        if(Lists.pointerOfDealers == 1){
            filterInp.setText(l1.get(index).getMatricule());
        }else if(Lists.pointerOfDealers == 2){
            filterInp.setText(l3.get(index).getMatricule());
        }
    }
    
    public void selectR(){
        int index = blTable.getSelectionModel().getSelectedIndex();
        if(index < 0)
            return;
        if(Lists.pointerOfDealers == 1){
            filterInp.setText(l2.get(index).getMatricule());
        }else if(Lists.pointerOfDealers == 2){
            filterInp.setText(l4.get(index).getMatricule());
        }
    }
    
    public void fromBL(){
        int index = blTable.getSelectionModel().getSelectedIndex();
        String reg = filterInp.getText().trim();
        String matricule;
        if(index < 0 && reg.equals("") ){
            JOptionPane.showMessageDialog(null, "Ther is not selected record !!!");
            return;
        }
        
        switch (Lists.pointerOfDealers) {
            case 1:
                DataBase.clientFromBL(reg);
                l1 = DataBase.fetchClients();
                l2 = DataBase.fetchCliensBL();
                table.setItems(l1);
                table.refresh();
                
                blTable.setItems(l2);
                blTable.refresh();
                break;
            case 2:
                DataBase.fournFromBL(reg);
                l3 = DataBase.fetchFourn();
                l4 = DataBase.fetchFournBL();
                table.setItems(l3);
                table.refresh();
                
                blTable.setItems(l4);
                blTable.refresh();
                break;
        }
    }
    
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(() -> {
            if (Lists.pointerOfDealers == 1) {
                changedLab.setText("Clients");
                table.setItems(DataBase.fetchClients());
                table.refresh();

                blTable.setItems(DataBase.fetchCliensBL());
                blTable.refresh();
            } else if (Lists.pointerOfDealers == 2) {
                changedLab.setText("Fourniseur");
                table.setItems(DataBase.fetchFourn());
                table.refresh();

                blTable.setItems(DataBase.fetchFournBL());
                blTable.refresh();
            }

            matCol.setCellValueFactory(new PropertyValueFactory<>("matricule"));
            nom.setCellValueFactory(new PropertyValueFactory<>("nome"));
            prenCol.setCellValueFactory(new PropertyValueFactory<>("prenome"));
            dueCol.setCellValueFactory(new PropertyValueFactory<>("dues"));
            phone.setCellValueFactory(new PropertyValueFactory<>("num_telephone"));

            // TABLE TWO.

            blMatCol.setCellValueFactory(new PropertyValueFactory<>("matricule"));
            blNom.setCellValueFactory(new PropertyValueFactory<>("nome"));
            blPrenCol.setCellValueFactory(new PropertyValueFactory<>("prenome"));
            blDueCol.setCellValueFactory(new PropertyValueFactory<>("dues"));
            blPhone.setCellValueFactory(new PropertyValueFactory<>("num_telephone"));
        });
    }
}


/*
package buildingproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;


public class FXMLBlackListController implements Initializable {

    @FXML
    private TableColumn<Dealer, Float> blDueCol;

    @FXML
    private TableColumn<Dealer, String> blMatCol;

    @FXML
    private TableColumn<Dealer, String> blNom;

    @FXML
    private TableColumn<Dealer, String> blPrenCol;

    @FXML
    private TableView<Dealer> blTable;

    @FXML
    private Label changedLab;

    @FXML
    private TableColumn<Dealer, Float> dueCol;

    @FXML
    private ImageView factory;

    @FXML
    private TableColumn<Dealer, String> matCol;

    @FXML
    private TableColumn<Dealer, String> nom;

    @FXML
    private TableColumn<Dealer, String> prenCol;

    @FXML
    private TableView<Dealer> table;

    @FXML
    private ImageView toBl;
    
    @FXML
    private TextField filterInp;
    
    
    @FXML
    private TableColumn<Dealer, String> blPhone;

    @FXML
    private TableColumn<Dealer, String> phone;
    
    private ObservableList<Dealer> l1 = DataBase.fetchClients();
    
    private ObservableList<Dealer> l2 = DataBase.fetchCliensBL();
    
    private ObservableList<Dealer> l3 = DataBase.fetchFourn();
    
    private ObservableList<Dealer> l4 = DataBase.fetchFournBL();
    
    private ObservableList<Dealer> newL1 = FXCollections.observableArrayList();// DataBase.fetchClients();
    
    private ObservableList<Dealer> newL2 = FXCollections.observableArrayList(); // DataBase.fetchCliensBL();
    
    private ObservableList<Dealer> newL3 = FXCollections.observableArrayList(); //  DataBase.fetchFourn();
    
    private ObservableList<Dealer> newL4 = FXCollections.observableArrayList();  // DataBase.fetchFournBL();
    
    
    public void filterFClient(){
        String rgex = filterInp.getText().trim().toLowerCase();
       
        if(rgex.equals("")){
            table.setItems(l1);
            table.refresh();
            
            blTable.setItems(l2);
            blTable.refresh();
            newL1.clear();
            newL2.clear();
        }
        
        
        for(Dealer d : l1){
            if(d.getMatricule().toLowerCase().contains(rgex) || d.getNome().toLowerCase().contains(rgex) || d.getPrenome().toLowerCase().contains(rgex)){
                newL1.add(d);
            }
        }
        
        for(Dealer d : l2){
            if(d.getMatricule().toLowerCase().contains(rgex) || d.getNome().toLowerCase().contains(rgex) || d.getPrenome().toLowerCase().contains(rgex)){
                newL2.add(d);
            }
        }
        
        table.setItems(newL1);
        table.refresh();
        
        blTable.setItems(newL2);
        blTable.refresh();
        
    }
    
    public void filterFFourn(){
        String rgex = filterInp.getText().trim().toLowerCase();
        
        if(rgex.equals("")){
            table.setItems(l3);
            table.refresh();
            
            blTable.setItems(l4);
            blTable.refresh();
            newL3.clear();
            newL4.clear();
        }
        
        
        for(Dealer d : l3){
            if(d.getMatricule().toLowerCase().contains(rgex) || d.getNome().toLowerCase().contains(rgex) || d.getPrenome().toLowerCase().contains(rgex)){
                newL3.add(d);
            }
        }
        
        for(Dealer d : l4){
            if(d.getMatricule().toLowerCase().contains(rgex) || d.getNome().toLowerCase().contains(rgex) || d.getPrenome().toLowerCase().contains(rgex)){
                newL4.add(d);
            }
        }
        
        table.setItems(newL3);
        table.refresh();
        
        blTable.setItems(newL4);
        blTable.refresh();
        
    }
    
    public void filterF(){
        switch (Lists.pointerOfDealers) {
            case 1:
                filterFClient();
                break;
            case 2:
                filterFFourn();
                break;
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Platform.runLater(()->{
            
            if(Lists.pointerOfDealers == 1){
                changedLab.setText("Clients");
                table.setItems(DataBase.fetchClients());
                table.refresh();
                
                blTable.setItems(DataBase.fetchCliensBL());
                blTable.refresh();
            }else if(Lists.pointerOfDealers == 2){
                changedLab.setText("Fourniseur");
                
                table.setItems(DataBase.fetchFourn());
                table.refresh();
                
                blTable.setItems(DataBase.fetchFournBL());
                blTable.refresh();
            }
            
            matCol.setCellValueFactory(new PropertyValueFactory("matricule"));
            nom.setCellValueFactory(new PropertyValueFactory("nome"));
            prenCol.setCellValueFactory(new PropertyValueFactory("prenome"));
            dueCol.setCellValueFactory(new PropertyValueFactory("dues"));
            phone.setCellValueFactory(new PropertyValueFactory("num_telephone"));
            
            //TABLE TWO .

            blMatCol.setCellValueFactory(new PropertyValueFactory("matricule"));
            blNom.setCellValueFactory(new PropertyValueFactory("nome"));
            blPrenCol.setCellValueFactory(new PropertyValueFactory("prenome"));
            blDueCol.setCellValueFactory(new PropertyValueFactory("dues"));
            blPhone.setCellValueFactory(new PropertyValueFactory("num_telephone"));
            
            
        
        
        });
        
   
    }    
    
}*/
