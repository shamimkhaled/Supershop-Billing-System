
package supershop;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class BillingReportController implements Initializable {

    @FXML
    private ComboBox<String> productComboBox;
    @FXML
    private ComboBox<String> qtyComboBox;
    @FXML
    private TableView<Customer> salesTableView;
    @FXML
    private TableColumn<Customer, String> custIdColumn;
    @FXML
    private TableColumn<Customer, String> custNameColumn;
    @FXML
    private TableColumn<Product, String> productNameColumn;
    @FXML
    private TableColumn<Product, Double> costColumn;
    @FXML
    private TableColumn<Integer, Integer> quantityColumn;
    @FXML
    private TableColumn<Double, Double> totalColumn;
    @FXML
    private Label totalCostLabel;

     ObservableList <Customer> billing = FXCollections.observableArrayList();
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList <String> comboProduct = FXCollections.observableArrayList("Colgate", "Coca Cola", "Sprite");

        ObservableList <String> quantityList = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6");
   
        productComboBox.setItems(comboProduct);
        
        qtyComboBox.setItems(quantityList);
    }  


    @FXML
    private void addItemsAction(ActionEvent event) {
                
      

    }

    @FXML
    private void saveAndExitAction(ActionEvent event) {
    }

    @FXML
    private void printViewAction(ActionEvent event) {
    }

    @FXML
    private void deleteButtonAction(ActionEvent event) {
    }
    
}
