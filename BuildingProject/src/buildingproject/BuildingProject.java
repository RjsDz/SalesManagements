
package buildingproject;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author ANIS INFO
 */
public class BuildingProject extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLAddNewProduct.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("FXMLAuthToken.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLSearch.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLAddDealer.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLDocumant.fxml"));
        
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLBlackList.fxml"));
        
        FileEdit.allDirs();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.getIcons().add(new Image("images\\bldc.png"));
        
        
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
