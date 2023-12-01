package buildingproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;


public class FXMLStatController implements Initializable {

    @FXML
    private PieChart pC;

    @FXML
    private PieChart pF;
    
    public void dataDisplay(){
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList(
        new PieChart.Data("Payments", DataBase.statistics().get(0)),
        new PieChart.Data("Dues", DataBase.statistics().get(1)));
        pF.setData(data);
        
        ObservableList<PieChart.Data> dataTwo = FXCollections.observableArrayList(
        new PieChart.Data("Payments", DataBase.statistics().get(2)),
        new PieChart.Data("Dues", DataBase.statistics().get(3)));
        pC.setData(dataTwo);
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(()->{
            dataDisplay();
        
        });
        
        
        
    }    
    
}
