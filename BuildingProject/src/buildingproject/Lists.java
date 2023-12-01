
package buildingproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Parent;

/**
 *
 * @author RJS
 */
public class Lists {
    public static ObservableList<Product> list1 = FXCollections.observableArrayList();
    public static ObservableList<Product> list2 = FXCollections.observableArrayList();
    public static int pointerOfProduct = 1;
    public static ObservableList<Product> list3 = FXCollections.observableArrayList();
    public static ObservableList<Product> list4 = FXCollections.observableArrayList();
    public static int pointerOfDealers = 1;
    
    public static ObservableList<Product> products(){
        if(Lists.pointerOfProduct == 1){
            return DataBase.fetchAllProducts("Export");
        }else{
            return DataBase.fetchAllProducts("Import");
        }
    }
            
            
           

    public Lists() {
    }
    
    public static void exit(Node n){
        n.getScene().getWindow().hide();
    }
    
    
}
